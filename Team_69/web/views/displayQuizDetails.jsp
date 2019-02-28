<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
	<script src="js/getQuizList.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	
<table class="table table-hover">
	<tbody>
	<tr>	
		<th scope="col">Name</th>
		<th scope="col">Quiz Details</th>
		<th scope="col">Published Quizzes</th>
		<th scope="col">Add Questions in quiz</th>
	</tr>
	<c:forEach items="${requestScope.quizList}" var="quiz">

	<tr scope="row">
		<td><c:out value="${quiz.quizName}"></c:out></td>	
		<td>
		<%String pathWebcontent=request.getContextPath();%>
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
		<td><a href="<%=pathWebcontent %>/ProfessorController?flag=addQueInQuiz&id=${quiz.quizId}">Add Questions</a></td>
		
	</tr>
	</c:forEach>
</tbody>
</table>
	
</body>
</html>