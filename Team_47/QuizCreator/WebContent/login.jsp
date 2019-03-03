<%-- 
  - Author(s): Krishna Chandu Akula, Yu-Ting Tsao, Venkata Sai Ram Eadala
  - Date: 2019/2/18
  - Description: Login page for both the professor and students.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/loginstyle.css" />
<link rel="icon" type="image/png" href="favicon.png" />
<title>Blackboard Login</title>
</head>
<body>
<form class="login-form" id="loginForm">
    <div class="login-page">
        <div class="form">
            <h2>Blackboard Login</h2>
            <input type="text" placeholder="Username" id ="username" name="username" required />
            <input type="password" placeholder="Password" id="password" name="password" required />
            <!-- Use this comment code if the servlet is done, the servlet should redirect 
            you to the following page. Also comment the below "button" tag.
            <input id="sub" type="submit" value="LOGIN" formmethod="post" formaction="/login">
            -->
            <button id="btnlogin" onclick="loginCheck()">login</button> 
        </div>
        <div class="radio-group">
            <input type="radio" name="identity" class="rd2" value="student" id="student_radio" checked>
            <label for="student_radio">Student </label>
            <input type="radio" name="identity" class="rd1" value="professor" id="professor_radio">
            <label for="professor_radio">Professor </label>
        </div>
    </div>
    <div id="wrong">
      <h3>username or password is wrong</h3>
    </div>
</form>
<script type="text/javascript" src="js/validatelogin.js"></script>
</body>
</html>