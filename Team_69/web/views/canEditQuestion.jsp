<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script type=âtext/javascriptâ
	src=âbootstrap/js/bootstrap.min.jsâ></script>

<style>
.borderexample {
	width: auto;
	padding: 25px;
	margin: 25px;
}
</style>
<title>Edit Question</title>
</head>
<body>	
	<script type="text/javascript">
	function valthis() {
		var questionOptions1 = document.getElementById('option1').value;
		var questionOptions2 = document.getElementById('option2').value;
		var questionOptions3 = document.getElementById('option3').value;
		var questionOptions4 = document.getElementById('option4').value;
		var checkBoxes = document.getElementsByName('options');
		var count = 0;
		
		if(questionOptions1){
			count = count + 1;
		}	
		else {
			alert('Inside first else');
			if(checkBoxes[0].checked){
				alert('Sorry you have checked a empty option!');
				return false;
			}
		}
			
		if(questionOptions2)
			count = count + 1;
		else {
			if(checkBoxes[1].checked){
				alert('Sorry you have checked a empty option!');
				return false;
			}
		}
		
		if(questionOptions3)
			count = count + 1;
		else{
			if(checkBoxes[2].checked){
				alert('Sorry you have checked a empty option!')
				return false;
			}
		}	
		
		if(questionOptions4)
			count = count + 1;
		else{
			if(checkBoxes[3].checked){
				alert('Sorry you have checked a empty option!')
				return false;
			}
		}
			
		if(count < 2){
			alert('Please, enter at least 2 options!');
			return false;
		}
		
		var isChecked = false;
		    for (var i = 0; i < checkBoxes.length; i++) {
		        if ( checkBoxes[i].checked ) {
		        	isChecked = true;
		        };
		    };
		    if ( !isChecked ){
		            alert( 'Please, check at least one checkbox!' );
		            return false;
		        }   
		
		return true;	
	}
</script>
	
	<div align="center">
		<H2>Please Edit the question</H2>
	</div>
	<c:set var="quesId" value="${requestScope.quesId}" />
	<c:forEach items="${requestScope.queAnsData}" var="questionAnsList">
		<c:choose>
			<c:when test="${questionAnsList[2][0].question.questionId eq quesId}">
				<form action="../Team_69/ProfessorController" method="post">
					
					<div class="borderexample" class="form-group">
						<label for="question">Question:</label>
						<textarea name="question" id="question" rows="6" cols="50"
							class="form-control">${questionAnsList[2][0].question.question}</textarea>
						<br>
						<c:forEach items="${questionAnsList[2]}" var="answer"
							varStatus="theCount">
							<label for="option${theCount.count}">Option
								${theCount.count}: </label>
							<br>
							<c:choose>
								<c:when test="${answer.correctAnswer eq 'true'}">
								
									<input type="checkbox" name="options" value="option${theCount.count}" checked>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="options" value="option${theCount.count}">
								</c:otherwise>
							</c:choose>
							<textarea name="option${theCount.count}" id="option${theCount.count}" rows="2" cols="50"
								class="form-control">${answer.answer}</textarea>
							<br>
						</c:forEach>

						Enter points : <input type="number" name="points"
							value="${questionAnsList[2][0].question.points}"> <br>
						<br>
						<input type="hidden" name="flag" value="saveEdited" />
						<input type="hidden" name="questionId" value="${requestScope.quesId}" />
							<button type="submit" onclick="javascript:valthis()"
								class="btn btn-primary">Save and Exit</button>
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<!--  keep this blank -->
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>