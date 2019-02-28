/**
 * @author - amanjotsingh
 * @version - 1.0
 * @since - 02/19/2019
 */

var questions = [];
var studentResponseObj = [];
var selections = [];
var questionCounter = 0;
var quiz = $('#quiz');

// Displays all questions with answers
function displayQuiz(jsonResponse) {
	studentResponseObj = jsonResponse;
	selections = [];
	questionCounter = 0;
	quiz = $('#quiz');

	for (var i = 0; i < studentResponseObj.question.length; i++) {
		choiceList = [];
		studentResponseObj.question[i].availableAnswers.forEach(function(Element) {
			choiceList.push(Element.answer)
		});
		questions[i] = {
			question : studentResponseObj.question[i].question,
			choices : choiceList,
			points : studentResponseObj.question[i].points
		};
	}

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
		autoSave();
		
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
		
		autoSave();
		if (quiz.is(':animated')) {
			return false;
		}
		choose();
		autoSave();
		
		questionCounter--;
		displayNext();
	});
	
	$('#submitBtn').on("click", function(){
		$(".popup, .popup-content").addClass("active");
		});

	$('.close, .popup').on("click", function(){
		$(".popup, .popup-content").removeClass("active");
	});
	
	// Animates buttons on hover
	$('.button').on('mouseenter', function() {
		$(this).addClass('active');
	});
	$('.button').on('mouseleave', function() {
		$(this).removeClass('active');
	});
}

// Creates and returns the div that contains the questions and
// the answer selections
function createQuestionElement(index) {
	var qElement = $('<div>', {
		id : 'question'
	});

	var header = $('<h2>Question ' + (index + 1)
			+ ': <span float:"right"> '+questions[index].points+' Points </span></h2>');
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
			$('#next').hide();
			$('#prev').show();
			$('#submitBtn').show();
		}
	});
}

function autoSave() {
	updateResponseJSON(studentResponseObj, selections);
}