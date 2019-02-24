<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "ser516p2";
String userid = "root";
String password = "199021";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>

<h1>Information of Quiz</h1>
<table border="1">
<tr>
<td>quiz title</td>
<td>status</td>
<td>Due Date</td>
<td>Time Limit</td>
<td>Quiz Type</td>
</tr>

	


<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from quiz";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("quiztitle") %></td>
<td><%=resultSet.getString("status") %></td>
<td><%=resultSet.getString("DueDate") %></td>
<td><%=resultSet.getString("TimeLimit") %></td>
<td><%=resultSet.getString("QuizType") %></td>

</tr>
</table>

<table border="1">
</tr>
<div class ="instruction_area">
<tr>
<td>Quiz Instruction</td>
</tr>
<tr>
<td><%=resultSet.getString("qinstruct") %></td>
</tr>
</div>
</table>

<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>


<input type="submit" value="Start Quiz">
</body>
</html>