<%--
  Created by IntelliJ IDEA.
  User: appy
  Date: 2019-02-26
  Time: 01:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-material-design/4.0.2/bootstrap-material-design.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<style>
    .col-md-8 {
        background-color: #8C1D40
    ;
        height: 100%;

    }

    .col-md-4 {
        padding-top: 100px;
        align: center;
        background-color: white;
    }

    h1 {
        align-items: center;
        justify-content: center;
        display: flex;
        padding-top: 100px;
        color: white;
        font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
    }

    body {
        background-color: #8C1D40

    }

    .row {
        margin: 0px;
    }

    .button {
        display: inline-block;
        white-space: nowrap;
        flex-basis: auto;
        width: auto;
        font-size: .875rem;
        color: white;
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
        background-color: #ea4c89;

    }

    .btnwrapper {
        align-items: center;
        justify-content: center;
        display: flex;
    }

    @media only screen and (max-width: 768px) {
        .col-md-8 {
            height: 250px;
        / height: 60 %;
        }
    }

</style>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1>Sign Up for the Quiz Application</h1>
        </div>
        <div class="col-md-4">
            <form action="./quiz" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1" class="bmd-label-floating">Email address</label>
                    <input type="email" name="username" class="form-control" id="exampleInputEmail1">
                    <span class="bmd-help">We'll never share your email with anyone else.</span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1" class="bmd-label-floating">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <input type="radio" name="userTypeBtn" value="Professor"/> Professor
                    <input type="radio" name="userTypeBtn" value="Student"/> Student
                </div>

                <div class="btnwrapper">
                    <input type="submit" name="action" class="button" value="SignUp"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
