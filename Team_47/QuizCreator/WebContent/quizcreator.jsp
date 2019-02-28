<!-- 
  - Author(s): Meng-Ze Chen, Jiayan Wang
  - Date: 2019/2/20
  - Description: Page for creating quizzes
  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta id="request-method" name="request-method" content="GET">
    <meta name="author" content="Meng-Ze Chen, Jiayan Wang">
    <meta name="copyright" content="© 2019 Meng-Ze Chen, Jiayan Wang. All Rights Reserved.">
    <meta name="keywords" content="Quizzes Overview">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>
        Quiz editor
    </title>
    <link rel="stylesheet" href="CSS/quizcreator.css" type="text/css" />
    <script src="js/quizcreator.js"></script>
</head>

<body>
    <div id='top'>
        <p><a href="login.jsp" class='button' align:"right">logout</a></p>
    </div>
    <div id='mid'>
        <form action="summarypage.jsp">
            Quiz title:</br>
            <input type='text' name='title' value='enter the title' size=30></br>
            Instructions:</br>
            <input type='text' name='instructions' value='enter instructions' size=30></br>
            Group of the quiz:</br>
            <input type='text' name='group' value='group name' size=30></br>
            <div id='questionDiv'>
                <input type='button' onclick='addFields(this)' value='add question'>
            </div>
            <input id="beginbtn" type="submit" value="Submit">

        </form>
    </div>
</body>

</html>