<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {
	font-family: Arial;
}

* {
	box-sizing: border-box;
}

form.example input[type=text] {
	padding: 10px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

form.example button {
	float: left;
	width: 20%;
	padding: 10px;
	background: #2196F3;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

form.example button:hover {
	background: #0b7dda;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 20%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
</head>
<body>



	<form class="example" action="/searchApplication"
		style="margin: auto; max-width: 300px">
		<input type="text" placeholder="Enter Application No" name="appId">
		<button type="submit" onclick="dispay()">
			<i class="fa fa-search"></i>
		</button>

		<font color="red" style="text-align: center;">${SearchFail}</font>
	</form>
	</br>

	</br>



	<c:if test="${not empty RegistredApplicant}">
		<div>
			<h2 style="color: red; text-align: center">Create Case</h2>

			<form:form
				action="createCase"
				method="post" modelAttribute="RegistredApplicant">
				
				<form:hidden path="caseId" />
							
				  Applicant Id  : <input name="applicationRegNo"
					value='<c:out value="${RegistredApplicant.applicationRegNo}"></c:out>'
					readonly="readonly" class="required">
				</br>
					
					Name &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; :<input name="firstName"
					value='<c:out value="${RegistredApplicant.firstName}"></c:out>'
					readonly="readonly" class="required">
				</br>
                    DOB &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input
					name="dob"
					value='<c:out value="${RegistredApplicant.dob}"></c:out>'
					readonly="readonly" class="required">
				</br>
                    Gender &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input
					name="gender"
					value='<c:out value="${RegistredApplicant.gender}"></c:out>'
					readonly="readonly" class="required">
				</br>
                    SSN&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input
					name="ssn"
					value='<c:out value="${RegistredApplicant.ssn}"></c:out>'
					readonly="readonly" class="required">
				</br>
                    Phone No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input
					name="phNo"
					value='<c:out value="${RegistredApplicant.phNo}"></c:out>'
					readonly="readonly" class="required">
				</br>
                    Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input
					name="email"
					value='<c:out value="${RegistredApplicant.email}"></c:out>'
					readonly="readonly" class="required">
				</br>

        

				<input style="text-align: center;" type="submit" value="Create Case" />

			</form:form>
		</div>

	</c:if>

	</div>

	</br>
	</br>
	<button onclick="goBack()">Go Back</button>

</body>
</html>