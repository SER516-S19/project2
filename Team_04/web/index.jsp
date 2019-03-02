<%--
  Created by IntelliJ IDEA.
  User: amankaushik,saivinayg
  Date: 18/2/19
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hacky-blackboard</title>
    <style>
        body{
            background-color: #191970;
            border-style: outset;
            border-width: medium;
            border-radius: 10px;
            border-color: cyan;
        }
        h1{
            color: white;
            font-size: 40px;
            padding: 200px 450px 10px;
            font-family: Arial, sans-serif;
        }

        .buttn1 {
            background-color: cyan;
            text-align: center;
            font-family: Arial, sans-serif;
            font-weight: 600;
            font-size: 15px;
            display: inline-block;
            white-space: nowrap;
            flex-basis: auto;
            width: auto;
            border-radius: 8px;
            border: none;
            cursor: pointer;
            line-height: 1.2;
            letter-spacing: .7px;
            padding: 19px 40px 20px;
            margin-left: 450px;
            margin-right: 15px;
        }
        .buttn2 {
            background-color: cyan;
            text-align: center;
            font-family: Arial, sans-serif;
            font-weight: 600;
            font-size: 15px;
            display: inline-block;
            white-space: nowrap;
            flex-basis: auto;
            width: auto;
            border-radius: 8px;
            border: none;
            cursor: pointer;
            line-height: 1.2;
            letter-spacing: .7px;
            padding: 19px 40px 20px;
            margin-left: 15px;
            margin-right: 15px;
        }
    </style>
</head>
<body>
<h1>Available Functionality</h1>
<form method="get">
    <div>
        <input type="submit" class="buttn1" formaction="./createContent.jsp" name="action" value="CREATE QUIZ"/>
        <input type="submit" class="buttn2" formaction="./list" name="action" value="VIEW QUIZ LIST"/>
        <input type="submit" class="buttn3" formaction="./studentList" name="action" value="VIEW STUDENT LIST"/>
    </div>
</form>
</body>
</html>

