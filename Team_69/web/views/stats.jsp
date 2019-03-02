<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistics</title>

<style>
#students td, #students th {
  border: 1px solid #ddd;
  padding: 8px;
}

#students tr:nth-child(even){background-color: #f2f2f2;}

#students tr:hover {background-color: #ddd;}

#students th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>

</head>
<body>

Statistics
<form method="GET" action="../ProfessorController">
	<input type="submit" name="flag" value="StudentStats">
	<c:set var="professorStatistics" value="${requestScope.professorStatistics}"/>

	<br>
	<br>
	<br>
	
	<table id = "students">	
	<tr>
		<th>Number Of Students In Class</th>
		<th>Number Of Students who took Quiz</th>
	</tr>
	<tr>
		<td> ${professorStatistics.students} </td>
		<td>${professorStatistics.studentsGaveQuiz}</td>
	</tr>	
	</table>
	
	<c:forEach items="${professorStatistics.studentCalculatedScores}" var="scoreList">
			<tr scope="row">
			<c:out value="${scoreList}"></c:out>
			</tr>
    </c:forEach>
	
	
</form>

</body>
</html>