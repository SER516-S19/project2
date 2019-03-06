<%--
  Created by IntelliJ IDEA.
  Modified by: Archana Madhavan
  Date: 28/2/19
  Description: Displays the quiz details for quiz selected.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
    <title>Quiz details</title>
    <style>
        table {
            font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
            border-collapse: collapse;
            width: 80%;
            background-color: dimgrey;
            color: whitesmoke;
            vertical-align: baseline;
            margin: auto;
        }
        tr:nth-child(even) {
            background-color: #8a154b;
            color: white;
        }
        td {
            text-align: left;
            padding: 1%;
        }
        th {
            text-align: center;
            padding: 8px;
        }
        .wrapper {
            align-items: center;
            justify-content: center;
            display: flex;
            padding-bottom: 30px;
        }
        .inTable {
            align-items: center;
            justify-content: center;
            padding-top: 10px;
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
            margin-top: auto;
            font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
        }
    </style>
</head>
<body>

<h1> <%="Quiz Details"%></h1>

<div class="wrapper">
    <form action="list">
        <input type="submit" class="btn2" value="Back">
    </form>

    <form action="quizstats" method="GET">
        <input type="hidden" name="quizid" value="${quizid}">
        <input type="submit" class="btn2" value="Quiz Statistics">
    </form>

    <form action="delete" method="POST">
        <input type="hidden" name="quizid" value="${quizid}">
        <input type="submit" class="btn2" value="Delete Quiz">
    </form>

    <form action="addQues" method="POST">
        <input type="hidden" name="quizid" value="${quizId}">
        <input type="submit" class="btn2" value=" Add Question ">
    </form>
</div>

<div class="inTable">
    <table>
        <tr>
            <th>Question Number</th>
            <th>Questions</th>
            <th>Score</th>
            <th>Modify</th>
            <th>Delete</th>
        </tr>

        <%
            Map<Integer, List<String>> answers= (Map<Integer, List<String>>) request.getAttribute("answers");
            Map<Integer, Map<String, String>> questionList=(HashMap)request.getAttribute("questions");
            for(Integer quesId:questionList.keySet()){
        %>
        <tr>
            <th><%=quesId%></th>
            <td><%=questionList.get(quesId).get("desc")%></td>
            <th><%=questionList.get(quesId).get("score")%></th>
            <td>
                <form action="modQues" class="inTable" method="POST">
                    <input type="hidden" name="quizid" value="${quizId}">
                    <input type="hidden" name="quesid" value="<%=quesId%>">
                    <input type="submit" class="btn2" value=" Modify ">
                </form>
            </td>
            <td>
                <form action="delQues" class="inTable" method="POST">
                    <input type="hidden" name="quizid" value="${quizId}">
                    <input type="hidden" name="quesid" value="<%=quesId%>">
                    <input type="submit" class="btn2" value=" Delete ">
                </form>
            </td>
        </tr>

        <tr>
            <%
                for(String answer: answers.get(quesId)) {
            %>
            <td></td>
            <td>
                <ul>
                    <li><%=answer%></li>
                </ul>
            </td>
            <td></td>
            <td></td>
            <td></td>
        </tr>

        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>
