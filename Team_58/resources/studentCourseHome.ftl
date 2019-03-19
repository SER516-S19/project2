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
<style>

	input[type=button], input[type=submit], input[type=reset] {
  background-color: #555555;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}

</style>
	<body>
		<h2 class="fontColor" style="text-transform: uppercase;">Course Dashboard</h2>
        <div class="box">
	    	<p class="smallFontColor" style="text-align : center;"> <b>${Session.courseName} </b></p>
	    	<form action="studentHome.ftl" method="GET">
				<button type="submit"> <- Student Home Page</button>
			</form>
	        <form action="DisplayInst" method="GET" align= "center">
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