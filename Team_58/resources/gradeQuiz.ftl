<#-- Author: Akash Kadam
	Renders GradedQuiz page which displays graded quiz
	version: 1.1
  -->
<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<style>
		table, th, td {
		  border: 1px solid black;
		  border-collapse: collapse;
		}
		th, td {
		  padding: 5px;
		  text-align: left;    
		}
	</style>
	<body>
		<div class="navbar">
		  <a method="POST" href="viewQuiz.ftl"> < View Quiz</a>
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
		
		<h1 class="fontColor">
		   Title: ${Session.quizName}
		</h1>
		<table class="box">
			<tr>
				<th>Student</th>
				<th>Score</th>
			</tr>
	        <#list Session.gradeQuiz as gradeQuiz>
	            <tr>
	               <td contenteditable='true'>${gradeQuiz.getFirstName()}</td>
				   <td contenteditable='true'>${gradeQuiz.getScore()}</td>
	            </tr>
	        </#list>
        </table>
        
	</body>
</html>