var url_string = window.location.href;
var url = new URL(url_string);
var quiz = url.searchParams.get("quiz");
var numberOfQuestions;
var timeLimit;

$(document).ready(function(){
	$.ajax({
		url : 'StudentQuestionsAndOptions',
		type: 'GET',
		data: {
			quiz_title: quiz
		},
		success : function(responseText) {
			console.log("Response text="+responseText);
			numberOfQuestions = $.parseJSON(responseText).length;
			getTimeLimit();
		},error: function(){
			//Handle Error scenario here.
			console.log("Error occured while fetching data!")
		}
	});
	
	function getTimeLimit(){
		$.ajax({
			url : 'QuizTimeLimit',
			type: 'GET',
			data: {
				quiz_title: quiz
			},
			success : function(minutes) {
				console.log("Response text="+minutes);
				timeLimit = minutes;
				document.getElementById("quizInstruction1").innerHTML = "This quiz contains "+numberOfQuestions+" Questions";
				document.getElementById("quizInstruction2").innerHTML = "You have "+timeLimit+" minutes to complete it";
				document.getElementById("quizName").innerHTML = quiz;
			},error: function(){
				console.log("Error occured while fetching data!")
			}
		});
	}
	  
	$('#startQuiz').on('click', function(){
		window.location.href = "StudentQuiz.html?quiz="+quiz;
	});
});
