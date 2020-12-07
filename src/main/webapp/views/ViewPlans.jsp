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
</head>
<body>
	<h2>Create Plans</h2>
	<table border="1" style="font-family: sans-serif;">
		<tr>
			<th>Plan Name</th>
			<th>Description</th>
			<th>Plan Start Date</th>
			<th>Plan End Date</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${plans}" var="plan">
			<tr>
				<td>${plan.planName }</td>
				<td>${plan.description }</td>
				<td>${plan.planStartDate}</td>
				<td>${plan.planEndDate}</td>

				<td><a href="editPlan?pid=${plan.pid}">Edit</a>
				<a href="deletePlan?pid=${plan.pid}" onclick="return confirmDelete()">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	</br></br>
	<button onclick="goBack()">Go Back</button>
</body>
</html>