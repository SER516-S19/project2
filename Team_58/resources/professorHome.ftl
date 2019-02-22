<!-- 
Freemarker page to display Professor details
@authour Shivam Verma
@version 1.0
@date 02/20/2019
 -->

<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<body>
         <p class="fontColor">Welcome  ${Session.userVO.getFirstname()}</p>
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