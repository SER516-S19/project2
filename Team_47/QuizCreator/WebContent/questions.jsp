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
			<h3>Question 1</h3>
			<h4>10 pts</h4>
		</div>
		<div class="question-title">
		Which of the followings are prerequisites of this course?</div>
		<div class="selection-area">
			<input type="radio" name="myAnwer" value="optionA">
			proficient in a high-level programming language like Java or C++ and the environment in which a program is developed, e.g., editor, compiler/interpreter, etc.
			<hr>
			<input type="radio" name="myAnwer" value="optionB">
			understood basic concept of computer organization, including registers, memory arithmetic and logic units, processor, input and output.
			<hr>
			<input type="radio" name="myAnwer" value="optionC"> 
			I don't wanna be alone tonight It's pretty clear that I'm not over you I'm still thinking 'bout the things you do So I don't want to be alone tonight, alone tonight, alone tonight Can you light the fire?
			<hr>
			<input type="radio" name="myAnwer" value="optionD"> 
			Hello World!!!
		</div>
		<br>
	</div>
	<div style="height:60px; display: flex; align-items: center; justify-content: center;">
		<a href="#" class="rainbow-button" alt="Next"></a>
	</div>
	<div class="bottom-area">
		<button type="button">Submit Quiz</button>
	</div> 
</body>
</html>