<#-- Author: Akash Kadam
	Renders GradedQuiz page which displays graded quiz
	version: 1.1
  -->
<html>
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
		<h1>
		   Title: ${Session.quizName}
		</h1>
		<table>
			<tr>
				<th>Student</th>
				<th>Score</th>
			</tr>
	        <#list Session.studentResponse as studentResponse>
	            <tr>
	               <td contenteditable='true'>${gradeQuiz.getFirstName()}</td>
				   <td contenteditable='true'>${gradeQuiz.getScore()}</td>
	            </tr>
	        </#list>
        </table>
        <script>
        
        </script>
	</body>
</html>