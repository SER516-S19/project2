<!-- 
Freemarker page to display createquiz page
@authour Carnic
@version 1.0
@date 02/21/2019
 -->

<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<body>
	<p class="fontColor"> CREATE QUIZ HERE </p>
		<div class="box">
			<form action="createQuiz" method = "POST">
			  <p class="fontUp">Quiz Title </p>
			  <input class="mediumInput" type="text" name="quizTitle">
			  <br><br>
			  Quiz Duration 
			  &nbsp&nbsp
			  <input class="smallInput" type="text" name="assignedTime">
			  <br><br>
			  Quiz Date &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp
			  <input class="smallInput" type="date" name="quizScheduledDate">
			  <br><br>
			  <p class="fontUp">Quiz Instructions</p>
			  <input class="bigInput" type="textarea" rows="4" cols="50" name="quizInstructions">
			  <br>
			  <br>
			  Do you want to shuffle questions?
			  <br>
			  <input type="radio" name="isShuffled" checked> shuffle<br>
			  <input type="radio" name="isShuffled"> don't shuffle<br>
			  <br>
			  <input class="button" type="submit" value="Submit"> 
			</form> 
		</div>
	</body>
</html>