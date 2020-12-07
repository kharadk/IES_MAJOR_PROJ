<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
	</h2>
	Income Details
	</h1>

	<form:form action="/saveIncomeDetails" method="post"
		modelAttribute="DcIncome">
    CaseId: </br>
		<input name="caseId" value=${DcIncome.caseId } readonly="readonly"
			class="required">
		</br>
				Individual Name: </br>
		<input name="name" value=${DcIncome.name } readonly="readonly"
			class="required">
		</br>
           Is Working:</br>
		<form:radiobutton path="working" value="Y" />Yes
        <form:radiobutton path="working" value="N" />No</br>
           
           Other Income: </br>
           $
           <form:input path="income" /><br/>
		<input type="submit" value="NEXT" />
	</form:form>


</body>
</html>