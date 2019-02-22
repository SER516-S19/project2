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
       <div class="boxRight">
         <p>${Session.userVO.getLastname()} </p>
         <p>${Session.userVO.getPhonenumber()} </p>
         <p>${Session.userVO.getEmail()} </p>
          <p>${Session.userVO.getUsername()} </p>
          </div>
          
        <div class="shiftTop">
         <form action="courseDashboard" method="POST">
         <#list Session.CourseHashMap as courseId, courseName>
         <input type="radio" name=Course value=${courseId}> ${courseName}<br>
         </#list>
         <input  class="button" type ="submit" value="Submit"/>
         </form>
        </div>
	</body>
</html>


  