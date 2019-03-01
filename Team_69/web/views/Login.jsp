<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type='text/css' rel='stylesheet' href='../css/Login.css' />
    <title>Login</title>
</head>
<body>
<h2  style="color:blue;text-align:center">
    Welcome to Quiz Portal!!
</h2>
<form action="Login" method="POST">

    <label for="Email"><b>UserEmail</b></label><br>
    <input type="text" placeholder="Enter your email" name = "userEmail" id="Email" required><br>

    <label for="password"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="userPassword" id ="password" required><br>

    <button type="submit">Login</button>
</form>
</body>
</html>
