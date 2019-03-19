/**
 * Author: Sumanth Paranjape
 */

var url_string = window.location.href;
var url = new URL(url_string);
var quizName = url.searchParams.get("quiz");

$(document).ready(function() {
	$("#finalMarksDiv").hide();
	$("#generateResult").on('click', function(){
		  var greeting = "Your score is ";
		  $("#finalMarksDiv").show();
		  document.getElementById("finalMarks").innerHTML = "Loading Results...";
		  
		  $.ajax({
				url : 'StudentGrades',
				type: 'GET',
				data: {
					quiz_title: quizName,
					student_id: 1
				},
				success : function(responseText) {
					console.log("Response text="+responseText);
					var result = responseText.split("|");
					document.getElementById("finalMarks").innerHTML = greeting + result[0];
					document.getElementById("finalPoints").innerHTML = result[1];
				},error: function(){
					//Handle Error scenario here.
					console.log("Error occured while fetching data!")
				}
			}); 
		});
});
