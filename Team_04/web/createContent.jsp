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

<head>
    <title>create-quiz</title>
    <style>
        .invalid {
            border: 1px solid red;
        }
    </style>

</head>

<body>
    <h1>
        Create Quiz
    </h1>
    <p class="error"><b> Points to be noted:</b> Make sure you fill out all fields & the score should be a number.
    </p>
    <form method="POST" action="create">
        <br>
        Question text:<br>
        <input type="text" name="question_text" class="formtext"><br>
        Answer text A:<br>
        <input type="radio" name="choice" value="1" checked="true"> A
        <input type="text" name="1" class="formtext"><br>
        Answer text B:<br>
        <input type="radio" name="choice" value="2"> B
        <input type="text" name="2" class="formtext"><br>
        Answer text C:<br>
        <input type="radio" name="choice" value="3"> C
        <input type="text" name="3" class="formtext"><br>
        Answer text D:<br>
        <input type="radio" name="choice" value="4"> D
        <input type="text" name="4" class="formtext"><br>
        Score:<br>
        <input type="text" name="score"><br>
        <br>
        <input type="submit" value="Add">
    </form>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=">
        </script>
    <script src="js/validation.js" type="text/javascript"></script>

</body>

</html>