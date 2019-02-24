<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/questions.css" type="text/css"/>
<title>Sample Question Style</title>
</head>
<body style="background-color:#FFF8DC;">
	<div class="head-section">
	<h2>Quiz 1</h2>
	<% java.text.DateFormat df = new java.text.SimpleDateFormat("MMM dd 'at' hh:mm a"); %>
	<h5>Started: <%= df.format(new java.util.Date()) %> </h5>
	<h2>Quiz Instructions</h2>
	</div>
	<div class="question-board">
		<div class="question-top-area">
			<h3 class="question_num">Question 1</h3>
			<h4>10 pts</h4>
		</div>
		<div class="question-title">
		Which of the followings are prerequisites of this course?</div>
		<div class="selection-area">
			<input type="checkbox" name="myAnwer" value="optionA">
			<label  class="option1">proficient in a high-level programming language like Java or C++ and the environment in which a program is developed, e.g., editor, compiler/interpreter, etc.</label>
			<hr>
			<input type="checkbox" name="myAnwer" value="optionB">
			<label  class="option2">understood basic concept of computer organization, including registers, memory arithmetic and logic units, processor, input and output.</label>
			
			
			<hr>
			<input type="checkbox" name="myAnwer" value="optionC"> 
			<label  class="option3">Nothing!</label>
			<hr>
			<input type="checkbox" name="myAnwer" value="optionD">
			<label class="option4">Hello World!!!
			
			</label>
		</div>
		<br>
	</div>
	<!--  <div style="height:60px; display: flex; align-items: right; justify-content: center;">
		<a href="#" class="rainbow-button" alt="Next" id="nextQ1"></a>
	</div>
	<div style="top:100px;height:60px; display: flex; align-items: left; justify-content:right;">
		<a href="#" class="rainbow-button" alt="Previous" id="prevQ1"></a>  -->
	</div>
	<div class="next">
		<button type="button" onClick="" class="nextQ" style="width:200px;bottom:300px;left:300px">Next</button>
	</div>
	<div class="previous">
		<button type="button" class="prevQ" style="visibility:hidden;width:200px">Previous</button>
	</div> 
		
	<button style="width:100px" type="button" value="Submit Quiz" onclick='location.href=("submit.jsp")'>Submit Quiz</button>
	
	  <script src="js/question.js"></script>
	
</body>
</html>