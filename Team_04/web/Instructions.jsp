<%--
  Created by IntelliJ IDEA.
  User: harik
  Date: 2/21/2019
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> QUIZ INSTRUCTIONS </title>
</head>
<style>
    .btn2 {
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
</style>
<body>
<form action ="./loadquestionanswerservlet" method="get">
    <p style="font-size:200%;" align="center"> QUIZ INSTRUCTIONS </p>
    <div style="font-family:Sans-serif; font-size:100%; line-height: 1.0; padding: 3em;">
        <p>The following are the instructions realted to the quiz : </p> <br>
        <ul>
            <li> Work in teams of 5 or 7 </li><br>
            <li>Submit a reviewed version of your Quiz 2 here. </li><br>
            <li>Submission should be done by only one member in the team through Blackboard.</li><br>
            <li>Add the team members names to the document in a separated page (only the names of these who collaborate).</li><br>
            <li>Due by Tuesday  February 12</li>
        </ul>
    </div>
    <br>
    <p align="center">
        <input type = "submit" class = "btn2" name="action" value = "START QUIZ" >
    </p>
</form>
</body>
</html>




