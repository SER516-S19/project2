var seconds;
$(document).ready(function() {
	 $.ajax({
			url : 'QuizTimeLimit',
			type: 'GET',
			data: {
				quiz_title: quizName
			},
			success : function(minutes) {
				console.log("Response text="+minutes);
				seconds = minutes*60;
				timer(seconds);
			},error: function(){
				console.log("Error occured while fetching data!")
			}
		}); 
});

function timer() {
  var requiredDays        = Math.floor(seconds/24/60/60);
  var LEFTHOURS   = Math.floor((seconds) - (requiredDays*86400));
  var requiredHOURS       = Math.floor(LEFTHOURS/3600);
  var LEFTMINUTES = Math.floor((LEFTHOURS) - (requiredHOURS*3600));
  var requiredMinutes     = Math.floor(LEFTMINUTES/60);
  var secondsRemaning = seconds % 60;
  
  function timeCal(n) {
    return (n < 10 ? "0" + n : n);
  }
  document.getElementById('countdown').innerHTML =  timeCal(requiredHOURS) + ":" + timeCal(requiredMinutes) + ":" + timeCal(secondsRemaning);
  if (seconds == 0) {
    clearInterval(Countdown);
    document.getElementById('countdown').innerHTML = "done";
  } else {
	  seconds = seconds-1;
  }
}
var Countdown = setInterval('timer()', 1000);
