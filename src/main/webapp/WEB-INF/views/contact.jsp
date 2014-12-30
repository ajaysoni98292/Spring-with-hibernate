<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Contact Details</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>" />
<script src="<c:url value="/resources/javascript/jquery-2.1.1.js"/>"></script>
<script src="<c:url value="/resources/javascript/jquery-ui-1.10.4.min.js"/>"></script>
<script src="<c:url value="/resources/javascript/bootstrap.min.js"/>"></script>
</head>
<body>

	<h2>Contact Manager</h2>
	<a href="/login"> Logout</a>
	<form:form method="post" action="add" commandName="contact">

		<table>
			<tr>
				<td><form:label path="firstName">
						<spring:message code="label.firstName" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message code="label.lastName" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message code="label.email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">
						<spring:message code="label.telephone" />
					</form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.addcontact"/>" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty contactList}">
		<h3>Contacts</h3>
		<table class="data">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${contactList}" var="contact">
				<tr>
					<td>${contact.firstName} ${contact.lastName}</td>
					<td>${contact.email}</td>
					<td>${contact.telephone}</td>
					<td><a href="user/delete/${contact.id}">delete</a></td>
					<br>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>