<!-- 
Freemarker page to display CreateQuestions Page 
@authour Trupti Khatavkar / @author Aditya Vikram
@version 1.4
@date 02/22/2019
 -->

<html>
<head>
<#include "stylesheet.css">
</head>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
      $("#questionForm").validate({
        messages: {
            question: "Please add Question",
            correctAnswer: "Please add the correct answer",
            incorrectAnswer1: "Please add the incorrect answer 1",
            incorrectAnswer2: "Please add the incorrect answer 2",
            incorrectAnswer3: "Please add the incorrect answer 3",
            totalPoints: {required: "Please add question points", number:"Please enter a number"}
        },
        rules: {
          question: "required",
          totalPoints: {required:true, number: true,},
          correctAnswer: "required",
          incorrectAnswer1: "required",
          incorrectAnswer2: "required",
          incorrectAnswer3: "required",
        },
      });
    });
  </script>
	<body>
	
	<h1 class="fontColor">Enter your questions and answers</h1>
	<div class="box">
		<form action="createQuestions" id="questionForm" method="POST">
		  	Question:<br>
  			<input class="bigInputLeft" type="text" name="question">
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
  			<input class="smallInputLeft" type="text" name="totalPoints">
  			<br><br>
  			<input type="radio" name="isMCQ" checked>Multiple Answers
  			<br><br>
  			<input type="radio" name="isMCQ">Single Answer
  			<br><br>
  			<input class="button" type="submit" value="Add more Questions/ Submit">
		</form>
		
		<form action="createQuestions" id = "goToDashboard" method="POST">
			<input class="button" type="submit" formaction="courseDashboard.ftl" formmethod="POST" value="Go to dashboard">
		</form>
		</div>
	</body>
</html>