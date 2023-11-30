<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${ dorm.dormName }"/> Dorm</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${ dorm.dormName }"/> Students. Dorm ID<c:out value="${dorm.id }"></c:out></h1>
		<a href="/dorms">Dashboard</a>
		
		
		<form action="/students/update/${ dorm.id }" method="post">
			<input type="hidden" name="_method" value="put" />
			<label name="id" for="studentId" class="form-label">Students</label>
			<select name="id" id="studentId">
				<c:forEach var="eachStudent" items="${ allStudents }">
					<option value="${ eachStudent.id }"><c:out value="${ eachStudent.studentName }"/>
						<c:if test="${ eachStudent.dorm != null }">
							(<c:out value="${ eachStudent.dorm.dormName }"/>)
						</c:if>
					 </option>
				</c:forEach>
			</select>


			<input type="submit" value="Add to this dorm"/>
		</form>
		
	
		<table class="table">
			<thead>
				<tr>
					<th>Student</th>
					<th>Action</th>			
				</tr>
			</thead>
			<tbody>
				<c:forEach var="studentInDorm" items="${ dorm.students }">
					<tr>
						<td>
							<a href="/students/${ studentInDorm.id }/detail"><c:out value="${ studentInDorm.studentName }"/></a>
						</td>
						<td>
							<form action="/students/${ studentInDorm.id }/remove/${ dorm.id }" method="post">
								<input type="submit" class="btn btn-link" value="Remove from this dorm" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
	</div>

</body>
</html>