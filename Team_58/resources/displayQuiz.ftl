<html>
<head>
    <title>QUIZ</title>
</head>
<body>
<<<<<<< HEAD
    <h1 align="center" style="text-decoration-color: black">QUIZ</h2>
    
        <table style="width: auto" align="center" border="3">
	        <form action="DisplayQuizServlet" method="GET">
	            <tr>
	                <h3>
	                    Question: ${Session.QuestionsVO.getQuestion()}
	                </h3>
	                <h3>
	                    Total Points: <i>${Session.QuestionsVO.getTotalPoints()}</i>
	                </h3>
	
	            </tr>
	            <tr>
	                <td>
	                    <input type="radio" name= "questionId" /> ${Session.QuestionsVO.getCorrectAnswer()}
	                    <input type="radio" name= "questionId" /> ${Session.QuestionsVO.getIncorrectAnswer1()}
	                </td>
	            </tr>
	            <tr>
	                <td>
	                    <input type="radio" name= "questionId" /> ${Session.QuestionsVO.getIncorrectAnswer2()}
	                    <input type="radio" name= "questionId" /> ${Session.QuestionsVO.getIncorrectAnswer3()}
	                </td>
	            </tr>
	        </form>
        </table>




        
   
=======
<form action="DisplayQuizServlet" method="GET">
        <p>
            <b>${Session.QuestionsVO.getQuestion()}</b>
            <i>${Session.QuestionsVO.getTotalPoints()}</i>
            <input type="radio" value="${Session.QuestionsVO.getCorrectAnswer()}">
            <input type="radio" value="${Session.QuestionsVO.getIncorrectAnswer1()}">
            <input type="radio" value="${Session.QuestionsVO.getIncorrectAnswer2()}">
            <input type="radio" value="${Session.QuestionsVO.getIncorrectAnswer3()}">
        </p>
</form>
>>>>>>> parent of c430198... added names to radiobuttons for better user control
</body>
</html>