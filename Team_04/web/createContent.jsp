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
    </head>
    <body>
    <h1>
        Create Quiz
    </h1>
    <form  method="POST" action="create">
    <br>
        Question text:<br>
        <input type="text" name="questiontext"><br>
        Answer text A:<br>
        <input type="radio" name="choice" value = "1" checked = "true"> A
        <input type="text" name="1"><br>
        Answer text B:<br>
        <input type="radio" name="choice" value = "2"> B
        <input type="text" name="2"><br>
        Answer text C:<br>
        <input type="radio" name="choice" value = "3"> C
        <input type="text" name="3"><br>
        Answer text D:<br>
        <input type="radio" name="choice" value = "4"> D
        <input type="text" name="4"><br>
        Score:<br>
        <input type="text" name="score"><br>
        <br>
        <input type="submit"  value="Add">
    </form>
    </body>
    <style>
        /*#bodycontent fieldset {*/
            /*!*margin-right: 10px*!*/
            /*text-align: right;*/
        /*}*/

    </style>
    </html>

