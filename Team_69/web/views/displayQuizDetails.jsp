<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz Details</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="js/getQuizList.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>

<body>
	<%String pathWebcontent = request.getContextPath();%> 
	
	<div class="row" align="center" style="padding-top: 25px;">
		<div class="col-md-10 details">
			<h2>Quiz Details</h2>
			<br>
		</div>
		<div class="col-md-2 details">
			<a href="<%=pathWebcontent %>/ProfessorController?flag=professorLanding" class="btn btn-primary">Home</a>
			<br>
		</div>
	</div>

	<c:choose>
		<c:when test="${empty requestScope.quizList}">
			<blockquote class="blockquote text-center">
				<p class="mb-0" style="color: red">No Quiz added.</p>
			</blockquote>
			<blockquote class="blockquote text-center">
				<a href="<%=pathWebcontent %>/views/quizDetails.jsp">Create New Quiz </a>
			</blockquote>
		</c:when>
		
		<c:otherwise>
			<table class="table table-hover">
				<tbody>
				<tr>	
					<th scope="col">Name</th>
					<th scope="col">Quiz Details</th>
					<th scope="col">Published Quizzes</th>
					<th scope="col">Add Questions in quiz</th>
					<th scope="col">Stats</th>
				</tr>
				<c:forEach items="${requestScope.quizList}" var="quiz">
					<tr scope="row">
						<td><c:out value="${quiz.quizName}"></c:out></td>	
						<td>
							<a href="<%=pathWebcontent %>/ProfessorController?flag=viewQuiz&id=${quiz.quizId}&quizName=${quiz.quizName}">View Quiz</a>			
						</td>
						<td>
							<c:choose>
							   <c:when test="${quiz.isPublished}">
							     <p style="color:green">Published</p>
							   </c:when>
							   <c:otherwise>
							     <a href="<%=pathWebcontent %>/ProfessorController?flag=publishQuiz&id=${quiz.quizId}"> Publish Quiz</a>	
							   </c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
							   <c:when test="${quiz.isPublished}">
							     	<p style="color:red">Cannot Add - Quiz Published</p>
							   </c:when>
							   <c:otherwise>
							   		<a href="<%=pathWebcontent %>/ProfessorController?flag=addQuestionInQuiz&id=${quiz.quizId}">Add Questions</a>
							   </c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
							   <c:when test="${quiz.isPublished}">
							     <a href="<%=pathWebcontent %>/Statistic?flag=quizStats&id=${quiz.quizId}">View Stats</a>
							   </c:when>
							   <c:otherwise>
							     <p style="color:red">No Stats Available</p>
							   </c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>