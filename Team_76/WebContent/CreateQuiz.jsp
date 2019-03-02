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
				box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
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
	</head>
	
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
	       <li><a href="ProfessorDash.jsp">DASHBOARD</a></li>
	       <li style="float:right">
	           <div style="float: center">
	               <form  action="LoginController" method="post">
	                   <input type="hidden" name="action" value="logoff">
	                   <input class="logoutonly" type="submit" value="LogOut" class="logout">
	               </form>
	           </div>
	       </li>
	   </ul>
	 	
		<p>QUIZ TITLE</p>
		
		<div>
			<form action="ProfessorController" method="post">
				<input type="text" name="quiztitle" placeholder="Takes quiztitle">
				<p>QUIZ INSTRUCTIONS</p>
				<textarea name="qinstruct" rows="20" cols="100"></textarea>
				<p>SELECT THE QUIZ TYPE</p>
				<div class="dropdown">
					<select>
					<option name="qtype" class="dropbtn">MCQ</option>
					<option name="qtype" class="dropbtn">Subjective</option>
					<option name="qtype" class="dropbtn">Practice</option>
					</select>
				</div>
				<br>
				<p>OPTIONS<p>
				<form action="/action_page.php">
				    <input type="checkbox" name="ShuffleAns" value="Shuffle">Shuffle Answers<br>
	  				<input type="checkbox" name="TimeOp1" value="T1">Timed<br>
	  				<input type="checkbox" name="TimeOp2" value="T2">Not Timed (Practice Mode)<br>
				</form>
				<form action="ProfessorController" method="post">
					<input type="hidden" name="action" value="Continue1"> 
					<input type="submit" value="CONTINUE">
				</form>
			 	<form action="ProfessorController" method="post">                
					<input type="hidden" name="action" value="Cancel"> 
					<input type="submit" value="CANCEL">
				</form> 
			</form>
		</div>
		
	</body>
</html>
