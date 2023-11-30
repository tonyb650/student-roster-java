<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${ thisClass.className }"/></title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
	<h1>Students Taking <c:out value="${ thisClass.className }"/></h1>
		<a href="/dorms">Dashboard</a>
		<table class="table border">
			<thead>
				<tr>
					<th>Student</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${ thisClass.students }">
					<tr>
						<td>
							<a href="/students/${ student.id }/detail"><c:out value="${student.studentName}"></c:out></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>