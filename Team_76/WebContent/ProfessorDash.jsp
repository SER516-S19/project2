<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        ul {
          list-style-type: none;
          margin: 0;
          padding: 0;
          overflow: hidden;
          background-color: #333;
        }

        li {
          float: left;
        }

        li a {
          display: block;
          color: white;
          text-align: center;
          padding: 14px 16px;
          text-decoration: none;
        }

        li a:hover {
          background-color: #111;
        }

        input[type=submit] {
          width: 20%;
          background-color: #720c0c;
          color: white;
          padding: 14px 20px;
          margin: 8px 0;
          border: none;
          border-radius: 4px;
          cursor: pointer;
        }

        input[type=submit]:hover {
          background-color: #961212;
        }
        .dropbtn {
          background-color: #720c0c;
          color: white;
          padding: 16px;
          font-size: 16px;
          border: none;
        }

        .dropdown {
          position: relative;
          display: inline-block;
        }

        .dropdown-content {
          display: none;
          position: absolute;
          background-color: #f1f1f1;
          min-width: 160px;
          box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
          z-index: 1;
        }

        .dropdown-content a {
          color: black;
          padding: 12px 16px;
          text-decoration: none;
          display: block;
        }

        .dropdown:hover .dropdown-content {display: block;}

        .dropdown:hover .dropbtn {background-color: #961212;}
    </style>


    <body>
   <%
        String uName = (String) session.getAttribute("uName");
        String isSessionValid = (String) session.getAttribute("validSession");
        if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
                || uName == null || uName.isEmpty()) {
            response.sendRedirect("Login.jsp");
        }
    %>
    <div style="float: center">
        <form align="right" action="LoginController" method="post">
            <input type="hidden" name="action" value="logoff"> <input
                type="submit" value="LogOut" class="logout">
        </form>
    </div> 

        <ul class="topnav">
            <li><a href="#news">WELCOME PROFESSOR</a></li>
           <!--  <li class="right" style="text-align: right"><a href="#">LOGOUT</a></li> -->
        </ul>

        <br/> <br/>

        <form action="ProfessorController" method="post">
            <div class="check">
                <div class="BTN">
                    <input type="hidden" name="action" value="CreateQuiz">
                    <input style="margin-left:auto;margin-right:auto"
                    type="submit" name="CreateQuiz" value="CreateQuiz">
                </div>
            </div>
        </form>

    <!--     <form action="ProfessorController" method="post">
            <input type="hidden" name="action" value="Questions">
            <input type="submit" value="Questions">
        </form> -->

        <form action="ProfessorController" method="post">
            <div class="check">
                <div class="BTN">
                    <input type="hidden" name="action" value="ViewGrades">
                    <input style="margin-left:auto;margin-right:auto"
                    type="submit" name="ViewGrades" value="ViewGrades">
                </div>
            </div>
        </form>

        <form action="ProfessorController" method="post">
            <div class="check">
                <div class="BTN">
                    <input type="hidden" name="action" value="Statistics">
                    <input style="margin-left:auto;margin-right:auto"
                    type="submit" name="Statistics" value="Statistics">
                </div>
            </div>
        </form>
    </body>
</html>
