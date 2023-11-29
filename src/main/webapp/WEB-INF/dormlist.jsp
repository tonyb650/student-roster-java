<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>All Dorms</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
	<h1>Dorms</h1>
	<a href="/dorms/new">Add a new dorm</a> | 
	<a href="students/new">Add a new student</a>
		<table class="table">
			<thead>
				<tr>
					<th>Dorm</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dorm" items="${ dorms }">
					<tr>
						<td><c:out value="${dorm.dormName}"></c:out></td>
						<td><a href="/dorms/${ dorm.id }">See students</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>