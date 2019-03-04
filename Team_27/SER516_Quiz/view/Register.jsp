<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  JSP page that takes data as input for user registration.
  @author (Yuti Desai),(Palak Chugh)
  @version (1.0)
  @createDate 24 Feb 2019
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Register.css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="addQuestionscss/addQuestionsStyles.css">
	<link rel="stylesheet" type="text/css"
		href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cosmo/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
		integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<title>Register</title>
<script>
	function validate() {
		var fullname = document.form.fullname.value;
		var email = document.form.email.value;
		var username = document.form.username.value;
		var password = document.form.password.value;
		var conpassword = document.form.conpassword.value;

		if (fullname == null || fullname == "") {
			alert("Full Name can't be blank");
			return false;
		} else if (email == null || email == "") {
			alert("Email can't be blank");
			return false;
		} else if (username == null || username == "") {
			alert("Username can't be blank");
			return false;
		} else if (password.length < 6) {
			alert("Password must be at least 6 characters long.");
			return false;
		} else if (password != conpassword) {
			alert("Confirm Password should match with the Password");
			return false;
		}
	}
</script> 
</head>
<body>
	<div class="pageheader">
		<h2>User Registration </h2>
	</div>
	<div class="myformstyle">
	<form name="form" action="RegisterController" method="post"
		onsubmit="return validate()" id="quizRegister">
		<div class="mytablestyle">
		<table align="center" cellspacing="20">
			 <tr>
				 <td>Full Name</td>
 				 <td><input type="text" name="fullname" /></td>
			 </tr>
 			 <tr>
				 <td>Email</td>
				 <td><input type="text" name="email" /></td>
 			 </tr>
			 <tr>
 				 <td>I am a</td>
				 <td>
 				 <select name="user_type">
 				 <option value="student">Student</option>
   				 <option value="professor">Professor</option>
 				 </select>
 				 </td>
 			 </tr>
 			 <tr>
 				 <td>Username</td>
 				 <td><input type="text" name="username" /></td>
 			 </tr>
 			 <tr>
 				 <td>Password</td>
 				 <td><input type="password" name="password" /></td>
 			 </tr>
 			 <tr>
 				 <td>Confirm Password</td>
 				 <td><input type="password" name="conpassword" /></td>
 			 </tr>
 			 <tr>
 				 <td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
 			 </tr>
 			 <tr>
 				 <td></td>
 				 <td>
 				 
 				 </td>
 `       	 </tr>
		</table>
		</div>
		<div>
		<input type="submit" class="btn btn-success" value="Register"></input>
 		<input type="reset" class="btn btn-info"  value="Reset"></input>
		</div>
	</form>
	</div>
</body>
</html>