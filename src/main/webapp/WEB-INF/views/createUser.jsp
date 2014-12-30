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
    <title>Add User</title>
    <%@include file="commonCss.jspf" %>
    <link href="/resources/css/jquery_notification.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid margin-top-from-page">
    <div class="row">

        <div class="col-md-10">
            <input type="text" id="successMessage" value="${successMessage}" style="display: none;"/>
            <%-- <c:if test="${!empty successMessage}">
                <div id="successMessage" value="${successMessage}"></div>
            </c:if> --%>
            <form:form id="createUserForm" method="post" action="/user/create"
                       commandName="user" class="form  form-horizontal" role="form">
                <div class="form-group required">
                    <spring:message code="label.firstName" var="firstName"/>
                    <label class="col-sm-2 control-label">${firstName}</label>

                    <div class="col-md-2">
                        <form:input path="firstName" type="text" class="form-control"
                                    id="firstName" placeholder="${firstName}" value=""/>
                        <span class="help-inline  errorMessage" id="firstNameMessage" value=""></span>
                        <form:errors path="firstName" cssClass="help-inline  errorMessage"/>
                    </div>
                </div>

                <div class="form-group required">
                    <spring:message code="label.lastName" var="lastName"/>
                    <label class="col-sm-2 control-label">${lastName}</label>

                    <div class="col-md-2">
                        <form:input path="lastName" type="text" class="form-control"
                                    id="lastName" placeholder="${lastName}" value='${user.lastName}'/>
                        <span class="help-inline  errorMessage" id="lastNameMessage" value=""></span>
                        <form:errors path="lastName" cssClass="help-inline  errorMessage"/>
                    </div>
                </div>
                <div class="form-group required">
                    <spring:message code="label.email" var="email"/>
                    <label class="col-sm-2 control-label">${email}</label>

                    <div class="col-md-2">
                        <form:input path="email" type="email" class="form-control"
                                    id="email" placeholder="${email}" value=""/>
                        <span class="help-inline  errorMessage" id="emailMessage" value=""></span>
                        <form:errors path="email" cssClass="help-inline  errorMessage"/>
                    </div>
                </div>
                <div class="form-group required">
                    <spring:message code="label.password" var="password"/>
                    <label class="col-sm-2 control-label">${password}</label>

                    <div class="col-md-2">
                        <form:input path="password" type="password" class="form-control"
                                    id="password" placeholder="${password}" value=""/>
                        <span class="help-inline  errorMessage" id="passwordMessage" value=""></span>
                        <form:errors path="password" cssClass="help-inline  errorMessage"/>
                    </div>
                </div>
                <div class="form-group required">
                    <label class="col-sm-2 control-label"><spring:message
                            code="label.role"/></label>

                    <div class="col-md-2">
                        <form:select path="role.id" id="role" class="form-control">
                            <form:options items="${roleMap}"/>
                        </form:select>
                        <span class="help-inline  errorMessage" id="roleMessage" value=""></span>
                        <form:errors path="role" cssClass="help-inline  errorMessage"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2">
                        <button id="submit"
                                class="btn btn-default margin-left-submit-button">
                            <spring:message code="label.submit"/>
                        </button>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form:form>
        </div>
    </div>
</div>

<input type="hidden" id="successMessage" name="successMessage" value="${successMessage}"/>
<input type="hidden" id="errorMessage" name="errorMessage" value="${errorMessage}"/>

<%@include file="commonJs.jspf" %>
<script src="/resources/javascript/jquery_notification_v.1.js"></script>
<script src="/resources/javascript/notifications.js"></script>
<script src="/resources/javascript/createUser.js"></script>

</body>
</html>