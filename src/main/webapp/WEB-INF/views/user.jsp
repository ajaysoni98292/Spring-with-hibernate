<%--
  Created by IntelliJ IDEA.
  User: ajay
  Date: 19/12/14
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commontags.jspf" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <title>Users</title>
    <%@include file="commonCss.jspf" %>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid margin-top-from-page">
    <div class="add-user-button">
        <h3>
            <spring:message code="label.usersList"/><a href="/user/create"><spring:message code="label.addUser"/></a>
        </h3>
    </div>

    <table id="usersList" class="table" cellpadding="0" cellspacing="0">
        <thead>
        <tr class="table-header-background">
            <th><spring:message code="label.hash"/></th>
            <th><spring:message code="label.name"/></th>
            <th><spring:message code="label.email"/></th>
            <th><spring:message code="label.role"/></th>
            <th colspan="3" width="50%" style="text-align: center;"><spring:message code="label.action"/></th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <div id="smart-paginator" class="paginator"></div>
    <input type="hidden" id="userCount" name="userCount" value="${userCount}">
</div>

<%@include file="commonJs.jspf" %>
<script src="/resources/javascript/user.js"></script>

</body>
</html>