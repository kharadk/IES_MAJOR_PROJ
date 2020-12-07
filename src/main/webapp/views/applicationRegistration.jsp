<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet"
href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function() {
		$('#dob').datepicker({
			dateFormat : 'yy-mm-dd'
		}).val();
	});

	$(document).ready(function() {
		$('#ssnid').blur(function() {
			$("#errMsg").text("");
			$.ajax({
				method : 'GET',
				url : "isValidSSN?ssn=" + $('#ssnid').val(),
				success : function(data) {
					if (data == "INVALID" ) {
						$("#errMsg").text("Please Provide Correct SSN");
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
<body>

	<h2>Application Registration</h2>
	<font color="green">${success}</font>
	<font color="red">${failed}</font>
	<form:form action="/appRegister" method="post"
		modelAttribute="application">
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
				<td>Date Of Birth</td>
				<td><form:input path="dob" id="dob" /></td>
				<form:hidden path="applicationRegNo" />
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:radiobutton path="gender" value="male" />Male <form:radiobutton
						path="gender" value="female" />Female</td>
			</tr>
			<tr>
				<td>SSN No:</td>
				<td><form:input path="ssn" id="ssnid" /> <span id="errMsg"
					style="color: red;" /></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><form:input path="phNo" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" id="RegBtn" /></td>
			</tr>
		</table>
		</br>

	</form:form>
	
	</br></br>
	<button onclick="goBack()">Go Back</button>
</body>
</html>