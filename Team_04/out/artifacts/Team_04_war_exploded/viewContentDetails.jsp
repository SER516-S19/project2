<%--
  Created by IntelliJ IDEA.
  User: amankaushik
  Date: 18/2/19
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view-details</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 20%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h3>
    Question No
</h3>
<h1>
    Question
</h1>
<h2>
    Score: #score
</h2>
<table>
    <tr>
        <th>
            Options
        </th>
    </tr>
    <tr>
        <th>
            <ol type = 'a'>
                <li>First</li>
                <li>Second</li>
                <li>Third</li>
                <li>Fourth</li>
            </ol>
        </th>
    </tr>
</table>
</body>
</html>
