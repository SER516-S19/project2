<!-- 
Freemarker page to display CreateQuestions Page 
@authour Trupti Khatavkar
@version 1.2
@date 02/22/2019
 -->
<html>

<head>
<#include "stylesheet.css">
</head>
	<body>
	
	<h1 class="fontColor">Enter your questions and answers</h1>
	<div class="box">
		<form action="createQuestions" method="POST">
			
		  	Question:<br>
  			<input class="bigInput" type="text" name="question">
  			<br><br>
  			Correct Answer:<br>
  			<input class="mediumInput" type="text" name="correctAnswer">
  			<br><br>
  			Incorrect Answer 1:<br>
  			<input class="mediumInput" type="text" name="incorrectAnswer1">
  			<br><br>
  			Incorrect Answer 2:<br>
  			<input class="mediumInput" type="text" name="incorrectAnswer2">
  			<br><br>
  			Incorrect Answer 3:<br>
  			<input class="mediumInput" type="text" name="incorrectAnswer3">
  			<br><br>
  			Total Points:<br>
  			<input class="smallInput" type="text" name="totalPoints">
  			<br><br>
  			<input type="radio" name="isMCQ" checked>Multiple Answers
  			<br><br>
  			<input type="radio" name="isMCQ">Single Answer
  			<br><br>
  			<input class="button" type="submit" value="Add more Questions/ Submit">
  			<input class="button" type="submit" formaction="courseDashboard.ftl" formmethod="POST" value="Go to dashboard">
		</form>
		</div>
	</body>
</html>