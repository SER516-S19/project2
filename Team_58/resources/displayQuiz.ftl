<html>
<head>
    <title>QUIZ</title>
</head>
<body>
<form action="DisplayQuizServlet" method="GET">
        <p>
            <b>${Session.QuestionsVO.getQuestion()}</b>
            <i>${Session.QuestionsVO.getTotalPoints()}</i>
            <input type="radio" name= "questionId" value="${Session.QuestionsVO.getCorrectAnswer()}">
            <input type="radio" name= "questionId" value="${Session.QuestionsVO.getIncorrectAnswer1()}">
            <input type="radio" name= "questionId" value="${Session.QuestionsVO.getIncorrectAnswer2()}">
            <input type="radio" name= "questionId" value="${Session.QuestionsVO.getIncorrectAnswer3()}">
        </p>
</form>
</body>
</html>