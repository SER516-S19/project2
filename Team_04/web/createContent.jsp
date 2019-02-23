<%--
      Created by IntelliJ IDEA.
      User: amankaushik
      Modified By: pbahl1
      Date: 19/2/19
      Time: 7:02 PM
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <script>
        var quiz = [];
        var ques = {};

        function formUpdate() {
            ques['question'] = document.getElementsByName("question_text").value;
            ques['choice'] = document.getElementsByName("choice").value;
            ques['option_a'] = document.getElementsByName("1").value;
            ques['option_b'] = document.getElementsByName("2").value;
            ques['option_c'] = document.getElementsByName("3").value;
            ques['option_d'] = document.getElementsByName("4").value;
            ques['score'] = document.getElementsByName("score").value;
        }

        function addQues() {
            quiz.push(ques);
        }

        function submitQues() {
            
        }
    </script>
    <head>
        <title>create-quiz</title>
        <style>
            form {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            input[name="question_text"] {
                font-family: arial, sans-serif;
                width: 30%;
                height: 20%;
            }

            input[name="1"],input[name="2"],input[name="3"],input[name="4"] {
                font-family: arial, sans-serif;
                width: 15%;
            }

            input[value="Add"], input[value="Save"] {
                width: 5%;
                height:5%;
                font-size: 20px;
            }

            p {
                font-family: arial, sans-serif;
                font-size: large;
                height:5%;
            }
        </style>
    </head>
    <body>
    <h1>
        Create Quiz
    </h1>
    <form  method="POST" action="create">
    <br>
        <h3>Question text:</h3><br>
        <input type="text" name="question_text" onchange="formUpdate()">
        <br>
        <p name="option_a">Answer text A:</p><br>
        <input type="radio" name="choice" value = "1" checked = "true" onchange="formUpdate()"> A
        <input type="text" name="1" onchange="formUpdate()">
        <br>
        <p name="option_b">Answer text B:</p><br>
        <input type="radio" name="choice" value = "2" onchange="formUpdate()"> B
        <input type="text" name="2" onchange="formUpdate()">
        <br>
        <p name="option_c">Answer text C:</p><br>
        <input type="radio" name="choice" value = "3" onchange="formUpdate()"> C
        <input type="text" name="3" onchange="formUpdate()">
        <br>
        <p name="option_d">Answer text D:</p><br>
        <input type="radio" name="choice" value = "4" onchange="formUpdate()"> D
        <input type="text" name="4" onchange="formUpdate()">
        <br>
        <p name="score">Score:</p><br>
        <input type="text" name="score" onchange="formUpdate()"><br>
        <br>
        <input id="add" type="button" value="Add" onclick="addQues()">
        <input type="button"  value="Save" onclick="submitQuiz()">
    </form>
    </body>
    </html>
