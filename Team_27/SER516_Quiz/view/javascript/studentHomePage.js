var selectedQuiz;

$(document).ready(function() {
		
	$.ajax({
			url : 'StudentQuiz',
			type: 'GET',
			success : function(responseText) {
				console.log("Response text="+responseText);
				var quizArray = responseText.split(" ");
				var i=0, options = "<option value=0>Select-Quiz</option>";
				for(;i<quizArray.length;i++){
					options += "<option value ="+quizArray[i]+">"+quizArray[i]+"</option>";
				}
				document.getElementById("QuizList").innerHTML = options;
			},error: function(){
				console.log("Error occured while fetching data!")
			}
		});
	
	$('#takeQuiz').on('click',function(){
		selectedQuiz = $("#QuizList").val();
		window.location.href = "QuizInstructions.html?quiz="+selectedQuiz;
	}); 
	
});

/*function getQuizData(){
	$.ajax({
		url : 'StudentQuiz',
		type: 'GET',
		success : function(responseText) {
			console.log("Response text="+responseText);
			var quizArray = responseText.split(" ");
			var i=0, options = "<option value=0>Select-Quiz</option>";
			for(;i<quizArray.length;i++){
				options += "<option value ="+quizArray[i]+">"+quizArray[i]+"</option>";
			}
			document.getElementById("QuizList").innerHTML = options;
		},error: function(){
			console.log("Error occured while fetching data!")
		}
	});
} */
