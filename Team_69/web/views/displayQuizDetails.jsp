<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	



<table class="table">

<tbody>
<tr><th scope="col">ID</th><th scope="col">Name</th><th scope="col">Instructions</th></tr>
	<c:forEach items="${requestScope.quizList}" var="quiz">

	<tr>

		<tr scope="row"><td><c:out value="${quiz.quizId}"></c:out></td>

		<td><c:out value="${quiz.quizName}"></c:out></td>
		<td><c:out value="${quiz.quizInstructions}"></c:out></td>
		<td>
		<%String pathWebcontent1=request.getContextPath();%>
			<a href="<%=pathWebcontent1 %>/ProfessorController?flag=viewQuiz&id=${quiz.quizId}">View Quiz</a>			
		</td>
		<td>
		<%String pathWebcontent=request.getContextPath();%>
			<a href="<%=pathWebcontent %>/ProfessorController?flag=publishQuiz&id=${quiz.quizId}"> Publish Quiz</a>
				
		</td>
		
	</tr>
	</c:forEach>
</tbody>
</table>
	
</body>
</html>