<!-- 
Freemarker page to display the Grades
@authour Dhruv Patel
@version 1.3
@date 02/26/2019
 -->
<html>
 	<head align="center">
 		<#include "style.css">
 		<form action="studentHome.ftl" method="GET">
			<input type="submit" value="Student Home Page"/>
		</form>

 	</head>
 	<body>
 		<div align="center">
 			<h1>GRADES</h1>
 		</div>
 		<form action="DisplayGradesServlet" method="GET">
 			<table width="500" border="2px solid black">
 			<#list Session.Grades as grade>
                <tr>
    				<th>Course Name</th>
    				<th>Quiz Name</th>
    				<th>Score</th>
  				</tr>
                <tr>
 					<td>${grade.getCourseName()}</td>
 					<td>${grade.getQuizName()}</td>
 					<td>${grade.getScore()}</td>
 				</tr>
             </#list>				
 			</table>
 		</form>	
 	</body>
</html>