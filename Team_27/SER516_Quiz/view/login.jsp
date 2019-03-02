<!DOCTYPE html>
<html>
	<head>
		<title>Login!</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet"> 
		<script type="text/javascript">
			function showAlert(){
				alert("registerResponse");
			}
		</script>
	</head>
	<body <%=session.getAttribute("regMessage").toString()=="success"?"onLoad=\"showAlert()\"":""%> >
		<form action="login" method="post">
  			<div class="imgcontainer">
    			<h2>Quiz Login!</h2>
  			</div>

  			<div class="container">
    			<label for="username"><b>Username</b></label>
    			<input type="text" placeholder="Enter Username" name="username" required>
    			<br><br>
    			<label for="password"><b>Password</b></label>
    			<input type="password" placeholder="Enter Password" name="password" required>

				<button type="submit">Login</button>
				<%=session.getAttribute("regMessage").toString()=="success"?"":"<button type=\"register\">Register</button>"%>
				
  			</div>


		</form> 
	</body>
</html>