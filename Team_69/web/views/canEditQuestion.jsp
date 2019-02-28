<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script type=âtext/javascriptâ src=âbootstrap/js/bootstrap.min.jsâ></script>

<style>
.borderexample
{
  width: auto;
  padding: 25px;
  margin: 25px;

}

</style>
<title>Edit Question</title>
</head>
<body>
<div align="center" >
	<H2>Please Edit the question</H2>
</div>

<%
  System.out.println("Hellohere");
  request.getAttribute("queAnsData");
  request.getAttribute("quesId");
  System.out.println(request.getAttribute("queAnsData"));
  System.out.println(request.getAttribute("quesId"));
  String question="Question1";
  String option1="Option1";
  String option2="Option2";
  String option3="Option3";
  String option4="Option4";
  int points=10;
  

  %>
	 <c:set var="quesId" value="${requestScope.quesId}"/>
  	<c:forEach items="${requestScope.queAnsData}" var="questionAnsList">
 	
 	
  	<c:choose>
		<c:when test="${questionAnsList[2][0].question.questionId eq quesId}">
			
			
	<form method="Post" action="../ProfessorController">
		<div class="borderexample" class="form-group">   
			
		<label for="question" >Question:</label>
		<textarea name="question" id="question" rows="6" cols="50"  class="form-control">${questionAnsList[2][0].question.question}</textarea>	
		<br>
		
		<c:forEach items="${questionAnsList[2]}" var="answer">
		
			<label for="option1">Option 1: </label>
			<br>
			
			<c:choose>
			  <c:when test = "${answer.correctAnswer eq 'true'}">
			    <input type="checkbox" name="options" value="" checked>
			  </c:when>
			  <c:otherwise>
			    <input type="checkbox" name="options" value="" >
			  </c:otherwise>
			</c:choose>
	    	<textarea name="option1" rows="2" cols="50" class="form-control">${answer.answer}</textarea>
			<br>
		
						
		</c:forEach>
		
	
		
		Enter points : 
		<input type="number" name="points" value="${questionAnsList[2][0].question.points}">
		<br>
		<br>
		</div>
		
		</form>
			
		</c:when>
		
		<c:otherwise>
 			<!--  keep this blank -->
		</c:otherwise>
	</c:choose>
  	
  	</c:forEach>


		
</body>
</html>