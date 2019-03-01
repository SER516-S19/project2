<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../ProfessorController" method="post">
		<label for="quesId">Enter Question ID:</label>
		<input id="quesId" name="quesId" >
		<br>
		
		<label for="quizId">Enter Quiz ID:</label>
		<input id="quizId" name="quizId" >
		<br>
		
		<label for="quizName">Enter quiz name:</label>
		<input id="quizName" name="quizName" >
		<br>
		
	    <input type="submit" value="EditQuestion" name="flag" class="btn btn-primary" />
	</form>
</body>
</html>