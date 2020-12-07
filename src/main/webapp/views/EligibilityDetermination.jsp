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
	<h2>ELIGIBILITY DETERMINATION</h2>

	<form:form action="dermineEligibility" method="get">
	 &nbsp;&nbsp; CaseId: </br></br>
		&nbsp;&nbsp;<input name="caseId" value=${caseId } readonly="readonly"
			class="required">
		</br>
		</br>
		<input type="submit" value="ElDetermination">
	</form:form>
</body>
</html>