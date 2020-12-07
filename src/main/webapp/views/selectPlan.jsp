<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
input[type=submit] {
	width: 10%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</head>
<body>

	<div
		style="border-radius: 1px; background-color: #f2f2f2; padding: 20px; margin: 8px 0;">
		<h1>Select Plan</h1>
		<form:form action="saveDcPlan" method="post" modelAttribute="DcPlan">
	  CaseId: </br>
			<input name="caseId" value=${DcPlan.caseId } readonly="readonly"
				class="required">
			</br>
	 First Name: </br>
			<input name="firstName" value=${DcPlan.firstName } readonly="readonly" class="required" >
			</br>			  
	Select Plan:</br>
			<td><form:select path="plans" id="cid">
					<form:option value="0">SELECT</form:option>
					<form:options items="${planMap}"></form:options>
				</form:select></td>
			</br>
			<input style="text-align: center;" type="submit" value="Next" />
		</form:form>

	</div>
</body>
</html>