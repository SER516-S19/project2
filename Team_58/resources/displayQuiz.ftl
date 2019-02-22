<html>
<head>
    <title>QUIZ</title>
</head>
<body>
<form action="DisplayQuizServlet" method="GET">
        <p>${Session.QuestionsVO.getQuestion()} </p>
</form>
</body>
</html>