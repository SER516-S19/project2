<!-- 
Freemarker page to display CourseDashboard 
@authour narenkumarKonchada
@version 1.2
@date 02/22/2019
 -->
<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<form action="professorHome.ftl" method="POST">
		<button type="submit"> <- Professor Home Page</button>
	</form>
	<body>
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