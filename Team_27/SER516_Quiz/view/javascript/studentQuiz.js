var url_string = window.location.href;
var url = new URL(url_string);
var quizName = url.searchParams.get("quiz");

$(document).ready(function() {
   $.ajax({
		url : 'StudentQuestionsAndOptions',
		type: 'GET',
		data: {
			quiz_title: quizName
		},
		success : function(responseText) {
			console.log("Response text="+responseText);
			var response = $.parseJSON(responseText);
			renderQuestions(response);
		},error: function(){
			//Handle Error scenario here.
			console.log("Error occured while fetching data!")
		}
	}); 
})();


function renderQuestions(resp){
	  var questions = resp;
	  var questionCounter = 0; //for Tracking question count
	  var selections = []; //Array to store user choices
	  var quiz = $('#quiz'); //div object for quiz
	  
	  
	  //For Displaying first question
	  displayNext();
	  
	  // handler for the 'next' button
	  $('#next').on('click', function (e) {
	    e.preventDefault();
	    
	    // Suspending the listener for click during fade 
	    if(quiz.is(':animated')) {        
	      return false;
	    }
	    
	    choose();

	    // Progress is stopped if the user does not select anything
	    if (undefined === selections[questionCounter]) {
	      alert('Please make a selection!');
	    } else {
	      questionCounter++;
	      displayNext();
	    }
	    

	  });
	  
	  // Handler for the 'prev' button click
	  $('#prev').on('click', function (e) {
	    e.preventDefault();
	    
	    if(quiz.is(':animated')) {
	      return false;
	    }
	    choose();
	    questionCounter--;
	    displayNext();
	  });
	  
	  // Handler for the 'Submit' button click
	  $('#start').on('click', function (e) {
	    e.preventDefault();
	    
	    if(quiz.is(':animated')) {
	      return false;
	    }
	    questionCounter = 0;
	    selections = [];
	    displayNext();
	    $('#start').hide();
	  });
	  
	  // Animating the buttons while hovering
	  $('.button').on('mouseenter', function () {
	    $(this).addClass('active');
	  });
	  $('.button').on('mouseleave', function () {
	    $(this).removeClass('active');
	  });
	  
	  // The div that contains the questions and selected answers
	  // is created and returned
	  function createQuestionElement(index) {
	    var qElement = $('<div>', {
	      id: 'question'
	    });
	    
	    

	    var header = $('<table><tr><th><div align="left">Question ' + (index + 1) + ':</th></tr><br>');
	    qElement.append(header);
	    
	    var question = $('<tr><br>').append(questions[index].question);
	    qElement.append(question);
	
	    if(questions[index].isMultipleAnswer){
	        var checkBox = createCheck(index);
	        qElement.append(checkBox);
	    }
	    else{
	        var radioButtons = createRadios(index);
	        qElement.append(radioButtons);
	    }
    return qElement;
    }

      // Creating a list of the Check Boxes for answer choices
    function createCheck(index) {
    var radioList = $('<ul>');
    var item;
    var input = '';
    for (var i = 0; i < questions[index].choices.length; i++) {
      item = $('<li>');
      input = '<input type="checkbox" id="answer'+questionCounter+i+'"value=' + i + ' />';
      input += questions[index].choices[i];
      item.append(input);
      radioList.append(item);
    }
    return radioList;
    }
  
  // Creating a list of the radio buttons for answer choices
  function createRadios(index) {
    var radioList = $('<ul>');
    var item;
    var input = '';
    for (var i = 0; i < questions[index].choices.length; i++) {
      item = $('<li>');
      input = '<input type="radio" name="answer" value=' + i + ' />';
      input += questions[index].choices[i];
      item.append(input);
      radioList.append(item);
    }
    return radioList;
  }
  
  // Pushes the value read from the user into an array
  function choose() {
	if(questions[questionCounter].isMultipleAnswer){
		selections[questionCounter] = undefined;
		for(var i=0;i<4;i++){
			if($('#answer'+questionCounter+i).prop("checked")){
				if(undefined === selections[questionCounter])
					selections[questionCounter] = "";
				selections[questionCounter] += i + "|"; 
			}
		}
		if(undefined != selections[questionCounter])
			selections[questionCounter] = selections[questionCounter].substring(0,selections[questionCounter].length-1);
	}else{
	    selections[questionCounter] = +($('input[name="answer"]:checked').val() === undefined) ? undefined : $('input[name="answer"]:checked').val();
	}
  }
  
  // Requested next element is displayed
  function displayNext() {
    quiz.fadeOut(function() {
    	
      
    	
      $('#question').remove();
      
      if(questionCounter < questions.length){
        var nextQuestion = createQuestionElement(questionCounter);
        quiz.append(nextQuestion).fadeIn();
        if (!(isNaN(selections[questionCounter]))) {
          $('input[value='+selections[questionCounter]+']').prop('checked', true);
        }
        
        if(questionCounter == questions.length-1){
        	  $('#next').hide();
        	  $('#submitQuiz').attr('disabled',false);
        	  if(questions.length === 1){
                  $('#prev').hide();
        	  }
        }else{
            $('#next').show();
        }
        // 'prev' button display control
        if(questionCounter === 1){
          $('#prev').show();
        } else if(questionCounter === 0 && questions.length>1){
          
          $('#prev').hide();
          $('#next').show();
        }
      }else {
        var scoreElem = displayScore();
        quiz.append(scoreElem).fadeIn();
        $('#next').hide();
        $('#prev').hide();
        $('#start').show();
      }
    });
  }
  
  // Computes score and returns it for display
 
  function displayScore() {
    var score = $('<p>',{id: 'question'});
    
    var numCorrect = 0;
    for (var i = 0; i < selections.length; i++) {
      if (selections[i] === questions[i].correctAnswer) {
        numCorrect++;
      }
    }
    
    score.append('You got ' + numCorrect + ' questions out of ' +
                 questions.length + ' right!!!');
    return score;
  }
  
  var modal = document.getElementById('myModal');
  var btn = document.getElementById("submitQuiz");
  var span = document.getElementsByClassName("close")[0];

  $("#submitQuiz").on('click',function(){	  
	  //Choose the last answer.
	  choose();
	  var answers = convertToJSON(selections);

	  
	  if (undefined === selections[questionCounter]) {
	      alert('Please make a selection to submit!');
	      return;
	  } 
			  
	  $.ajax({
		  url : 'StudentQuestionsAndOptions',
		  type : 'POST',
		  dataType : 'JSON',
		  data: { 
			  answers: JSON.stringify(answers),
			  quiz_title: quizName
		  },
		  success : function(responseText) {
					console.log("Successfully posted to database!");
					window.location.href = "ViewGrades.html?quiz="+quizName;
		  },error: function(){
			  //Handle Error scenario here.
				window.location.href = "ViewGrades.html?quiz="+quizName;
			  console.log("Error occured while posting to database!")
		  	}
		}); 
	});
	  
  function convertToJSON(arr){
	var jsonObj = {};
	for (var i = 0 ; i < arr.length; i++) {
		jsonObj["" + (i+1)] = arr[i];
	}  
	return jsonObj;
  }

}
