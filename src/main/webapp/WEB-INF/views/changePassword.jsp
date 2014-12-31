<%--
  Created by IntelliJ IDEA.
  User: ajay
  Date: 12/31/2014
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commontags.jspf" %>

<html>
<head>
    <title>Change Password</title>
    <%@include file="commonCss.jspf" %>
    <link href="/resources/css/jquery_notification.css" type="text/css" rel="stylesheet">
</head>
<body>
<div>
    <form:form action="/user/change-password" commandName="changePassword" method="post" id="changePasswordForm">

        <div>
            <spring:message code="label.oldPassword" var="oldPassword"></spring:message>
            <label>${oldPassword}</label>
            <form:input path="oldPassword" type="password" id="oldPassword" placeholder="${oldPassword}"></form:input>
        </div>
        <div>
            <spring:message code="label.newPassword" var="newPassword"></spring:message>
            <label>${newPassword}</label>
            <form:input path="newPassword" type="password" id="newPassword" placeholder="${newPassword}"></form:input>
        </div>
        <div>
            <spring:message code="label.confirmPassword" var="confirmPassword"></spring:message>
            <label>${confirmPassword}</label>
            <form:input path="confirmPassword" type="password" id="confirmPassword" placeholder="${confirmPassword}"></form:input>
        </div>
        <div>
            <button id="submit"><spring:message code="label.submit"></spring:message></button>
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form:form>
</div>


<input type="hidden" id="successMessage" name="successMessage" value="${successMessage}"/>
<input type="hidden" id="errorMessage" name="errorMessage" value="${errorMessage}"/>

<%@include file="commonJs.jspf" %>
<script src="/resources/javascript/jquery_notification_v.1.js"></script>
<script src="/resources/javascript/notifications.js"></script>
<script src="/resources/javascript/changePassword.js"></script>
</body>
</html>
