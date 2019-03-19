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
    <script>
        $(function(){

            $(".dropdown-menu li a").click(function(){

                $(".btn:first-child").text($(this).text());
                $(".btn:first-child").val($(this).text());

            });

        });
    </script>
    <style>
        .col-centered{
            float: none;
            margin: 0 auto;
        }
        p.big {
            line-height: 2.0px;
        }
        .wrapper {
            padding-top: 10px;
            display: flex;
            --padding-bottom: 2px;
        }
    </style>
    <%
        //String userName = request.getAttribute("userEntName").toString();
        String userStatus;
        if (request.getParameterMap().containsKey("userStatus")) {
            userStatus = request.getAttribute("userStatus").toString();
        } else {
            userStatus = "";
        }
    %>
    <script type="text/javascript">
        var userStat =  "<%=userStatus%>";
        if(userStat === "returningUser")
        {
                alert("User already exists, please login");
        }
    </script>
</head>
<body style="background-color:#8C1D40">
">
<div class="container">
    <div class="col-xs-12 col-sm-8 col-md-4 col-lg-4 col-centered">
        <div class="jumbotron">
            <h3>Please login</h3>

            

            <form method = "POST">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="email" name="username" class="form-control" placeholder="Enter Username" required="true">

                </div>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" name="password" class="form-control" placeholder="Enter password" required="true">
                </div>

                <div class="form-group wrapper">
                    <select class="form-control" id="exampleFormControlSelect1" name="userTypeBtn">
                        <option value="" selected disabled>Select User</option>
                        <option>Professor</option>
                        <option>Student</option>
                    </select>
                </div>
                <div class="custom-checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
                    <input type="submit" class="btn-primary form-control" name="action" formaction="./quiz" value = "Login">

                <div class="mt-4">
                    <div class="d-flex justify-content-center links">
                        Don't have an account? <a href="./signup.jsp" name="action" class="ml-2">Sign Up</a>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

</body>
</html>