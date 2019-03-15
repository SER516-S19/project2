<%-- 
  - Author(s): Yu-Ting Tsao
  - Date: 2019/3/15
  - Description: Brief answer view and earned points.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Review Page</title>
</head>
<body style="background-color:Silver;">
<h5 style="text-align: center;">Submit Page</h5>

<label>Total questions : </label> <br>
<label class="noOfTotal"> 7 </label>
<br>
<label>Number of questions attempted: </label><br>
<label class="noOfans"> 4 </label>
<br>
<label>Number of questions unattempted: </label><br>
<label class="noOfUnans"> 3 </label><br>
<br>
<form action="resultpage.jsp">
<input id = "beginbtn" type="submit" value="Submit" onclick='location.href=("resultpage.jsp")'>
</form>
</body>
</html>
