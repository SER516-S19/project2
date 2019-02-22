/**
 * @author - amanjotsingh
 * @version - 1.0
 * @since - 02/19/2019
 */

// Displays all questions with answers
function displayQuiz() {
	var questions = [{"questionId":3,"quiz":{"quizId":1,"quizName":"Quiz1","quizInstructions":"Read","quizType":"Graded","quizTimeLimit":"12:30:00 AM","isShuffled":true,"isPublished":false},"question":"Question3","correctAnswerId":0,"isMultiple":true,"points":10},{"questionId":4,"quiz":{"quizId":1,"quizName":"Quiz1","quizInstructions":"Read","quizType":"Graded","quizTimeLimit":"12:30:00 AM","isShuffled":true,"isPublished":false},"question":"Question4","correctAnswerId":0,"isMultiple":true,"points":10}];
	var questionCounter = 0; // Tracks question number
	var selections = []; // Array containing user choices
	var quiz = $('#quiz'); // Quiz div object

	// Display initial question
	displayNext();

	// Click handler for the 'next' button
	$('#next').on('click', function(e) {
		e.preventDefault();

		// Suspend click listener during fade animation
		if (quiz.is(':animated')) {
			return false;
		}
		choose();

		// If no user selection, progress is stopped
		if (isNaN(selections[questionCounter])) {
			alert('Please make a selection!');
		} else {
			questionCounter++;
			displayNext();
		}
	});

	// Click handler for the 'prev' button
	$('#prev').on('click', function(e) {
		e.preventDefault();

		if (quiz.is(':animated')) {
			return false;
		}
		choose();
		questionCounter--;
		displayNext();
	});

	// Click handler for the 'Start Over' button
	$('#start').on('click', function(e) {
		e.preventDefault();

		if (quiz.is(':animated')) {
			return false;
		}
		questionCounter = 0;
		selections = [];
		displayNext();
		$('#start').hide();
	});

	// Animates buttons on hover
	$('.button').on('mouseenter', function() {
		$(this).addClass('active');
	});
	$('.button').on('mouseleave', function() {
		$(this).removeClass('active');
	});

	// Creates and returns the div that contains the questions and
	// the answer selections
	function createQuestionElement(index) {
		var qElement = $('<div>', {
			id : 'question'
		});

		var header = $('<h2>Question ' + (index + 1)
				+ ': <span float:"right"> Points </span></h2>');
		qElement.append(header);

		var question = $('<p>').append(questions[index].question);
		qElement.append(question);

		var radioButtons = createRadios(index);
		qElement.append(radioButtons);

		return qElement;
	}

	// Creates a list of the answer choices as radio inputs
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

	// Reads the user selection and pushes the value to an array
	function choose() {
		selections[questionCounter] = +$('input[name="answer"]:checked').val();
	}
	
	function autoSave() {
		console.log("Saved!");

		var questionContainers = $(".question");
		for (var i = 0; i < questionContainers.length; i++) {
			var questionID = questionContainers[i].id;
			var ansElems = questionContainers[i]
					.getElementsByTagName("input");
			for (var j = 0; j < ansElems.length; j++) {
				if (ansElems[j].checked) {
					console.log(questionID + ": " + ansElems[j].value);
					//Save in session or temp Table?
				}
			}
		}
	}

	// Displays next requested element
	function displayNext() {
		quiz.fadeOut(function() {
			$('#question').remove();

			if (questionCounter < questions.length) {
				var nextQuestion = createQuestionElement(questionCounter);
				quiz.append(nextQuestion).fadeIn();
				if (!(isNaN(selections[questionCounter]))) {
					$('input[value=' + selections[questionCounter] + ']').prop(
							'checked', true);
				}

				// Controls display of 'prev' button
				if (questionCounter === 1) {
					$('#prev').show();
				} else if (questionCounter === 0) {

					$('#prev').hide();
					$('#next').show();
				}
			} else {
				var scoreElem = displayScore();
				quiz.append(scoreElem).fadeIn();
				$('#next').hide();
				$('#prev').hide();
				$('#start').show();
			}
		});
	}
	
	function autoSave() {
		console.log("Saved!");

		var questionContainers = $(".question");
		for (var i = 0; i < questionContainers.length; i++) {
			var questionID = questionContainers[i].id;
			var ansElems = questionContainers[i]
					.getElementsByTagName("input");
			for (var j = 0; j < ansElems.length; j++) {
				if (ansElems[j].checked) {
					console.log(questionID + ": " + ansElems[j].value);
					//Save in session or temp Table?
				}
			}
		}
	}
	
	function submitQuiz() {
		autoSave();
		//Send session data to controller
	}
}