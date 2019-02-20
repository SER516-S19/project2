<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jahnvi
  Date: 2/19/19
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
    <link href="../css/bootstrap.min.css"  rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<%
    List<String> quizNames = (ArrayList<String>) request.getAttribute("quizNames");
%>
<h2>Quiz</h2>
<p>
    You have following quizzes for the course!! <br>
</p>
<form method="GET" >
<div class="container">
    <table class="table table-bordered">
        <%
            for(String quiz : quizNames){
        %>
        <tr>
            <td><%=quiz%> <a href="student/?id=<%=quiz%>">Click here to start the quiz</a></td>
        </tr>

        <%
            }
        %>
    </table>
</div>
</form>
</body>
</html>
