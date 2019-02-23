<html>
<head>
    <title>QUIZ</title>
</head>
<body>
    <h1 align="center" style="text-decoration-color: black">QUIZ</h1>
    
	        <form action="DisplayQuizServlet" method="GET">
	            
	                <h3 align="center">
	                    Question: ${Session.QuestionsVO.getQuestion()}
	                </h3>
	                <h5 align="center">
	                    Total Points: <i>${Session.QuestionsVO.getTotalPoints()}</i>
	                </h5>
	
	            
	            
	                <h3 align="center">
	                    <input type="radio" name= "questionId" /> ${Session.QuestionsVO.getCorrectAnswer()}
	                </h3>
	                <h3 align="center">
	                    <input type="radio" name= "questionId" /> ${Session.QuestionsVO.getIncorrectAnswer1()}
	                </h3>
	            	<h3 align="center">
	                    <input type="radio" name= "questionId" /> ${Session.QuestionsVO.getIncorrectAnswer2()}
	                </h3>
	                <h3 align="center">
	                     <input type="radio" name= "questionId" /> ${Session.QuestionsVO.getIncorrectAnswer3()}
	                </h3>
	            
	        </form>

</body>
</html>