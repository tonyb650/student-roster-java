<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>All Classes</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
	<h1>All Classes</h1>
		<a href="/dorms">Dashboard</a>
		<table class="table border">
			<thead>
				<tr>
					<th>Class</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="thisClass" items="${ classes }">
					<tr>
						<td>
							<a href="/classes/${ thisClass.id }/detail"><c:out value="${thisClass.className}"></c:out></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>