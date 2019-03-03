<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<meta charset="ISO-8859-1">
=======
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
=======
>>>>>>> Team_58

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
<<<<<<< HEAD
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

</style>
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
  padding: 25px;
  margin: 25px;

}

</style>
>>>>>>> Team_58
<title>Add Questions</title>
</head>
<body>

<<<<<<< HEAD
<<<<<<< HEAD
=======
<body>
	<script type="text/javascript">
	function valthis() {
		var checkBoxes = document.getElementsByName('options');
		var isChecked = false;

		console.log("I am here checking for check boxes");
		    for (var i = 0; i < checkBoxes.length; i++) {
		        if ( checkBoxes[i].checked ) {
		        	console.log("I am here Again inside");
		        	isChecked = true;
		        };
		    };
		    if ( !isChecked ){
		            alert( 'Please, check at least one checkbox!' );
		        }   
		}
</script>

<div align="center" >
	<H2>Please add the question</H2>
</div>


>>>>>>> Team_58
<form method="Post" action="../ProfessorController">
	<div class="borderexample" class="form-group">   
			
		<label for="question" >Question:</label>
		<textarea name="question" id="question" rows="6" cols="50"  class="form-control"  required></textarea>	
		<br>
		
		
		<label for="option1">Option 1: </label>
		<br>
    	<input type="checkbox" name="options" value="option1">
    	<textarea type="text" name="option1" rows="2" cols="50" class="form-control"  required></textarea>
		<br>


    	<label for="option2">Option 2: </label>
    	<br>
		<input type="checkbox" name="options" value="option2">	
    	<textarea type="text" name="option2" rows="2" cols="50" class="form-control"  required></textarea>
    	<br>
    
    	
    	<label for="option3">Option 3: </label>
    	<br>
    	<input type="checkbox" name="options" value="option3">
    	<textarea type="text" name="option3" rows="2" cols="50" class="form-control" ></textarea>
    	<br>
    
    	<label for="option4">Option 4: </label>
		<br>
    	<input type="checkbox" name="options" value="option4">
    	<textarea type="text" name="option4" rows="2" cols="50" class="form-control" ></textarea>
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
					<input type="hidden" name="flag" value="Add Next Question"  />
					<button type="submit" class="btn btn-primary" 
						onclick="javascript:valthis()">Add Next Question</button>
				</td>
				<td>		
					<input type="hidden" name="flag" value="Save and Exit"   />
					<button type="submit"
						onclick="javascript:valthis()" class="btn btn-primary">Save and Exit</button>
				</td>
				<td>
					<%String pathWebcontent=request.getContextPath();%>
					<a href="<%=pathWebcontent %>/ProfessorController?flag=viewQuiz&id=${quiz.quizId}&quizName=${quiz.quizName}" class="button btn btn-primary" >View Questions</a>
				</td>	
			</tr>
		</table>
	</div>	
	
	<br>
	<br>
	<br>
		
</form>
<<<<<<< HEAD
=======
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

<div align="center" >
	<H3>Please add the question</H3>
</div>

<div class="container">
<form method="Post" action="../ProfessorController">
	<div class="borderexample" class="form-group">   
			
		<label for="question" >Question:</label>
		<textarea name="question" id="question" rows="3" cols="50"  class="form-control"  required></textarea>	
		<br>
		
		
		<label for="option1">Option 1: </label>
    	<input type="checkbox" name="options" value="option1">
    	<textarea type="text" id="questionOptions1" name="questionOptions1" rows="1" cols="50" class="form-control" ></textarea>
		<br>


    	<label for="option2">Option 2: </label>
		<input type="checkbox" name="options" value="option2">	
    	<textarea type="text" id="questionOptions2" name="questionOptions2" rows="1" cols="50" class="form-control" ></textarea>
    	<br>
    
    	
    	<label for="option3">Option 3: </label>
    	<input type="checkbox" name="options" value="option3">
    	<textarea type="text" id="questionOptions3" name="questionOptions3" rows="1" cols="50" class="form-control" ></textarea>
    	<br>
    
    	<label for="option4">Option 4: </label>
    	<input type="checkbox" name="options" value="option4">
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

>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======

>>>>>>> Team_58
</body>
</html>