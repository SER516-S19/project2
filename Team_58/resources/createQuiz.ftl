<!-- 
Freemarker page to display createquiz page
@authour Carnic / @author Aditya
@version 1.3
@date 02/25/2019
 -->

<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
      $("#quizForm").validate({
        messages: {

            quizTitle: "Please add quiz title",
            assignedTime: {required: "Please input quiz length", number:"Please enter a number"},
            quizScheduledDate: "Please enter the quiz schedule date",
            quizInstructions: "Please add quiz instructions"
        },
        rules: {
          quizTitle: "required",
          assignedTime: {required:true, number: true,},
          quizScheduledDate: "required",
          quizInstructions: "required",
        },
      });
    });
  </script>
	<body>
		<div class="navbar">
		  <a method="POST" href="courseDashboard.ftl"> < Course Dashboard</a>
		  <div class="dropdown">
		    <button class="dropbtn">v
		      <i class="fa fa-caret-down"></i>
		    </button>
		    <div class="dropdown-content">
		    	<a href="professorHome.ftl">Home</a>
		    	<a href="login.jsp" name="logoutProfile">Logout</a>
		    </div>
		  </div> 
		</div>
	<p class="fontColor"> CREATE QUIZ </p>
		<div class="box">
			<form action="createQuiz" id="quizForm" method = "POST">
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