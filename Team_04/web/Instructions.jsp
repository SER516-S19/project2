<%--
  Created by IntelliJ IDEA.
  User: Harika Kolli, Sneha Lakshminarasimhan
  Date: 2/21/2019
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
  --%>

<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
%>

<html>
<head>
    <title> QUIZ INSTRUCTIONS </title>
</head>
<style>
    .startQuizBtn
    {
        display: inline-block;
        white-space: nowrap;
        flex-basis: auto;
        width: auto;
        font-size: .875rem;
        background-color: black;
        border: 2px;
        cursor: pointer;
        border-radius: 4px;
        text-align: center;
        font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
        font-weight: 700;
        line-height: 1.28571429;
        letter-spacing: .8px;
        text-transform: uppercase;
        text-decoration: none;
        padding: 19px 40px 20px;
        transition: box-shadow 420ms cubic-bezier(.165, .84, .44, 1), color 420ms cubic-bezier(.165, .84, .44, 1), background 420ms cubic-bezier(.165, .84, .44, 1);
        color: white;
    }

    .quizInstruction
    {
        font-size:200%;
        text-align: center;
    }

    .instructionDiv
    {
        font-family:Sans-serif;
        font-size:100%;
        line-height: 1.0;
        padding: 3em;
    }
</style>
<body>
    <form action="./quiz" method="get">
        <p class="quizInstruction"> QUIZ INSTRUCTIONS </p>
        <div class="instructionDiv">
        <p>The following are the instructions related to the quiz : </p> <br>
        <ul>
            <li> Work in teams of 5 or 7</li>
            <li>Submit a reviewed version of your Quiz 2 here.</li>
            <li>Submission should be done by only one member in the team through Blackboard.</li>
            <li>Add the team members names to the document in a separated page (only the names of these who
                collaborate).
            </li>
            <li>Due by Wednesday March 27</li>
        </ul>
        </div>
        <br>
        <p align="center">
            <input type="submit" class="startQuizBtn" name="action" value="Start Quiz">
        </p>
    </form>
    </body>
</html>




