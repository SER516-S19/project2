/**
 * Author: Sumanth Paranjape
 */

var url_string = window.location.href;
var url = new URL(url_string);
var quizName = url.searchParams.get("quiz");

$(document).ready(function() {
	$("#finalMarksDiv").hide();
	$("#generateResult").on('click', function(){
		  var score = 10; //it should be the json result generated from the Quiz 
		  var greeting = "Your score is ";
		  $.ajax({
				url : 'StudentGrades',
				type: 'GET',
				data: {
					quiz_title: quizName,
					student_id: 1
				},
				success : function(responseText) {
					console.log("Response text="+responseText);
					$("#finalMarksDiv").show();
					document.getElementById("finalMarks").innerHTML = greeting + responseText;
					/*var response = $.parseJSON(responseText);
					renderQuestions(response); */
				},error: function(){
					//Handle Error scenario here.
					console.log("Error occured while fetching data!")
				}
			}); 
		});
});
