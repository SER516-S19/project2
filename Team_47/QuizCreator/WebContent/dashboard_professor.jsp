<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Professor's Dashboard </title>
<link rel="stylesheet" href="CSS/dashboard_professor.css"" type="text/css"/>
</head>
<body>
<div id='top'>
<p><a href="login.jsp" class='button' align:"right">logout</a></p>
</div>
<div id='mid'>
<p>To create a new quiz click the below button<br></p>
<a href='quizcreator.jsp' class='button'>create a new quiz!</a>
</div>
<div id='mid1'>
<p>Previously created Quizzes<p>
<ul>
 <li>
 <a href='allquiz.jsp'>quiz1</a>
 </li>  
 <li>
 quiz2
 </li>  
</ul>
</div>
</body>
</html>
