<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css">
<style>
.button {
  top: 30%;
  display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #720c0c;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color:  #961212}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>
</head>
<body>
<%
			String uName = (String) session.getAttribute("uName");
			String isSessionValid = (String) session.getAttribute("validSession");
			if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True") || uName == null || uName.isEmpty()) {
				response.sendRedirect("Login.jsp");
			}
		%>
	 	 <ul>
			<li><a href="ProfessorDash.jsp" class="w3-bar-item">DASHBOARD</a></li>
			<li style="float:right">
		        <form  action="LoginController" method="post">
		            <input type="hidden" name="action" value="logoff">
		            <input class="logoutonly" type="submit" value="LogOut" class="logout">
		        </form>
	        </li>
		</ul> 
		<form action="ProfessorController" method="post">
		<input type="hidden" name="action" value="AddQuestion"> <input
				class="btn btn-primary" type="submit" name="AddQuestion"
				value="AddQuestion">
		</form>
		<form action="ProfessorController" method="post">
		<input type="hidden" name="action" value="Submit"> <input
				class="btn btn-primary" type="submit" name="Submit"
				value="Submit">
			</form>
</body>
</html>
