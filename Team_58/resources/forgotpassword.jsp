<!-- 
JSP page for user to reset password
@authour Vaibhav Bhasin
@version 2.0
@date 02/27/2019
 -->

<!DOCTYPE html>
	<head>
		<meta charset="utf-8">
		<title> Set new Password </title>
		<link rel="stylesheet" type="text/css" href="style.css"/>
	</head>
	<script>
		function validateForm() {
		  var userName = document.forms["Form2"]["username"].value;
		  var newPassword = document.forms["Form2"]["newPassword"].value;
		  
		  if (username == "" || newPassword == "") {
		    alert("Username must be filled out");
		    return false;
		  }
		  if (newPassword == "") {
		    alert("Password must be filled out");
		    return false;
		  }
		}
	</script>
	<body>
		<div class="container">
		    <section id="content">
		            <h1>Set new Password</h1>
		            <div>
		            	<form name="Form2" action="forgotpassword" onsubmit="return validateForm()" method="POST">  
		            		<div></div>
							<input type="text" name="username" placeholder = "Username"/><br/><br/>  
							<input type="password" name="newPassword" placeholder = "Type new Password"/><br/><br/> 
							<input type="submit" value="Submit"/> 
						</form>
		          	</div>
		    </section><!-- content -->
		</div><!-- container -->
	</body>
</html>