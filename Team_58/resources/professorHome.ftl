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
         <p>${Session.userVO.getLastname()} </p>
         <p>${Session.userVO.getPhonenumber()} </p>
         <p>${Session.userVO.getEmail()} </p>
          <p>${Session.userVO.getUserName()} </p>
         <form action="courseDashboard" method="POST">
         <#list Session.CourseHashMap as courseId, courseName>
         <input type="radio" name=${courseName} value=${courseId}> ${courseName}<br>
         </#list>
         <input type ="submit" value="Submit"/>
         </form>
	</body>
</html>


  