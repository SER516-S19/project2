<!--
Freemarker page to display the Quiz Instructions
@authour Prashansa
@version 1.0
@date 02/28/2019
-->
<html>
    <head>
        <#include "stylesheet.css">
        <title>QUIZ</title>
    </head>
    <body>
        <div class="box">
            <h2> Please read the instructions carefully before starting the quiz </h2>
            <p>${Session.QuizVO.getQuizInstruction()} </p>
            <h3> Start Quiz here </h3>
            <form action="DisplayQuiz" method = "GET"> 
                <input type="hidden" name="quizId" value="${Session.QuizVO.getQuizId()}">
                <input type="submit" value="Start">
            </form>
        </div>
    </body>
</html>