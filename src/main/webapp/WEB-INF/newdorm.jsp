<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Dorm</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>New Dorm</h1>
		<a href="/dorms">Dashboard</a>
		<table class="table border">
			<form:form action="/dorms/new" modelAttribute="dorm" method="post">
				<tbody>				
					<tr>
						<td><form:label path="dormName" class="form-label h4" for="dormName">Name:</form:label></td>
						<td>
							<form:errors path="dormName" class="text-danger"/><br>
							<form:input path="dormName" class="form-control" type="text" id="dormName" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" class="btn btn-secondary" value="Add"/>
						</td>
					</tr>
				</tbody>
			</form:form>
		</table>
	</div>
</body>
</html>