<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<body>
         <p class="fontColor">Welcome ${Session.profFirstName} </p>
         <form action="courseDashboard" method="POST">
         <select name="Course">
         <#list Session.CourseHashMap as courseId, courseName>
          <option value=${courseId}> ${courseName}</option>
           </#list>
         </select>
         <input type ="submit" value="Submit"/>
         </form>
	</body>
</html>