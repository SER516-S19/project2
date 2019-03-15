<!-- 
Freemarker page to display the Student Course Dashboard 
@authour Joshua Drumm
@version 1.0
@date 02/20/2019
 -->
<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<form action="studentHome.ftl" method="GET">
		<button type="submit"> <- Student Home Page</button>
	</form>
	<body>
		<h2 class="fontColor" style="text-transform: uppercase;">Course Dashboard</h2>
        <div class="box">
	    	<p class="smallFontColor" style="text-align : center;"> <b>${Session.courseName} </b></p>
	        <form action="DisplayInst" method="GET">
	           <select name="QuizId">
	               <#list Session.QuizHashMap as quizId, quizName>
	                   <option value=${quizId}> ${quizName}</option>
	               </#list>
	           </select>
	           <input type = "submit" value="Submit"/>
	       	</form>
     	</div>
	</body>
</html>