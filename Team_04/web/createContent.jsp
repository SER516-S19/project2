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
    <style>
        .invalid {
            border: 1px solid red;
        }

    </style>
    <script>

        var quiz = [];
        var ques = {'choice':1};

        function choiceUpdate(a) {
            ques['choice'] = a;
        }

        function formUpdate() {
            ques['question'] = document.getElementById("question").value;
            ques['option_a'] = document.getElementById("1").value;
            ques['option_b'] = document.getElementById("2").value;
            ques['option_c'] = document.getElementById("3").value;
            ques['option_d'] = document.getElementById("4").value;
            ques['score'] = document.getElementById("score").value;
        }

        function addQues() {
            quiz.push(ques);
        }

    </script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
        function submitForm(thisObj, thisEvent) {
            var jsonQuiz = new Object();
            jsonQuiz.quiz = quiz;
            var jsonData = JSON.stringify(jsonQuiz);

            $.post("create", {action:"export",json:jsonData}, function(data) {
                alert(data.message);
                $('#return_message').html(data.message);
            });

            return false;
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
    <p class="error"><b> Points to be noted:</b> Make sure you fill out all fields & the score should be a number.
    </p>
    <form  name="quizForm" method="POST" action="create" target="index.jsp">
    <br>
        <h3>Question text:</h3><br>
        <input type="text" id="question" name="question_text" onchange="formUpdate()" class="formtext">
        <br>
        <p name="option_a">Answer text A:</p><br>
        <input type="radio" id="choice_1" name="choice" value = "1" checked = "true" onchange="choiceUpdate(1)"
               class="formtext"> A
        <input type="text" id="1" name="1" onchange="formUpdate()">
        <br>
        <p name="option_b">Answer text B:</p><br>
        <input type="radio" id="choice_2" name="choice" value = "2" onchange="choiceUpdate(2)" class="formtext"> B
        <input type="text" id="2" name="2" onchange="formUpdate()">
        <br>
        <p name="option_c">Answer text C:</p><br>
        <input type="radio" id="choice_3" name="choice" value = "3" onchange="choiceUpdate(3)" class="formtext"> C
        <input type="text" id="3" name="3" onchange="formUpdate()">
        <br>
        <p name="option_d">Answer text D:</p><br>
        <input type="radio" id="choice_4" name="choice" value = "4" onchange="choiceUpdate(4)" class="formtext"> D
        <input type="text" id="4" name="4" onchange="formUpdate()">
        <br>
        <p name="score">Score:</p><br>
        <input type="text" id="score" name="score" onchange="formUpdate()"><br>
        <br>
        <input id="add" type="button" value="Add" onclick="addQues()">
        <input type="button"  value="Save" onclick="return submitForm(this, event);">
    </form>

    <script src="js/validation.js" type="text/javascript">
        $(document).ready(function () {
            $("input[value='Add']").prop('disabled', true);
            $('.error').hide();

            $(".formtext").on('keyup blur', function (e) {
                var input = $(this);
                var message = $(this).val();
                if (message) {
                    input.removeClass("invalid").addClass("valid");
                    allHaveClass();
                }
                else {
                    input.removeClass("valid").addClass("invalid");
                    $("input[value='Add']").prop('disabled', true);
                    $(".error").show();
                }

            });

            $("input[name='score']").on('keyup blur', function (e) {
                var input = $(this);
                var score = $(this).val();
                if (score && !isNaN(score)) { input.removeClass("invalid").addClass("valid"); allHaveClass(); }
                else {
                    input.removeClass("valid").addClass("invalid");
                    $("input[value='Add']").prop('disabled', true);
                    $(".error").show();
                }

            });

            function allHaveClass() {
                var allHaveClass = $('input.invalid').length == 0;
                if (allHaveClass) {
                    $("input[value='Add']").prop('disabled', false);
                    $('.error').hide();

                }
            }

        });

    </script>

    </body>
    </html>
