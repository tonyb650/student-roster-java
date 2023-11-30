<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Class</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>New Class</h1>
		<a href="/dorms">Dashboard</a>
		<table class="table border">
			<form:form action="/classes/new" modelAttribute="class" method="post">
				<tbody>				
					<tr>
						<td><form:label path="className" class="form-label h4" for="className">Name:</form:label></td>
						<td>
							<form:errors path="className" class="text-danger"/><br>
							<form:input path="className" class="form-control" type="text" id="className" />
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