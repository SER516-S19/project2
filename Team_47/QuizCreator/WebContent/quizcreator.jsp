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
    <script src="js/quizcreator.js"></script>
</head>

<body>
    <div id='top'>
        <p><a href="login.jsp" class='button' align:"right">logout</a></p>
    </div>
    <div id='mid'>
        <form action="summarypage.jsp">
            Quiz title:</br>
            <input type='text' name='title' value='enter the title' size=30></br>
            Instructions:</br>
            <input type='text' name='instructions' value='enter instructions' size=30></br>
            Group of the quiz:</br>
            <input type='text' name='group' value='group name' size=30></br>
            Type of the quiz:
            <select>
                <option value='g'> graded </option>
                <option value='ug'> ungraded </option>
            </select> <br>
            Start date:</br>
            <input type='date' id='start' name='start_date' value='2019-03-01' min='2019-01-01' max='2019-05-30'><br>
            Start time:</br>
            <input type='time' id='start_clock' name='start_clock' value='13:30' min='00:00' max='23:59'><br>
            End date:</br>
            <input type='date' id='end' name='end_date' value='2019-03-01' min='2019-01-01' max='2019-05-30'><br>
            End time:</br>
            <input type='time' id='end_clock' name='end_clock' value='13:30' min='00:00' max='23:59'><br>
            Duration of the quiz:</br>
            <input type='text' id='hrs' value='0' min='0' max='3'>hrs
            <input type='text' id='min' value='0' min='0' max='59'>mins

            <div id='questionsDiv'>
                <script>
                    var questionDict = {};
                    var idTracingList = [];
                    var questionChoiceIterator = 0;
                </script>
                <input type='button' onclick='addFields(questionsDiv, idTracingList)' value='add question'>
            </div>
            <input type="button" id="submitQuizRequest" onclick='createDictionUsingPageData(idTracingList, questionDict)' value="Submit">

        </form>
    </div>
</body>

</html>