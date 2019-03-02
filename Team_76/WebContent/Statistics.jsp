<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Statistics</title>
		<style>
		    .logoutonly { margin-left: 350px !important; }
		    ul {
				list-style-type: none;
		        margin: 0;
		        padding: 0;
		        overflow: hidden;
		        background-color: #333;
		    }
		
			li { float: left; }

		    li a {
				display: block;
		        color: white;
		        text-align: center;
		        padding: 14px 16px;
		        text-decoration: none;
			}
		
			li a:hover { background-color: #111; }
		
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
		
			input[type=submit]:hover { background-color: #961212; }
		        
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
	       <li><a href="ProfessorDash.jsp">DASHBOARD</a></li>
	       <li>
	           <div style="float: center">
	               <form  action="LoginController" method="post">
	                   <input type="hidden" name="action" value="logoff">
	                   <input class="logoutonly" type="submit" value="LogOut" class="logout">
	               </form>
	           </div>
	       </li>
	     </ul>
	    
		<h1>View Statistics here.</h1>

	</body>
</html>
