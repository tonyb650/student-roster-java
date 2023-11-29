<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Student</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>New Student</h1>
		<a href="/dorms">Dashboard</a>
		<form:form class="form" modelAttribute="modelStudent" action="/students/new" method="post">
			<form:label path="studentName" for="studentName" class="form-label">Student:</form:label>
			<form:errors path="studentName" class="text-danger"/>
			<form:input path="studentName" type="text" id="studentName" class="form-control"/>
			<form:select path="dorm" name="dorm" id="dorm" class="form-control">
				<c:forEach var="dorm" items="${dorms}">
					<option value="${ dorm.id }"><c:out value="${ dorm.dormName }"/></option>
				</c:forEach>
			</form:select>
			<input type="submit" class="btn btn-secondary" value="Add Student" />
		</form:form>
	</div>
</body>
</html>