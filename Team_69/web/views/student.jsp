<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String dateTime = (String) session.getAttribute("startTime");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Start your quiz</title>
    <link type='text/css' rel='stylesheet' href='../css/studentStyle.css' />
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Open Sans" />
    <script type='text/javascript'
            src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
    <script type='text/javascript' src='../js/student.js'></script>
</head>
<body>
<div id='container'>
    <div id="ridge">
        <p id="quiz_name"></p>
    </div>
    <div>
        <p>
            Started at
            <%=dateTime%></p>
    </div>
    <div>
        <p id="quiz_instructions" align="left"></p>
    </div>

    <br />
    <div id='quiz'></div>
    <div class='button' id='next'>
        <a href='#'>Next</a>
    </div>
    <div class='button' id='prev'>
        <a href='#'>Prev</a>
    </div>
    <form name="submitForm" id="submitForm" action="" method="POST">
        <input type="hidden" name="data" value="Submit" id="finish" />
        <input type="hidden" name="action" value="submit" />
        <input type="button" value="Submit" id="submitBtn" />
        <div class="popup-content">
            <p>Are you sure you want to submit this quiz?</p>
            <input class="close" type="submit" value="Yes" />
            <input class="close" type="button" value="No" />
        </div>
    </form>
</div>

<script>
    //script to be executed when the page loads
    $(document).ready(function() {
        $('#submitBtn').hide();
        studentResponseJSON = '<%=session.getAttribute("studentResponseJSON")%>';
        var studentResponseObj = JSON.parse(studentResponseJSON);
        if(!studentResponseObj.isPublished){
            if (confirm("This quiz has not been published yet. Go back")) {
                history.go(-1);
            } else {
                history.go(-1);
            }
            return;
        }
        var hms = studentResponseObj.quizTimeLimit;
        //clear
        hms = '01:01:01';
        var quizName = studentResponseObj.quizName;
        var quizInstruction = studentResponseObj.quizInstructions;
        document.getElementById("quiz_name").innerHTML = quizName;
        document.getElementById("quiz_instructions").innerHTML = quizInstruction;
        var a = hms.split(':');
        var seconds = (+a[0]) * 60 * 60 + (+a[1]) * 60+ (+a[2]);
        setInterval(function() {
            document.getElementById("submitForm").submit();
        }, seconds * 1000);
        displayQuiz(studentResponseObj);
    });

    //method to update JSON from user inputs
    function updateResponseJSON(studentResponseObj, selections) {
        for (var i = 0; i < studentResponseObj.question.length; i++) {
            studentResponseObj.question[i].responseAnswer = selections[i];
        }
        var studentResponse = JSON.stringify(studentResponseObj);

        //ajax call to update the session attribute on the server
        $.ajax({
            url:'',
            type: 'POST',
            data: {data: studentResponse, action: 'save'},
            statusCode : {
                404 : function(){
                    console.log("Auto Save not functioning");
                },
                500 : function(){
                    console.log("Auto Save not functioning");
                }
            },
            success : (function() {
                console.log("Saved!!");
            })
        })
        document.getElementById("finish").value = studentResponseJSON;
    }
</script>
</body>
</html>

