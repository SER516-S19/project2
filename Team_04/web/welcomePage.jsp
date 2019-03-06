<%--
  Created by IntelliJ IDEA.
  User: Sreya Narasimhan
  Date: 3/2/2019
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
        form,body, html {
            height: 100%;
            margin: 0;
            font: 400 15px/1.8 "Lato", sans-serif;
            color: #777;
            overflow-x: hidden;
            overflow-y: hidden;
        }

        .bgimg-1 {
            position: relative;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .bgimg-1 {
            background-image: url("https://seeklogovector.net/wp-content/uploads/2018/07/arizona-state-university-asu-logo-vector.png");
            height: 50%;
        }

        .btn2 {
            display: inline-block;
            white-space: nowrap;
            flex-basis: auto;
            width: auto;
            font-size: .875rem;
            background-color: floralwhite;
            border: black;
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
            transition: box-shadow 420ms cubic-bezier(.165, .84, .44, 1), color 420ms cubic-bezier(.165, .84, .44, 1),
            background 420ms cubic-bezier(.165, .84, .44, 1);
            color: #4a154b;
            margin-left: 15px;
            margin-right: 15px;
        }

        .wrapper {
            align-items: center;
            justify-content: center;
            display: flex;
            height: 50%;
            background-color: #8C1D40;
        }
        </style>
    </head>
    <body>
        <div class="bgimg-1">
        </div>
        <form>
            <div class="wrapper">
                <input type="submit" class="btn2" formaction="./dashboard.jsp" name="action" value="Blackboard"/>
            </div>
        </form>
    </body>
</html>