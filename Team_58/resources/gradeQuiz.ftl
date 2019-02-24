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
        <form action="viewQuiz.ftl" method="POST">
	        	<button type="submit" class="button quizButton">Return to Quiz Page</button>
        </form>
        <script>
        
        </script>
	</body>
</html>