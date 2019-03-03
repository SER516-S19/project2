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

<H1 align = center> Statictics</H1>

<form method="GET" action="../ProfessorController">


<c:if test="${professorStatistics.statOfEachQuestion.size() > 0}">
<H2>Question Stats</H2>
<table id = "students">	
			<tr>
				<th>Question Number</th>
				<th>Number of students who gave correct answer</th>
			</tr>
				<c:forEach var="entry" items="${professorStatistics.statOfEachQuestion}">
  					<tr scope="row">
					<td scope="column">
						<c:out value="${entry.key}"></c:out>
					</td>
					<td scope="column">
						<c:out value="${entry.value}"></c:out>
					</td>
					</tr>	
  				</c:forEach>
 </table>	
 </c:if>
 <c:if test="${professorStatistics.statOfEachQuestion.size() <= 0}">
 <H2>Question Stats</H2>
 <p>No student has taken the quiz yet!</p>
 </c:if>

<br>

<H2>Students Stats</H2>	
	<p> Total number of students in the class : ${professorStatistics.students}</p>
	<p>Total number of students took the quiz  : ${professorStatistics.studentsGaveQuiz}</p>
	
	<c:if test="${professorStatistics.studentsGaveQuiz > 0}">
		<table id = "students">	
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>Score</th>
			</tr>
	  	
		<c:forEach items="${professorStatistics.studentCalculatedScores}" var="scoreList">
			<tr scope="row">
			<td scope="column">
			<c:out value="${scoreList.getUser().getEmail()}"></c:out>
			</td>
			<td scope="column">
			<c:out value="${scoreList.getUser().getUser_name()}"></c:out>
			</td>
			<td scope="column">
			<c:out value="${scoreList.getScore()}"></c:out>
			</td>
			</tr>
    	</c:forEach>
		</table>
	 </c:if>
	
</form>

</body>
</html>