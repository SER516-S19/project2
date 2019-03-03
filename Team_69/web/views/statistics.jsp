<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistics</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
#students td, #students th {
	border: 1px solid #ddd;
	padding: 8px;
}

#students tr:nth-child(even) {
	background-color: #f2f2f2;
}

#students tr:hover {
	background-color: #ddd;
}

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
	
	<%String pathWebcontent = request.getContextPath();%> 
	<div class="row" align="center" style="padding-top: 25px;">
		<div class="col-md-2 details">
		</div>
		<div class="col-md-8 details">
			<h2>Statistics</h2>
			<br>
		</div>
		<div class="col-md-2 details">
			<a href="<%=pathWebcontent %>/ProfessorController?flag=fetchQuizList" class="btn btn-primary">Back</a>
			<br>
		</div>
	</div>
	
	
	<div class="row" >
		<div class="col-md-12 details" align="center">
			<p>Total number of students in the class : <b>${professorStatistics.students}</b></p>
			<p>Total number of students who took the quiz : <b>${professorStatistics.studentsGaveQuiz}</b></p>
		<hr>
		</div>
		<div class="col-md-1 details">
		</div>
		<div class="col-md-5 details">
			<c:if test="${professorStatistics.statOfEachQuestion.size() > 0}">
				<H2>Question Statistics</H2>
				<table id="students">
					<tr>
						<th>Question Number</th>
						<th>Correct answer given by</th>
					</tr>
					<c:forEach var="entry"
						items="${professorStatistics.statOfEachQuestion}">
						<tr scope="row">
							<td scope="column"><c:out value="Question : ${entry.key}"></c:out></td>
							<td scope="column"><c:out value="${entry.value} Students"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${professorStatistics.statOfEachQuestion.size() <= 0}">
				<H2>Question Statistics</H2>
				<p>No student has taken the quiz yet!</p>
			</c:if>
		</div>
		<div class="col-md-5 details">
		<H2>Students Statistics</H2>
		<c:if test="${professorStatistics.studentsGaveQuiz > 0}">
			<table id="students">
				<tr>
					<th>User ID</th>
					<th>User Name</th>
					<th>Score</th>
				</tr>
				<c:forEach items="${professorStatistics.studentCalculatedScores}"
					var="scoreList">
					<tr scope="row">
						<td scope="column"><c:out
								value="${scoreList.getUser().getEmail()}"></c:out></td>
						<td scope="column"><c:out
								value="${scoreList.getUser().getUser_name()}"></c:out></td>
						<td scope="column"><c:out value="${scoreList.getScore()}"></c:out>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		</div>
	</div>
		
	</form>
</body>
</html>