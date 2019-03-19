<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>

<style>
.borderexample
{
  width: auto;
  padding: 20px;
  margin: 20px;

}

.container {
	min-height: 200px;
	margin-top: 20px;
	background-color: rgb(240, 241, 243);
}

#container {
	width: 45%;
	margin: auto;
	padding: 0 40px 40px 10px;
	border: 4px solid #B0E0E6;
	border-radius: 5px;
	color: #0;
	font-weight: bold;
	box-shadow: 5px 5px 5px #888;
}

form {
	text-align: left;
}

.rightSide { 
float:right;
 }

</style>
<title>Add Questions</title>
</head>
<body>

<body>
<script type="text/javascript">
	function valthis() {
		var questionOptions1 = document.getElementById('questionOptions1').value;
		var questionOptions2 = document.getElementById('questionOptions2').value;
		var questionOptions3 = document.getElementById('questionOptions3').value;
		var questionOptions4 = document.getElementById('questionOptions4').value;
		var checkBoxes = document.getElementsByName('options');
		var count = 0;
		
		if(questionOptions1)
			count = count + 1;
		else{
			if(checkBoxes[0].checked){
				alert('Sorry you have checked a empty option!');
				return false;
			}
		}
			
		if(questionOptions2)
			count = count + 1;
		else{
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
			
		if(count < 4){
			alert('All the options are mandatory, Please enter all four!');
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

<div align="center" >
	<H3>Please add the question</H3>
</div>

<form action="../ProfessorController" method="get">
		<input type="hidden" id="flag" name="flag" value="fetchQuizList">
		<input type="submit" value="Display Quiz List"
		class="btn btn-primary" />
</form>
<br>

<div class="container">
<form method="Post" action="../ProfessorController">
	<div class="borderexample" class="form-group">   
			
		<label for="question" >Question:</label>
		<textarea name="question" id="question" rows="3" cols="50"  class="form-control"  required></textarea>	
		<br>
		
		
		<label for="option1">Option 1: </label>
    	<input type="checkbox" name="options" value="option1">
    	<span class="rightSide">Please select the checkbox if Option 1 is a right answer</span>
    	<textarea type="text" id="questionOptions1" name="questionOptions1" rows="1" cols="50" class="form-control" ></textarea>
		<br>


    	<label for="option2">Option 2: </label>
		<input type="checkbox" name="options" value="option2">	
		<span class="rightSide">Please select the checkbox if Option 2 is a right answer</span>
    	<textarea type="text" id="questionOptions2" name="questionOptions2" rows="1" cols="50" class="form-control" ></textarea>
    	<br>
    
    	
    	<label for="option3">Option 3: </label>
    	<input type="checkbox" name="options" value="option3">
    	<span class="rightSide">Please select the checkbox if Option 3 is a right answer</span>
    	<textarea type="text" id="questionOptions3" name="questionOptions3" rows="1" cols="50" class="form-control" ></textarea>
    	<br>
    
    	<label for="option4">Option 4: </label>
    	<input type="checkbox" name="options" value="option4">
    	<span class="rightSide">Please select the checkbox if Option 4 is a right answer</span>
    	<textarea type="text" id="questionOptions4" name="questionOptions4" rows="1" cols="50" class="form-control" ></textarea>
		<br>
		<br>
		
		Enter points : 
		<input type="number" name="points" >
		<br>
		<br>

	<div align="center">	
		<table>
			<tr>
				<td>
					<button type="submit" name="flag" value="addNextQuestion" class="btn btn-primary" 
						onclick="javascript:return valthis()">Add Next Question</button>
				</td>
				<td>		
					<button type="submit"
						 onclick="javascript:return valthis()" name="flag" value="saveAndExit"   class="btn btn-primary">Save and Exit</button>
				</td>
			</tr>
		</table>
	</div>	
	
</form>
</div>

</body>
</html>