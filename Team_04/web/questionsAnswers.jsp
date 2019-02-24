<%@ page import="com.model.QuestionAnswers" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.QuestionAnswers" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="student.dto.QuizContent" %>
<%@ page import="student.dto.AnswerOption" %><%--
  Created by IntelliJ IDEA.
  User: yuvan
  Date: 2/20/2019
  Time: 11:03 AM
  Description: View for displaying questions and answers
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<style>
    .QuesAnsDiv
    {

        width:50%;
        margin-top:10%;
        margin-left: 30%;
    }

    .navBtn
    {
        margin-left: 62%;
    }

    .prevBtn, .nextBtn
    {
        border-style: solid;
        margin-bottom: 25%;
        display: inline-block;
        white-space: nowrap;
        flex-basis: auto;
        width: auto;
        cursor: pointer;
        border-radius: 4px;
        text-align: center;
        font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
        font-weight: 800;
        line-height: 1.28571429;
        letter-spacing: .5px;
        text-transform: uppercase;
        padding: 10px 30px 10px;
        transition: box-shadow 420ms cubic-bezier(.165, .84, .44, 1), color 420ms cubic-bezier(.165, .84, .44, 1), background 420ms cubic-bezier(.165, .84, .44, 1);
    }
    body{
        background-color: rgb(220,208,255);

    }
    .quesStyle
    {
        font-size: 175%;
        margin-bottom: 55px;
    }

    .options:hover
    {
        background-color: lightgray;
        cursor: pointer;
    }

    .options
    {
        margin-bottom: 5px;
    }

    .entireDiv
    {
        border: black;
        background-color: rgb(241,228,254);
        margin: 70px 50px 70px 70px;
        border-style: ridge;
    }
</style>
<body>

<div class="entireDiv">
    <div class="QuesAnsDiv">
        <%
            QuizContent question = (QuizContent)request.getAttribute("data");
            boolean enableSubmitButton = (boolean)request.getAttribute("enableSubmitButton");
            String submitBtn = "";
            String nextBtn = "";
            String buttonType = "";
            int count = (int)session.getAttribute("count");

            if(question.getQuesType().equals("SA"))
            {
                buttonType = "radio";
            }
            else
            {
                buttonType = "checkbox";
            }

            if(!enableSubmitButton)
            {
                submitBtn = "disabled";
            }
            else
            {
                nextBtn ="disabled";
            }
        %>

        <h2> QUESTION <%=count%> :</h2>
        <hr>
        <div class="quesStyle"><%=question.getQuesDesc()%></div>
        <%
            for (AnswerOption answer : question.getAnswerOptions()){

               request.setAttribute("ansId", answer.getAnsDesc());
               request.setAttribute("ansDesc", answer.getAnsDesc());
        %>
        <form method ="post">
        <div class="options"><input type=<%=buttonType%> class="optionTag" name="selectedOptionId" value="<%= answer.getAnsId() %>"><%= answer.getAnsDesc() %></input></div>
        <%}%>

    </div>
    <div class="navBtn">
        <input type="submit" text="submit" value="submit" formaction="./loadquestionanswerservlet" name="action" class="prevBtn" <%=submitBtn%>/>
        <input type="submit" text="next" value="next" formaction="./loadquestionanswerservlet" name= "action" class="nextBtn" <%=nextBtn%>/>
        </form>
    </div>
</div>
</body>
</html>
