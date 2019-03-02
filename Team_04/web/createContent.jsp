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
    <div class="container">
        <form name="quizForm" id="form">
            <div class="row">
                <div class="col-25">
                    <label for="fname">Question text:</label>
                </div>
                <div class="col-75">
                    <input type="text" id="question" name="question_text" class="formtext">
                </div>
            </div>
            <div class="row">
                <div class="col-75" style="text-align: -webkit-right;"><i>(Check the radio button of the correct answer
                        choice.)</i></div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="lname" name="option_a">Answer text A: </label>
                </div>
                <div class="col-75">
                    <input type="radio" id="choice_1" name="choice" value="1" checked="true">
                    <input type="text" id="1" name="1" class="formtext">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label name="option_b">Answer text B:</label>
                </div>
                <div class="col-75">
                    <input type="radio" id="choice_2" name="choice" value="2">
                    <input type="text" id="2" name="2" class="formtext">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label name="option_c">Answer text C:</label>
                </div>
                <div class="col-75">
                    <input type="radio" id="choice_3" name="choice" value="3">
                    <input type="text" id="3" name="3" class="formtext">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label name="option_d">Answer text D:</label>
                </div>
                <div class="col-75">
                    <input type="radio" id="choice_4" name="choice" value="4">
                    <input type="text" id="4" name="4" class="formtext">
                </div>
            </div>
            <div class="row" ">
                <div class=" col-25">
                <label name="score">Score:</label></div>
            <div class="col-75">
                <input type="text" id="score" name="score"><br>
            </div>
    </div>
    <div class="row" style="margin-right:24px;">
        <input id="add" type="button" value="Add" class="btn" onclick="addQues()">
        <input type="button" class="btn" value="Save">
    </div>
    </form>

    </div>

    <div id="QuestionsTable" style="display:none;">
        <div class="col-25">
            <label name="quesAdded">Questions Added:</label></div>
        <table id="qAdded">
            <tr>
                <th>Question</th>
                <th>A</th>
                <th>B</th>
                <th>C</th>
                <th>D</th>
                <th>Score</th>
                <th>Action</th>
            </tr>

        </table>

    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="js/validation.js" type="text/javascript">
    </script>
    <script>
        var qid = 0;
        var quiz = [];
        $("input[value='Add']").prop('disabled', true);
        $("input[value='Save']").prop('disabled', true);
        function addQues() {

            quiz.push({
                qid: qid.toString(),
                question: document.getElementById("question").value,
                option_a: document.getElementById("1").value,
                option_b: document.getElementById("2").value,
                option_c: document.getElementById("3").value,
                option_d: document.getElementById("4").value,
                score: document.getElementById("score").value,
                choice: document.querySelector('input[name="choice"]:checked').value
            });
            var html = "<tr id='quiz'" + qid + "><td>" + document.getElementById("question").value + "</td><td>" + document.getElementById("1").value +
                "</td><td>" + document.getElementById("2").value + "</td><td>" + document.getElementById("3").value + "</td><td>" +
                document.getElementById("4").value + "</td><td>" + document.getElementById("score").value + "</td>" + "<td><button qid=" + qid + " class='delQues'>delete</button></td>";
            $("#qAdded").append(html);
            qid++;
            $("#QuestionsTable").show();
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

        $("#qAdded").on('click', '.delQues', function (e) {
            for (var i = quiz.length - 1; i >= 0; --i) {
                if (quiz[i].qid == $(this).attr('qid')) {
                    quiz.splice(i, 1);
                    $(this).parent().parent().remove();

                    if ($('#qAdded tr').length == 1) {
                        $("input[value='Save']").prop('disabled', true);
                        $("input[value='Save']").addClass('btn-disabled');
                    }

                }
            }
        });

    </script>

</body>

</html>