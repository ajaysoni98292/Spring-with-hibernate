/**
 *
 * @author ajay
 */


$(document).ready(function () {
    var createUserObj = new createUser();
    createUserObj.init();
});

var createUser = function () {
    privateMethod = {
        attachEventHandler: function () {
            $("#createUserForm").validate({
                rules: {
                    firstName: {
                        required: true
                    },
                    lastName: {
                        required: true
                    },
                    password: {
                        required: true
                    },
                    email: {
                        required: true,
                        email: true
                    }
                },
                messages: {
                    firstName: {
                        required: MESSAGE_CONSTANT.PROVIDE_FULL_NAME
                    },
                    lastName: {
                        required: MESSAGE_CONSTANT.PROVIDE_FULL_NAME
                    },
                    password: {
                        required: MESSAGE_CONSTANT.PROVIDE_FULL_NAME
                    },
                    email: {
                        required: MESSAGE_CONSTANT.PROVIDE_EMAIL_ID,
                        email: MESSAGE_CONSTANT.PROVIDE_VALID_EMAIL_ID
                    }
                },
                errorElement: "div",
                wrapper: "div",
                errorPlacement: function (error, element) {
                    offset = element.offset();
                    error.insertAfter(element);
                    error.addClass('errorbox1');
                }

            });
        },
        displayMessages: function () {
            var notifications = new notification();
            notifications.init();
        }
    };
    return {
        init: function () {
            privateMethod.attachEventHandler();
            privateMethod.displayMessages();
        }
    };
};


