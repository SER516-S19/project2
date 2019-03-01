<!-- 
JSP page for user to login
@authour Aditya Vikram
@version 1.1
@date 02/22/2019
 -->

<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title> Login Screen </title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<script>
function validateForm() {
  var userName = document.forms["myForm"]["username"].value;
  var passWord = document.forms["myForm"]["userpass"].value;
  
  if (userName == "" || passWord == "") {
    alert("Username must be filled out");
    return false;
  }
  if (passWord == "") {
    alert("Password must be filled out");
    return false;
  }
}
</script>
<body>
<div class="container">
    <section id="content">
            <h1>Login Form</h1>
            <div>
            	<form name="myForm" action="login" onsubmit="return validateForm()" method="POST">  
            		<div style="color: #FF0000;">${setMessage}</div>
            		<div></div>
					<input type="text" name="username" placeholder = "Username"/><br/><br/>  
					<input type="password" name="userpass" placeholder = "Password"/><br/><br/> 
					<input type="submit" value="login"/>  
				</form>
				<form name="Form2" action="forgotpassword" method="GET">
					<input type="submit" value="Forgot Password">
				</form>
          	</div>
    </section><!-- content -->
</div><!-- container -->
</body>
</html>