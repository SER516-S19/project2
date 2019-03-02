<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  padding: 25px;
  margin: 25px;

}

</style>
<title>Add Questions</title>
</head>
<body>

<body>
	<script type="text/javascript">
	function valthis() {
		var checkBoxes = document.getElementsByName('options');
		var questionOptions = document.getElementsByName('questionOptions');
		var isChecked = false;
		
		if(questionOptions.length > 1){
			for (var i = 0; i < checkBoxes.length; i++) {
			      if ( checkBoxes[i].checked ) {
			      	if(questionOptions[i] =! null){	
			    	  isChecked = true;
			      	}else if (questionOptions[i] == null){
			      		alert( 'Sorry! you have checked an empty option.' );
			      		isChecked = true;
			      	}
			      };
			};
			    if ( !isChecked ){
			            alert( 'Please, check at least one checkbox!' );
			        }   
			}
		}else{
			alert( 'Please, enter atleast 2 options' );
		}
		
		
</script>

<div align="center" >
	<H2>Please add the question</H2>
</div>


<form method="Post" action="../ProfessorController">
	<div class="borderexample" class="form-group">   
			
		<label for="question" >Question:</label>
		<textarea name="question" id="question" rows="6" cols="50"  class="form-control"  required></textarea>	
		<br>
		
		
		<label for="option1">Option 1: </label>
		<br>
    	<input type="checkbox" name="options" value="option1">
    	<textarea type="text" name="questionOptions" rows="2" cols="50" class="form-control"  required></textarea>
		<br>


    	<label for="option2">Option 2: </label>
    	<br>
		<input type="checkbox" name="options" value="option2">	
    	<textarea type="text" name="questionOptions" rows="2" cols="50" class="form-control"  required></textarea>
    	<br>
    
    	
    	<label for="option3">Option 3: </label>
    	<br>
    	<input type="checkbox" name="options" value="option3">
    	<textarea type="text" name="questionOptions" rows="2" cols="50" class="form-control" ></textarea>
    	<br>
    
    	<label for="option4">Option 4: </label>
		<br>
    	<input type="checkbox" name="options" value="option4">
    	<textarea type="text" name="questionOptions" rows="2" cols="50" class="form-control" ></textarea>
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
						onclick="javascript:valthis()">Add Next Question</button>
				</td>
				<td>		
					<button type="submit"
						onclick="javascript:valthis()" name="flag" value="saveAndExit"   class="btn btn-primary">Save and Exit</button>
				</td>
				<td>
					<%String pathWebcontent=request.getContextPath();%>
					<a href="<%=pathWebcontent %>/ProfessorController?flag=viewQuestion&id=${quiz.quizId}&quizName=${quiz.quizName}" class="button btn btn-primary" >View Questions</a>
				</td>	
			</tr>
		</table>
	</div>	
	
	<br>
	<br>
	<br>
		
</form>

</body>
</html>