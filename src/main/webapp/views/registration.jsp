<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datepicker').datepicker({
			dateFormat : 'yy-mm-dd'
		}).val();
	});
   
	$(document).ready(function() {
		$('#email').blur(function() {
			$("#errMsg").text("");
			$.ajax({
				method : 'GET',
				url : "isUniqueEmail?email=" + $('#email').val(),
				success : function(data) {
					if (data == "DUPLICATE") {
						$("#errMsg").text("Duplicate Email");
						$("#RegBtn").prop("disabled", true);
					} else {
						$("#RegBtn").prop("disabled", false);
					}
				}
			});
		});
	});

	function goBack() {
		window.history.back();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<h2>Account Registration</h2>

	<font color="green">${success}</font>
	<font color="red">${failed}</font>

	<form:form action="/userRegistration" method="post"
		modelAttribute="userAcc">
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" id="email" /> <span id="errMsg"
					style="color: red;" /></td>

			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="passwd" /></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><form:input path="dob" id="datepicker" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:radiobutton path="gender" value="male" />Male <form:radiobutton
						path="gender" value="female" />Female</td>
			</tr>
			<tr>
				<td>SSN NO</td>
				<td><form:input path="ssn" /></td>
			</tr>
			<tr>
				<td>Phone No</td>
				<td><form:input path="phoneNo" /></td>
				<form:hidden path="empId" />
			</tr>
			<tr>
				<td>Role</td>
				<td><form:select path="role">
						<form:option value="CaseWorker">Case_Worker</form:option>
						<form:option value="Admin">Admin</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" id="RegBtn" /></td>
			</tr>
		</table>
		</br>
		<a href="viewAccounts">View All Contact</a>
	</form:form>

  </br></br>
	<button onclick="goBack()">Go Back</button>
</body>
</html>