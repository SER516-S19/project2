<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  Modified By: Archana Madhavan
   Date: 18/2/19
  Time: 1:53 PM
  Description: Displays List of Quizzes.
--%>

<html>
<head>
    <title>view-list</title>
    <style>
        .panel {
            align: center;
            background-color: #4a154b;
            margin-right: -15px;
            margin-left: -15px;
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            vertical-align: baseline;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translateX(-50%) translateY(-50%);
        }
        .wrapper {
            align-items: center;
            justify-content: center;
            display: flex;
            padding-bottom: 30px;
        }
        body {
            background-color: #4a154b;
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
<form class="panel" method="get">
    <h1>View Quiz List</h1>
    <div class="wrapper">
        <c:forEach items="${quizIds}" var="quizId">
            <a href="./viewContentDetails?quizId=${quizId}">
                <input type="button" class="btn2" name="action"
                       value="Quiz<c:out value="${quizId}"></c:out>"/>
            </a><br>
        </c:forEach>
    </div>
</form>
</body>
</html>
