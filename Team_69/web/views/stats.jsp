<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistics</title>
</head>
<body>

Statistics
<form method="GET" action="../ProfessorController">
	<input type="submit" name="flag" value="StudentStats">
	<c:set var="professorStatistics" value="${requestScope.professorStatistics}"/>
	<br>
	No Of Students In Class : - ${requestScope.professorStatistics.students}
	<br>
	No Of Students Who Gave Quiz : - ${requestScope.professorStatistics.studentsGaveQuiz}

</form>

</body>
</html>