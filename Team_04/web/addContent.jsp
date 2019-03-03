<%--
  Created by IntelliJ IDEA.
  User: Abhishek Gupta
  Date: 2019-02-28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="css/createcontent.css">

<head>
    <title>add-ques</title>
</head>

<body>
<h1>
    <%=request.getAttribute("action")%> Question
</h1>

<p class="error"><b> Points to be noted:</b> Make sure you fill out all fields & the score should be a number.
</p>
<div class="container">
    <form name="quizForm" id="form" method="post" action="ques">
        <input type="hidden" name="quizid" value="<%=request.getAttribute("quizid")%>">
        <input type="hidden" name="quesid" value="<%=request.getAttribute("quesid")%>">
        <div class="row">
            <div class="col-25">
                <label for="fname">Question text:</label>
            </div>
            <div class="col-75">
                <input type="text" id="question" name="question_text" class="formtext" value="${question_text}">
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
                <input type="radio" id="choice_1" name="choice" value="1" checked>
                <input type="text" id="1" name="1" class="formtext"
                       value="${option_a}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label name="option_b">Answer text B:</label>
            </div>
            <div class="col-75">
                <input type="radio" id="choice_2" name="choice" value="2">
                <input type="text" id="2" name="2" class="formtext"
                       value="${option_b}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label name="option_c">Answer text C:</label>
            </div>
            <div class="col-75">
                <input type="radio" id="choice_3" name="choice" value="3">
                <input type="text" id="3" name="3" class="formtext"
                       value="${option_c}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label name="option_d">Answer text D:</label>
            </div>
            <div class="col-75">
                <input type="radio" id="choice_4" name="choice" value="4">
                <input type="text" id="4" name="4" class="formtext"
                       value="${option_d}">
            </div>
        </div>
        <div class="row">
        <div class=" col-25">
            <label name="score">Score:</label></div>
        <div class="col-75">
            <input type="text" id="score" name="score" value="${score}"><br>
        </div>
</div>
<div class="row" style="margin-right:24px;">
    <input type="submit" value="Add" class="btn">
</div>
</form>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/validation.js" type="text/javascript">
    document.getElementById("choice_${choice}").setAttribute("checked","true");
</script>

</body>
</html>
