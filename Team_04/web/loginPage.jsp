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
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" intgrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

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
    <%
        String userName = request.getAttribute("userEntName").toString();
        String userStatus = request.getAttribute("userStatus").toString();
    %>
    <script type="text/javascript">
        var userStat =  "<%=userStatus%>";
        if(userStat === "returningUser")
        {
                alert("User already exists, please login");
        }
    </script>
</head>
<body style="background-color: #4a154b">
<div class="container">
    <div class="col-xs-12 col-sm-8 col-md-4 col-lg-4 col-centered">
        <div class="jumbotron">
            <h3>Please login</h3>

            

            <form method = "post">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="email" name="username" class="form-control" placeholder="Enter Username">

                </div>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" name="password" class="form-control" placeholder="Enter password">
                </div>
                
                    <%--<div class="dropdown">--%>
                        <%--<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                            <%--Select User--%>
                        <%--</button>--%>
                        <%--<div class="dropdown-menu" id="size-dropdown">--%>
                            <%--<a class="dropdown-item" href="#">Student</a>--%>
                            <%--<a class="dropdown-item" href="#">Professor</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                
                <div class="custom-checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
                    <input type="submit" class="btn-primary form-control" name="action" formaction="./quiz" value = "Login">

                <div class="mt-4">
                    <div class="d-flex justify-content-center links">
                        Don't have an account? <a href="#" formaction="./signupPage.jsp" name="action" class="ml-2">Sign Up</a>
                    </div>
                    <div class="d-flex justify-content-center links">
                        <a href="#">Forgot your password?</a>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

</body>
</html>