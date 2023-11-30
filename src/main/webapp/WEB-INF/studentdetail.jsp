<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${ student.studentName }"/></title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${ student.studentName }"/>'s classes. Student ID<c:out value="${student.id }"></c:out></h1>
		<a href="/dorms">Dashboard</a>
		
		
		<form action="/students/${ student.id }/addclass" method="post">
			<input type="hidden" name="_method" value="put" />
			<label name="id" for="classId" class="form-label">Classes</label>
			<select name="id" id="classId">
				<c:forEach var="eachClass" items="${ allClasses }">
					<option value="${ eachClass.id }"><c:out value="${ eachClass.className }"/>
				</c:forEach>
			</select>
			<input type="submit" value="Add ${ student.studentName } to this class"/>
		</form>
		
	
		<table class="table">
			<thead>
				<tr>
					<th>Class Name</th>
					<th>Action</th>			
				</tr>
			</thead>
			<tbody>
				<c:forEach var="classWithStudent" items="${ student.classes }">
					<tr>
						<td><c:out value="${ classWithStudent.className }"></c:out></td>
						<td>

							
							<a href="/classes/${ classWithStudent.id }/remove/${ student.id }">Drop</a>
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
	</div>

</body>
</html>