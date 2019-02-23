<html>
    <head>
        <#include "stylesheet.css">
    </head>
    <body>
        <p>Welcome ${Session.UserVO.getFirstname()}!</p>
        <form action="courseDashboard" method="POST">
            <select name="Course">
                <#list Session.CourseHashMap as id, name>
                    <option value=${id}> ${name}</option>
                </#list>
            </select>
            <input disabled type = "submit" value="Submit"/>
        </form>
        
        <form action="quizInstructions" method="POST">
            <select name="QuizId">
                <#list Session.QuizHashMap as id, name>
                    <option value=${id}> ${name}</option>
                </#list>
            </select>
            <input type = "submit" value="Submit"/>
        </form>
    </body>
</html>