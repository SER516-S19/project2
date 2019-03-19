<%--
      Created by IntelliJ IDEA.
      User: appy
      Modified By: pradeep
      Date: 17/2/19
      Time: 5:16 PM
      Description: Dashboard for Professor and Student.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select USER</title>
</head>
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

    .professor {
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

    .student {
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
        font-size: 80px;
        padding-left: 20px;
        font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
    }
</style>
<body>
<form class="panel" method="get">
    <h1>Select the user</h1>
    <div class="wrapper">
        <input type="submit" class="professor" formaction="./index.jsp" name="action" value="professor"/>
        <input type="submit" class="student" formaction="./instructions" name="action" value="student"/>
    </div>
</form>
</body>
</html>