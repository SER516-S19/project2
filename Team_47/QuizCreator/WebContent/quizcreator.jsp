<!-- 
  - Author(s): Suraj Atmakuri
  - Date: 2019/2/20
  - Description: Page for creating quizzes
  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

 <head>
    <meta charset="UTF-8">
    <meta id="request-method" name="request-method" content="GET">
    <meta name="author" content="Suraj Atmakuri">
    <meta name="copyright" content="© 2019 Suraj Atmakuri. All Rights Reserved.">
    <meta name="keywords" content="Quizzes Overview">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>
        Quiz editor
    </title>
     <link rel="stylesheet" href="CSS/quizcreator.css" type="text/css" />
     <script src="js/quizcreator.js"></script>
 </head>

 <body>
 <div id='top'>
   <p><a href="loginpage.jsp" class='button' align:"right">logout</a></p>
 </div>
 <div id='mid'>
  <form action="summarypage.jsp">
    quiz title: </br>
    <input type='text' name='title' value='enter the title'size=30></br>
    enter instructions:</br>
    <input type='text' name='instructions' value='enter instructions'size=30></br>
    enter the group of the quiz:</br>
    <input type='text' name='group' value='group name' size=30></br>
    enter the type of the quiz:
    <select>
      <option value='g'> graded </option>
      <option value='ug'> ungraded </option>
     </select> <br>
    enter the start date:</br>
    <input type='date' id='start' name='start_date' value='28-02-19' min='01-01-19' max='01-05-19'><br>
    enter start time:</br> 
    <input type='time' id='stime' name='start_time' value='13:30' min='00:00' max='23:59'><br>
    enter the end date:</br>
    <input type='date' id='end' name='end_date' value='29-02-19' min='02-01-19' max='07-05-19'><br>
    enter end time:</br>
    <input type='time' id='etime' name='end_time' value='1:30' min='00:00' max='23:59'><br>
    enter the duration of the quiz:</br>
    <input type='text' id='hrs' value='0' min='0' max='3'>hrs
    <input type='text' id='min' value='0' min='0' max='59'>mins
    <div id='div1'>
    </div>
    <input type='button' onclick='addFields()' value='add question'>
    <input id = "beginbtn" type="submit" value="Submit">
   </form>
  </div>
 </body>
</html>