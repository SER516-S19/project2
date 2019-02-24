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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
        /*
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

        function submitForm(thisObj, thisEvent) {
            var jsonQuiz = new Object();
            jsonQuiz.quiz = quiz;
            var jsonData = JSON.stringify(jsonQuiz);

            $.post("create", {action:"export",json:jsonData}, function(data) {
                alert(data.message);
                $('#return_message').html(data.message);
            });

            return false;
        }*/
    </script>

    <head>
        <title>create-quiz</title>
        <style>
            form {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            input[name="1_question_text"], input[name="2_question_text"], input[name="3_question_text"],
            input[name="4_question_text"], input[name="5_question_text"] {
                font-family: arial, sans-serif;
                width: 30%;
                height: 20%;
            }

            input[name="1_1"],input[name="1_2"],input[name="1_3"],input[name="1_4"],
            input[name="2_1"],input[name="2_2"],input[name="2_3"],input[name="2_4"],
            input[name="3_1"],input[name="3_2"],input[name="3_3"],input[name="3_4"],
            input[name="4_1"],input[name="4_2"],input[name="4_3"],input[name="4_4"],
            input[name="5_1"],input[name="5_2"],input[name="5_3"],input[name="5_4"] {
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
        <input type="text" id="1_question" name="1_question_text" class="formtext">
        <br>
        <p name="option_a">Answer text A:</p><br>
        <input type="radio" name="1_choice" value = "1" checked = "true"> A
        <input type="text" id="1_1" name="1_1" class="formtext">
        <br>
        <p name="option_b">Answer text B:</p><br>
        <input type="radio" name="1_choice" value = "2"> B
        <input type="text" id="1_2" name="1_2" class="formtext">
        <br>
        <p name="option_c">Answer text C:</p><br>
        <input type="radio" name="1_choice" value = "3"> C
        <input type="text" id="1_3" name="1_3" class="formtext">
        <br>
        <p name="option_d">Answer text D:</p><br>
        <input type="radio" name="1_choice" value = "4"> D
        <input type="text" id="1_4" name="1_4" class="formtext">
        <br>
        <p name="score">Score:</p><br>
        <input type="text" id="1_score" name="1_score"><br>
        <br>

        <br>
        <h3>Question text:</h3><br>
        <input type="text" id="2_question" name="2_question_text" class="formtext">
        <br>
        <p name="option_a">Answer text A:</p><br>
        <input type="radio" name="2_choice" value = "1" checked = "true"> A
        <input type="text" id="2_1" name="2_1" class="formtext">
        <br>
        <p name="option_b">Answer text B:</p><br>
        <input type="radio" name="2_choice" value = "2"> B
        <input type="text" id="2_2" name="2_2" class="formtext">
        <br>
        <p name="option_c">Answer text C:</p><br>
        <input type="radio" name="2_choice" value = "3"> C
        <input type="text" id="2_3" name="2_3" class="formtext">
        <br>
        <p name="option_d">Answer text D:</p><br>
        <input type="radio" name="2_choice" value = "4"> D
        <input type="text" id="2_4" name="2_4" class="formtext">
        <br>
        <p name="score">Score:</p><br>
        <input type="text" id="2_score" name="2_score"><br>
        <br>

        <br>
        <h3>Question text:</h3><br>
        <input type="text" id="3_question" name="3_question_text" class="formtext">
        <br>
        <p name="option_a">Answer text A:</p><br>
        <input type="radio" name="3_choice" value = "1" checked = "true"> A
        <input type="text" id="3_1" name="3_1" class="formtext">
        <br>
        <p name="option_b">Answer text B:</p><br>
        <input type="radio" name="3_choice" value = "2"> B
        <input type="text" id="3_2" name="3_2" class="formtext">
        <br>
        <p name="option_c">Answer text C:</p><br>
        <input type="radio" name="3_choice" value = "3"> C
        <input type="text" id="3_3" name="3_3" class="formtext">
        <br>
        <p name="option_d">Answer text D:</p><br>
        <input type="radio" name="3_choice" value = "4"> D
        <input type="text" id="3_4" name="3_4" class="formtext">
        <br>
        <p name="score">Score:</p><br>
        <input type="text" id="3_score" name="3_score"><br>
        <br>

        <br>
        <h3>Question text:</h3><br>
        <input type="text" id="4_question" name="4_question_text" class="formtext">
        <br>
        <p name="option_a">Answer text A:</p><br>
        <input type="radio" name="4_choice" value = "1" checked = "true"> A
        <input type="text" id="4_1" name="4_1" class="formtext">
        <br>
        <p name="option_b">Answer text B:</p><br>
        <input type="radio" name="4_choice" value = "2"> B
        <input type="text" id="4_2" name="4_2" class="formtext">
        <br>
        <p name="option_c">Answer text C:</p><br>
        <input type="radio" name="4_choice" value = "3"> C
        <input type="text" id="4_3" name="4_3" class="formtext">
        <br>
        <p name="option_d">Answer text D:</p><br>
        <input type="radio" name="4_choice" value = "4"> D
        <input type="text" id="4_4" name="4_4" class="formtext">
        <br>
        <p name="score">Score:</p><br>
        <input type="text" id="4_score" name="4_score"><br>
        <br>

        <br>
        <h3>Question text:</h3><br>
        <input type="text" id="5_question" name="5_question_text" class="formtext">
        <br>
        <p name="option_a">Answer text A:</p><br>
        <input type="radio" name="5_choice" value = "1" checked = "true"> A
        <input type="text" id="5_1" name="5_1" class="formtext">
        <br>
        <p name="option_b">Answer text B:</p><br>
        <input type="radio" name="5_choice" value = "2"> B
        <input type="text" id="5_2" name="5_2" class="formtext">
        <br>
        <p name="option_c">Answer text C:</p><br>
        <input type="radio" name="5_choice" value = "3"> C
        <input type="text" id="5_3" name="5_3" class="formtext">
        <br>
        <p name="option_d">Answer text D:</p><br>
        <input type="radio" name="5_choice" value = "4"> D
        <input type="text" id="5_4" name="5_4" class="formtext">
        <br>
        <p name="score">Score:</p><br>
        <input type="text" id="5_score" name="5_score"><br>
        <br>

        <!--input id="add" type="button" value="Add" onclick="addQues()"-->
        <input type="button"  value="Save">
        <!--onclick="return submitForm(this, event);"-->
    </form>

    <script src="js/validation.js" type="text/javascript">
        $(document).ready(function () {
            $("input[value='Save']").prop('disabled', true);
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
                    $("input[value='Save']").prop('disabled', true);
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
