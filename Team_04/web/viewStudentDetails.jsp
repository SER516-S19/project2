<%@ page import="java.util.List" %>
<%@ page import="content.creator.dao.QuizResultDAO" %><%--
  @author Sakshi Gautam
  @version 1.4
  @since   2019-02-28
  Description: Displays student statistics for the quiz.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            background-color: dimgrey;
            color: whitesmoke;
            vertical-align: baseline;
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
            font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
        }
        .panel {
            align: center;
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
    </style>

</head>
<body>
<div class="panel">
    <h1> <%="Student Details"%></h1>
    <div class="wrapper">
        <table class="inTable">
            <tr>
                <th>Quiz ID</th>
                <th>Attempt ID</th>
                <th>Score</th>
            </tr>

            <%
                List<QuizResultDAO> studentDataList = (List<QuizResultDAO> )request.getAttribute("studentDetails");
                for (QuizResultDAO studentResponse: studentDataList) {
            %>
            <tr>
                <th><%=studentResponse.getQuizId()%></th>
                <th><%=studentResponse.getAttemptId()%></th>
                <th><%=studentResponse.getFinalScore()%></th>
            </tr>

            <%
                }
            %>
            <tr>
                <th>Total No of Quizzes: ${totalQuizzes}</th>
                <th></th>
                <th>TotalScore: ${score}</th>
            </tr>
        </table>
    </div>
    <div class="wrapper">
        <form action="studentList">
            <input type="submit" value="Back" class="btn2">
        </form>
    </div>
</div>
</body>
</html>