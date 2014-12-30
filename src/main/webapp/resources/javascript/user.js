$(document).ready(function () {
    var userObject = new user();
    userObject.init();
});

var user = function () {
    privateVar = {
        pageIndex: 0,
        numberOfRecordsToFetch: 3  ,
        serialNumber: 1,
        paginationInit: true
    };

    privateMethod = {

        setupPaginator: function (totalRecordCount, initPageNumber) {
            $('#smart-paginator').smartpaginator({
                totalrecords: totalRecordCount,
                recordsperpage: 3,
                initval: initPageNumber,
                next: TEXT_CONSTANT.NEXT,
                prev: TEXT_CONSTANT.PREV,
                first: TEXT_CONSTANT.FIRST,
                last: TEXT_CONSTANT.LAST,
                theme: 'black',
                controlsalways: true,
                onchange: privateMethod.handlePaginationClick
            });
        },
        pagination: function (resultJson) {
            $("tbody").empty();
            if (resultJson.length == 0) {
                $('<tr>').html("<td colspan=5><div class='alert alert-danger marb5'>" + MESSAGE_CONSTANT.MESSAGE_NO_USER_FOUND + "</div></td>").appendTo("tbody");
            } else {
                $.each(resultJson, function (index) {
                    $('<tr>').html("<td>" + privateVar.serialNumber++ + "</td><td>" + resultJson[index].firstName + " " + resultJson[index].lastName
                    + "</td><td>" + resultJson[index].email + "</td><td>" + resultJson[index].role.roleName + "</td>"
                    + "<td class='text-center'><a href='/user/edit/" + resultJson[index].id + "' class='btn btn-sm btn-primary' style='text-decoration: none'><span class='glyphicon glyphicon-pencil'></span> " + TEXT_CONSTANT.EDIT + "</a>"
                    + " <a href='#' name='" + resultJson[index].id + "' class='btn btn-sm btn-danger' style='text-decoration: none'><span class='glyphicon glyphicon-trash'></span> " + TEXT_CONSTANT.DELETE + "</a> </td>")
                        .appendTo("tbody");

                    $("a[name='" + resultJson[index].id + "']").click(function () {
                        privateMethod.deleteUser($(this).prop('name'));
                    });

                });
            }
        },
        handlePaginationClick: function (newPageIndex) {
            privateVar.pageIndex = newPageIndex;
            privateVar.serialNumber = (privateVar.pageIndex * privateVar.numberOfRecordsToFetch) - (privateVar.numberOfRecordsToFetch - 1);
            if (privateVar.serialNumber < 1) {
                privateVar.serialNumber = 1;
            }
            privateMethod.getUsersJson();
        },
        getUsersJson: function () {

            var url = URL_CONSTANT.LIST_PAGINATED_USERS_URL + "?" + "startIndex=" + (privateVar.serialNumber - 1) +
                "&numberOfRecordsToFetch=" + privateVar.numberOfRecordsToFetch;
            $.ajax({
                url: url,
                dataType: "json",
                success: function (resultJson) {
                    privateMethod.setupPaginator(resultJson.totalNumberOfRecords, privateVar.pageIndex);
                    privateMethod.pagination(resultJson.listOfRecords);
                }
            });
        },
        deleteUser: function (id) {
            var url = URL_CONSTANT.DELETE_USER_URL;
            var token = $("meta[name='_csrf']").attr("content");
            $.ajax({
                url: url,
                type: "POST",
                data: {"_csrf": token, "id": id},
                dataType: "json",
                success: function (resultCount) {
                    privateMethod.setupPaginator(resultCount, privateVar.pageIndex);
                    privateMethod.handlePaginationClick(privateVar.pageIndex);
                }
            });
        }
    };

    return {
        init: function () {
            privateMethod.getUsersJson();
        }
    };
};


