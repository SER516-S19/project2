<html>
<head>
    <title>QUIZ</title>
</head>
<body>
<form action="DisplayQuizServlet" method="GET">
        <p>
            <b>${Session.QuestionsVO.getQuestion()}</b>
            <i>${Session.QuestionsVO.getTotalPoints()}</i>
            <input type="radio" value="${Session.QuestionsVO.getCorrectAnswer()}">
            <input type="radio" value="${Session.QuestionsVO.getInCorrectAnswer()}">
            <input type="radio" value="${Session.QuestionsVO.getInCorrectAnswer()}">
            <input type="radio" value="${Session.QuestionsVO.getInCorrectAnswer()}">
        </p>
</form>
</body>
</html>