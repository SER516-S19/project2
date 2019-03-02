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
        body{
            background-color: #191970;
            border-style: outset;
            border-width: medium;
            border-radius: 10px;
            border-color: cyan;
            text-align: center;
        }
        form {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            display: inline-block;
        }

        input[name="question_text"] {
            font-family: arial, sans-serif;
            width: 30%;
            height: 20%;
        }

        input[name="1"], input[name="2"], input[name="3"], input[name="4"] {
            font-family: arial, sans-serif;
            width: 15%;
        }

        input[value="Add"], input[value="Save"] {
            width: 5%;
            height: 5%;
            font-size: 20px;
        }

        p {
            font-family: arial, sans-serif;
            font-size: large;
            height: 5%;
        }
    </style>
</head>
<body>
<h1>
    Create Quiz
</h1>
<p class="error"><b> Points to be noted:</b> Make sure you fill out all fields & the score should be
    a number.
</p>
<form name="quizForm" method="POST" action="create" target="index.jsp">
    <br>
    <table>
        <tr>
            <td>
                <span>Question text:</span>
                <input type="text" id="question_1" name="question_text_1" onchange="formUpdate()"
                       class="formtext">
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_a">Answer text A:</span>
                <input type="text" id="1_1" name="1_1" onchange="formUpdate()">
                <input type="radio" id="choice_1_1" name="choice_1" value="1" checked="true"
                       onchange="choiceUpdate(1)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_b">Answer text B:</span>
                <input type="text" id="2_1" name="2_1" onchange="formUpdate()">
                <input type="radio" id="choice_2_1" name="choice_1" value="2"
                       onchange="choiceUpdate(2)"> CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_c">Answer text C:</span>
                <input type="text" id="3_1" name="3_1" onchange="formUpdate()">
                <input type="radio" id="choice_3_1" name="choice_1" value="3"
                       onchange="choiceUpdate(3)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_d">Answer text D:</span>
                <input type="text" id="4_1" name="4_1" onchange="formUpdate()">
                <input type="radio" id="choice_4_1" name="choice_1" value="4"
                       onchange="choiceUpdate(4)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="score">Score:</span>
                <input type="text" id="score_1" name="score_1" onchange="formUpdate()">
            </td>
        </tr>
        <tr>
            <td>
                <span>Question text:</span>
                <input type="text" id="question_2" name="question_text_2" onchange="formUpdate()"
                       class="formtext">
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_a">Answer text A:</span>
                <input type="text" id="1_2" name="1_2" onchange="formUpdate()">
                <input type="radio" id="choice_2_1" name="choice_2" value="1" checked="true"
                       onchange="choiceUpdate(1)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_b">Answer text B:</span>
                <input type="text" id="2_2" name="2_2" onchange="formUpdate()">
                <input type="radio" id="choice_2_2" name="choice_2" value="2"
                       onchange="choiceUpdate(2)"> CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_c">Answer text C:</span>
                <input type="text" id="3_2" name="3_2" onchange="formUpdate()">
                <input type="radio" id="choice_3_2" name="choice_2" value="3"
                       onchange="choiceUpdate(3)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_d">Answer text D:</span>
                <input type="text" id="4_2" name="4_2" onchange="formUpdate()">
                <input type="radio" id="choice_4_2" name="choice_2" value="4"
                       onchange="choiceUpdate(4)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="score">Score:</span>
                <input type="text" id="score_2" name="score_2" onchange="formUpdate()">
            </td>
        </tr>
        <tr>
            <td>
                <span>Question text:</span>
                <input type="text" id="question_3" name="question_text_3" onchange="formUpdate()"
                       class="formtext">
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_a">Answer text A:</span>
                <input type="text" id="1_3" name="1_3" onchange="formUpdate()">
                <input type="radio" id="choice_3_3" name="choice_3" value="1" checked="true"
                       onchange="choiceUpdate(1)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_b">Answer text B:</span>
                <input type="text" id="2_3" name="2_3" onchange="formUpdate()">
                <input type="radio" id="choice_3_3" name="choice_3" value="2"
                       onchange="choiceUpdate(2)"> CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_c">Answer text C:</span>
                <input type="text" id="3_3" name="3_3" onchange="formUpdate()">
                <input type="radio" id="choice_3_3" name="choice_3" value="3"
                       onchange="choiceUpdate(3)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="option_d">Answer text D:</span>
                <input type="text" id="4_3" name="4_3" onchange="formUpdate()">
                <input type="radio" id="choice_4_3" name="choice_3" value="4"
                       onchange="choiceUpdate(4)"
                > CORRECT_ANSWER
            </td>
        </tr>
        <tr>
            <td>
                <span name="score">Score:</span>
                <input type="text" id="score_3" name="score_3" onchange="formUpdate()">
            </td>
        </tr>
    </table>
    <input type="submit" value="Save Quiz">
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
