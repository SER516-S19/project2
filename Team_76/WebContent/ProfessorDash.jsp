<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="Style.css">
    <style>
       
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

        .dropdown:hover .dropdown-content { display: block; }
        
		.dropdown:hover .dropbtn { background-color: #961212; }

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
        <ul>
            <li><a href="#news">WELCOME PROFESSOR</a></li>
            <li style="float:right">
                <div style="float: center">
                    <form  action="LoginController" method="post">
                        <input type="hidden" name="action" value="logoff">
                        <input class="logoutonly" type="submit" value="LogOut">
                    </form>
                </div>
            </li>
        </ul>
        
        <br/>

        <form action="ProfessorController" method="post">
            <div>
                <div class="BTN">
                    <input type="hidden" name="action" value="CreateQuiz">
                    <input style="margin-left:auto;margin-right:auto" type="submit" name="CreateQuiz" value="CreateQuiz">
                </div>
            </div>
        </form>
        
        <form action="ProfessorController" method="post">
            <div>
                <div class="BTN">
                    <input type="hidden" name="action" value="ViewGrades">
                    <input style="margin-left:auto;margin-right:auto" type="submit" name="ViewGrades" value="ViewGrades">
                </div>
            </div>
        </form>
        
        <form action="ProfessorController" method="post">
            <div>
                <div class="BTN">
                    <input type="hidden" name="action" value="Statistics">
                    <input style="margin-left:auto;margin-right:auto" type="submit" name="Statistics" value="Statistics">
                </div>
            </div>
        </form>
    </body>
</html>
