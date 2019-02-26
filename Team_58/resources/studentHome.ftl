
<!-- 
Freemarker page to display the Student Homepage
@authour Joshua Drumm
@version 1.3
@date 02/22/2019
 -->
<html>
    <head>
        <#include "stylesheet.css">
    </head>
    <body>
        <p>Welcome ${Session.userVO.getFirstname()}!</p>
        <form action="courseDashboard" method="POST">
            <select name="Course">
                <#list Session.CourseHashMap as courseId, courseName>
                    <option value=${courseId}> ${courseName}</option>
                </#list>
            </select>
            <input disabled type = "submit" value="Submit"/>
        </form>
        
      <form action="DisplayInst" method="GET">
            <select name="QuizId">
                <#list Session.QuizHashMap as quizId, quizName>
                    <option value=${quizId}> ${quizName}</option>
                </#list>
            </select>
            <input type = "submit" value="Submit"/>
        </form>
    </body>
</html>