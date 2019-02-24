<%--
  Created by IntelliJ IDEA.
  User: ezcat
  Date: 2/21/2019
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>LoginController</title>
</head>
<body>

Sample login Example (try with username as "admin" and password as "admin" without quart ) <br> <br>
<from action="LoginController" method="post">
  Enter username:<input type="text" name="user"><br>
  Enter password:<input type="password" name="pass"><br>
  <input type="submit" value="login">
</from>
</body>
</html>