<%--
  Created by IntelliJ IDEA.
  User: saksh
  Date: 3/1/2019
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<html>
<head>
    <title>view-list</title>
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
            padding-top: 10px;
        }
        .inTable {
            align-items: center;
            justify-content: center;
            display: flex;
            padding-top: 10px;
        }
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
        h3 {
            text-align: center;
            color: white;
            font-size: 36px;
            padding-top: 20px;
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
    <h1>View Student List</h1>

    <div class="wrapper">
        <table>
            <tr>
                <th><h3>Student ID</h3></th>
            </tr>
            <c:forEach items="${studentIds}" var="studentId">
                <tr>
                    <td>
                        <div class="wrapper">
                            <form action="viewStudentDetails" method="GET">
                                <input type="hidden" name="studentId" value="${studentId}">
                                <input type="submit" value="Student ${studentId}" class="btn1">
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
