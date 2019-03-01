<%--
  Created by IntelliJ IDEA.
  User: Sneha Lakshminarasimhan
  Date: 2/25/2019
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <meta charset="utf-8">
    <title>Login</title>

    <style>
        .col-centered{
            float: none;
            margin: 0 auto;
        }
        p.big {
            line-height: 2.0px;
        }
        .btn1{
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
        }
        .wrapper {
            align-items: center;
            justify-content: center;
            display: flex;
            padding-bottom: 30px;
        }
    </style>

</head>
<body style="background-color: #4a154b">
<div class="container">
    <div class="col-xs-12 col-sm-8 col-md-4 col-lg-4 col-centered">
        <div class="jumbotron">
            <h3>Please login</h3>
            <form>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="email" name="username" class="form-control" placeholder="Enter Username">
                </div>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" name="password" class="form-control" placeholder="Enter password">
                </div>
                <div class="auto btnStyle btn-group">
                    <div class="form-text">
                        <button type="button" class="btn form-control dropdown-toggle" style="text-align:right" id="Select User" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Select User
                        </button>
                    <div class="dropdown-menu" id="user-dropdown">
                        <a class="dropdown-item" href="#">Professor</a>
                        <a class="dropdown-item" href="#">Student</a>
                    </div>
                    </div>
                </div>
                <div class="custom-checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
                <div class="wrapper">
                <button type="submit" class="btn-primary form-control">Login</button>
                <input type="submit" class="btn-primary form-control" formaction="./signUp.jsp" name="action" value="Signup"/>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>