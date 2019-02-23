<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Form</title>
</head>
<body>
<h1>Registration Form</h1>
<form action="Login" method="post">
    <table cellpadding="3pt">
        <tr>
            <td>User Name :</td>
            <td><input type="text" name="userName" size="30" /></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="password" name="password1" size="30" /></td>
        </tr>

        <tr>
            <td>Confirm Password :</td>
            <td><input type="password" name="password2" size="30" /></td>
        </tr>
        <tr>
            <td>email :</td>
            <td><input type="text" name="email" size="30" /></td>
        </tr>
    </table>
    <p />
    <input type="submit" value="Register" />
</form>
</body>
</html>