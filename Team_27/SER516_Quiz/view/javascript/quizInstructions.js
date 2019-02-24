$(document).ready(function(){
	$('#startQuiz').on('click', function(){
		var url_string = window.location.href;
		var url = new URL(url_string);
		var quiz = url.searchParams.get("quiz");
		window.location.href = "StudentQuiz.html?quiz="+quiz;
	});
});