
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" style="color: blue; background: yellow;">
	function confirmDelete() {
		return confirm("Are you sure,you want to delete?");
	}

	function goBack() {
		window.history.back();
	}
</script>
</head>

<font color="green">${delete}</font>
</br>
<body>
	<h1>VIEW ACCOUNTS</h1>
	</br>
	<div class="dropdown" style="float: left; width: 20%">
		<button class="dropbtn">Select Role</button>
		<div class="dropdown-content">
			<a href="/accountsByRole?role=Admin">Admin </a> <a
				href="/accountsByRole?role=CaseWorker">CaseWorker</a>
		</div>
	</div>
	</br>
</br>
</br>
</br>
</br>

	<table border="1" style="font-family: sans-serif;">





		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>email</th>
			<th>Passwd</th>
			<th>DOB</th>
			<th>Gender</th>
			<th>SSN</th>
			<th>PhoneNo</th>
			<th>Role</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${accounts}" var="account">
			<tr>
				<td>${account.firstName }</td>
				<td>${account.lastName }</td>
				<td>${account.email}</td>
				<td>${account.passwd }</td>
				<td>${account.dob }</td>
				<td>${account.gender }</td>
				<td>${account.ssn }</td>
				<td>${account.phoneNo }</td>
				<td>${account.role }</td>

				<td><a href="editAccount?empId=${account.empId}">Edit</a> <a
					href="deleteAccount?empId=${account.empId}"
					onclick="return confirmDelete()">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</br>
	</br>
	<a href="/"> Register Here </a>
  
  </br></br>
	<button onclick="goBack()">Go Back</button>
</body>
</html>