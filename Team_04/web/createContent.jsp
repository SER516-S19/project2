<%--
      Created by IntelliJ IDEA.
      User: amankaushik
      Modified By: pbahl1,hputhiya
      Date: 19/2/19
      Time: 7:02 PM
      To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="css/createcontent.css">

<head>
    <title>create-quiz</title>
</head>

<body>
    <h1>
        Create Quiz
    </h1>
    <p class="error"><b> Points to be noted:</b> Make sure you fill out all fields & the score should be a number.
    </p>
    <form name="quizForm" id="form">
        <br>
        <h3>Question text:</h3><br>
        <input type="text" id="question" name="question_text" class="formtext">
        <br>
        <p name="option_a">Answer text A:</p><br>
        <input type="radio" id="choice_1" name="choice" value="1" checked="true"> A
        <input type="text" id="1" name="1" class="formtext">
        <br>
        <p name="option_b">Answer text B:</p><br>
        <input type="radio" id="choice_2" name="choice" value="2"> B
        <input type="text" id="2" name="2" class="formtext">
        <br>
        <p name="option_c">Answer text C:</p><br>
        <input type="radio" id="choice_3" name="choice" value="3"> C
        <input type="text" id="3" name="3" class="formtext">
        <br>
        <p name="option_d">Answer text D:</p><br>
        <input type="radio" id="choice_4" name="choice" value="4"> D
        <input type="text" id="4" name="4" class="formtext">
        <br>
        <p name="score">Score:</p><br>
        <input type="text" id="score" name="score"><br>
        <br>
        <input id="add" type="button" value="Add" onclick="addQues()">
        <input type="button" value="Save">
    </form>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="js/validation.js" type="text/javascript">
    </script>
    <script>
        var quiz = [];
        $("input[value='Add']").prop('disabled', true);
        $("input[value='Save']").prop('disabled', true);
        function addQues() {

            quiz.push({
                question: document.getElementById("question").value,
                option_a: document.getElementById("1").value,
                option_b: document.getElementById("2").value,
                option_c: document.getElementById("3").value,
                option_d: document.getElementById("4").value,
                score: document.getElementById("score").value,
                choice: document.querySelector('input[name="choice"]:checked').value
            });
            var form = document.getElementById("form");
            form.reset();
            $('input').removeClass('valid');
            allHaveClass(true);
        }



        $("input[value='Save']").on('click', function (e) {
            var jsonData = JSON.stringify(quiz);

            $.ajax({
                type: 'get',
                url: 'create',
                dataType: 'JSON',
                data: {
                    test: jsonData
                }
            });

        });



    </script>

</body>

</html>