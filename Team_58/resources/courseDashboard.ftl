<!-- 
Freemarker page to display CourseDashboard 
@authour narenkumarKonchada / @author Carnic
@version 1.3
@date 02/25/2019
 -->
<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<body>
		<div class="navbar">
		  <a method="POST" href="professorHome.ftl"> < Professor Home </a>
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
		<h2 class="fontColor" style="text-transform: uppercase;">Course Dashboard</h2>
         <div class="box">
	      	<p class="smallFontColor" style="text-align : center;"> <b>${Session.courseName} </b></p>
	        <form action="viewQuiz" method="POST">
	         	<select class="options" name="Quiz">
	         		<#list Session.QuizHashMap as quizId, quizTitle>
	          			<option value=${quizId}> ${quizTitle}</option>
	           		</#list>
	         	</select>
	         	<input class="button" type ="submit" value="ViewQuiz"/>
	         </form>
	         	<form action="createQuiz" method="GET">
         			<input class="buttonLarge" type ="submit" value="Create New Quiz"/>
         		</form>
	     	</div>
	</body>
</html>