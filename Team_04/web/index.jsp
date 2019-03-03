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
        body {
            background-color: #4a154b;
        }

        .btn1 {
            display: inline-block;
            white-space: nowrap;
            flex-basis: auto;
            width: auto;
            font-size: .875rem;
            background-color: white;
            border: none;
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
            color: #4a154b;
        }

        .btn2 {
            display: inline-block;
            white-space: nowrap;
            flex-basis: auto;
            width: auto;
            font-size: .875rem;
            background-color: white;
            border: none;
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
            color: #4a154b;
            margin-left: 15px;
            margin-right: 15px;
        }

        h1 {
            text-align: center;
            color: white;
            font-size: 64px;
            padding-left: 20px;
            font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
        }

    </style>
</head>
<body>
<h1>Available Functionality</h1>
<div>
    <form method="get">
        <table>
            <tr>
                <input type="submit" class="btn1" formaction="./createContent.jsp" name="action"
                       value="CREATE QUIZ"/>
            </tr>
            <tr>
                <input type="submit" class="btn2" formaction="./list" name="action"
                       value="VIEW QUIZ LIST"/>
            </tr>
            <tr>
                <input type="submit" class="btn2" formaction="./studentList"
                       value="VIEW STUDENT LIST"/>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
