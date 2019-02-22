<html>
	<head>
		<#include "stylesheet.css">
	</head>
	
	<body>
		<h2 class="fontColor">Course Dashboard</h2>
         
         <div class="box">
         <p class="smallFontColor"> ${Session.courseName} </p>
         
         
	         <form action="DUMMYSERVLET" method="POST">
	         <select class="options" name="Quiz">
	         <#list Session.QuizHashMap as quizId, quizTitle>
	          <option name=${quizId}> ${quizTitle}</option>
	           </#list>
	         </select>
	         <input class="button" type ="submit" value="ViewQuiz"/>
	         </form>
	         <form action="createQuiz" method="GET">
	         <input class="button" type ="submit" value="CreateQuiz"/>
	         </form>
	          <form>
	         <input class="button" type ="submit" value="Statistics"/>
	         </form>
	     </div>
	</body>
</html>