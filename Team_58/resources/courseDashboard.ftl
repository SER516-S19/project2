<!-- 
Freemarker page to display CourseDashboard 
@authour narenkumarKonchada
@version 1.2
@date 02/21/2019
 -->
<html>
	<head>
		<#include "stylesheet.css">
	</head>
	
	<body>
		<h2 class="fontColor" style="text-transform: uppercase;">Course Dashboard</h2>
         <div class="box">
         	<form action="professorHome.ftl" method="POST">
	        	<button type="submit">Return to Dashboard</button>
	        	</form>
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
	         					<input class="button" type ="submit" value="CreateQuiz"/>
	         				</form>
	          		<form>
		        	<input class="buttonRight" type ="submit" value="Statistics"/>
		        </form>
	     </div>
	</body>
</html>