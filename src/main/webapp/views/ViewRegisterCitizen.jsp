<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" style="color: blue; background: yellow;">
	function confirmDelete() {
		return confirm("Are you sure,you want to delete?");
	}

	function goBack() {
		window.history.back();
	}
</script>
</script>
</head>
<body>
	<h2>View Registered Citizen</h2>
	<table border="1" style="font-family: sans-serif;">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date Of Birth</th>
			<th>Gender</th>
			<th>SSN No</th>
			<th>Phone No</th>
			<th>Email Id</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${applicants}" var="applicants">
			<tr>
				<td>${applicants.firstName }</td>
				<td>${applicants.lastName }</td>
				<td>${applicants.dob}</td>
				<td>${applicants.gender}</td>
				<td>${applicants.ssn}</td>
				<td>${applicants.phNo}</td>
				<td>${applicants.email}</td>

				<td><a
					href="editCitizen?applicationRegNo=${applicants.applicationRegNo}">Edit</a>
			</tr>
		</c:forEach>
	</table>
	</br>
	</br>
	<button onclick="goBack()">Go Back</button>
</body>
</html>