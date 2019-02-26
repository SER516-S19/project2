(function() {
   /*= [{
    question: "What is 2*5?",
    choices: [2, 5, 10, 15, 20],
    correctAnswer: 2
  }, {
    question: "What is 3*6?",
    choices: [3, 6, 9, 12, 18],
    correctAnswer: 4
  }, {
    question: "What is 8*9?",
    choices: [72, 99, 108, 134, 156],
    correctAnswer: 0
  }, {
    question: "What is 1*7?",
    choices: [4, 5, 6, 7, 8],
    correctAnswer: 3
  }, {
    question: "What is 8*8?",
    choices: [20, 30, 40, 50, 64],
    correctAnswer: 4
  }]; */
  
   $.ajax({
		url : 'StudentQuestionsAndOptions',
		type: 'GET',
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
	    if (isNaN(selections[questionCounter])) {
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
	    
	    var radioButtons = createRadios(index);
	    qElement.append(radioButtons);
	    
	    return qElement;




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
	    selections[questionCounter] = +$('input[name="answer"]:checked').val();
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
	        
	        // 'prev' button display control
	        if(questionCounter === 1){
	          $('#prev').show();
	        } else if(questionCounter === 0){
	          
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
	  
	  $("#submitQuiz").on('click',function(){
		 //Do the calling AJAX part here. 
		  var answers = convertToJSON(selections);
		  $.ajax({
				url : 'StudentQuestionsAndOptions',
				type: 'POST',
				dataType: "json",
				data: answers,
				success : function(responseText) {
					console.log("Successfully posted to database!");
				},error: function(){
					//Handle Error scenario here.
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
