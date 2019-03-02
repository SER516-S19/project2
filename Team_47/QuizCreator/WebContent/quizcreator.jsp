<!-- 
  - Author(s): Meng-Ze Chen, Jiayan Wang, Suraj Atmakuri
  - Date: 2019/2/20
  - Description: Page for creating quizzes
  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta id="request-method" name="request-method" content="GET">
    <meta name="author" content="Meng-Ze Chen, Jiayan Wang, Suraj Atmakuri">
    <meta name="copyright" content="© 2019 Meng-Ze Chen, Jiayan Wang, Suraj Atmakuri. All Rights Reserved.">
    <meta name="keywords" content="Quizzes Overview">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>
        Quiz editor
    </title>
    <link rel="stylesheet" href="CSS/quizcreator.css" type="text/css" />
    <script type='text/javascript' src="js/quizcreator.js"></script>
</head>

<body>
    <div id='top'>
        <p><a href="login.jsp" class='button' align:"right">logout</a></p>
    </div>
    <div id='mid'>
        <form action="summarypage.jsp">
            <div id='quizDiv_id'>
                Quiz title:</br>
                <input type='text' id='title_id' name='title' value='enter the title' size=30></br>
                Instructions:</br>
                <input type='text' id='instruction_id' name='instructions' value='enter instructions' size=30></br>
                Group of the quiz:</br>
                <input type='text' id='quizGroup_id' name='group' value='group name' size=30></br>
                Type of the quiz:
                <select id='quizType_id'>
                    <option value='g'> graded </option>
                    <option value='ug'> ungraded </option>
                </select> <br>
                Start date:</br>
                <input type='date' id='start_id' name='start_date' value='2019-03-01' min='2019-01-01'
                    max='2019-05-30'><br>
                Start time:</br>
                <input type='time' id='start_clock_id' name='start_clock' value='13:30' min='00:00' max='23:59'><br>
                End date:</br>
                <input type='date' id='end_id' name='end_date' value='2019-03-01' min='2019-01-01' max='2019-05-30'><br>
                End time:</br>
                <input type='time' id='end_clock_id' name='end_clock' value='13:30' min='00:00' max='23:59'><br>
                Duration of the quiz:</br>
                <input type='text' id='hrs_id' value='0' min='0' max='3'>hrs
                <input type='text' id='min_id' value='0' min='0' max='59'>mins

                <br> <br>
                <script>
                    var questionChoiceIterator = 0;
                    var idTracingList = []
                </script>
                <input type='button' onclick='addFields(this, idTracingList)' value='add question'>
                <input type="button" id="submitQuizRequest" onclick='submitQuizCreateRequest()' value="Submit">
            </div>

        </form>
    </div>
</body>

</html>