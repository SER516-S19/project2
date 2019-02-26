<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>
<body>
<div align="center" >
	<H2>Please Edit the question</H2>
</div>

<%
  System.out.println("Hellohere");
  request.getAttribute("answerList");
  System.out.println(request.getAttribute("answerList")); 
  String question="Question1";
  String option1="Option1";
  String option2="Option2";
  String option3="Option3";
  String option4="Option4";
  int points=10;
  

  %>
  
  

<form method="Post" action="../ProfessorController">
	<div class="borderexample" class="form-group">   
			
		<label for="question" >Question:</label>
		<textarea name="question" id="question" rows="6" cols="50"  class="form-control"><%=question%></textarea>	
		<br>
		
		<label for="option1">Option 1: </label>
		<br>
    	<input type="checkbox" name="options" value="option1">
    	<textarea name="option1" rows="2" cols="50" class="form-control"><%=option1%></textarea>
		<br>


    	<label for="option2">Option 2: </label>
    	<br>
		<input type="checkbox" name="options" value="option2">	
    	<textarea name="option2" rows="2" cols="50" class="form-control" ><%=option2%></textarea>
    	<br>
    
    	
    	<label for="option3">Option 3: </label>
    	<br>
    	<input type="checkbox" name="options" value="option3">
    	<textarea name="option3" rows="2" cols="50" class="form-control" ><%=option3%></textarea>
    	<br>
    
    	<label for="option4">Option 4: </label>
		<br>
    	<input type="checkbox" name="options" value="option4">
    	<textarea name="option4" rows="2" cols="50" class="form-control" ><%=option4%></textarea>
		<br>
		<br>
		
		Enter points : 
		<input type="number" name="points" value=points>
		<br>
		<br>
		</div>
		
		</form>
		
</body>
</html>