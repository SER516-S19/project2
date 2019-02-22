<%@ page import="com.model.QuestionAnswers" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.QuestionAnswers" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: yuvan
  Date: 2/20/2019
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<style>
    .QuesAnsDiv
    {
        width:59%;
        margin-top:10%;
        margin-left: 25%;
    }
    .navBtn
    {
        margin-left:60%;
    }
    .prevBtn, .nextBtn
    {
        display: inline-block;
        white-space: nowrap;
        flex-basis: auto;
        width: auto;
        border: none;
        cursor: pointer;
        border-radius: 4px;
        text-align: center;
        font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
        font-weight: 400;
        line-height: 1.28571429;
        letter-spacing: .5px;
        text-transform: uppercase;
        padding: 10px 30px 10px;
        transition: box-shadow 420ms cubic-bezier(.165, .84, .44, 1), color 420ms cubic-bezier(.165, .84, .44, 1), background 420ms cubic-bezier(.165, .84, .44, 1);

    }
    .quesStyle
    {
        font-size: 200%;

    }
    .options:hover
    {
        background-color: lightgray;
        cursor: pointer;

    }

    .outerDiv
    {
        margin: 20px;
    }
</style>
<body>
<div class="outerDiv">
    <div class="QuesAnsDiv">

        <%Map<String, List<QuestionAnswers>> ques =
                (Map<String, List<QuestionAnswers>>)request.getAttribute("data");
            int count = 1;
            for(String key: ques.keySet()){
        %>
        <p>Question <%= count++ %>.</p>
        <hr>
        <p class="quesStyle"> <%=key %></p>
        <%
            for (QuestionAnswers answers : ques.get(key)) {
                String buttonType = "";
                if(answers.getQues_type().equals("SA"))
                {
                    buttonType = "radio";
                }
                else
                {
                    buttonType = "checkbox";
                }
        %>
        <div class="options"><input type=<%=buttonType%> class="optionTag" data-val=""><%= answers.getAns_desc() %></input></div>
        <%}%>
        <% }%>


    </div>
</div>
<div class="navBtn">
    <input type="button" text="previous" value="previous" class="prevBtn"/>
    <input type="button" text="next" value="next" class="nextBtn"/>
</div>

</body>
</html>
