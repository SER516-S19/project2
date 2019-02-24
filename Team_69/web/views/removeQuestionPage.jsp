<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove button to remove question</title>
</head>
<body>

	<form action="../ProfessorController" method="post">
		<input id="flag" name="box1" >
	    <input type="submit" value="DeleteQuestion" name="flag" class="btn btn-primary" />
	</form>

</body>
</html>