<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$('#psd').datepicker({
			dateFormat : 'yy-mm-dd'
		}).val();
	});
	$(function() {
		$('#ped').datepicker({
			dateFormat : 'yy-mm-dd'
		}).val();
	});
	function goBack() {
		window.history.back();
	}
</script>
<body>
	<h2>Create New Plan</h2>
	<font color="green">${success}</font>
	<font color="red">${failed}</font>
	<form:form action="/createPlan" method="post" modelAttribute="plan">
		<table>
			<tr>
				<td>Plan Name</td>
				<td><form:input path="planName" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td>Plan Start Date</td>
				<td><form:input path="planStartDate" id="psd" /></td>
				<form:hidden path="pid" />
			</tr>
			<tr>
				<td>Plan End Date</td>
				<td><form:input path="planEndDate" id="ped" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="CreatePlan" /></td>
			</tr>
		</table>
		</br>

	</form:form>
  
  </br></br>
	<button onclick="goBack()">Go Back</button>
</body>
</html>