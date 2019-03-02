/** 
  * Author(s): Meng-Ze Chen, Jiayan Wang, Suraj Atmakuri
  * Date: 2019/2/20
  * Description: Page for creating quizzes
  */

var snapshotList = []
function addFields(thisElem, idTracingList) {
	var snapshotDict = {}
	snapshot(snapshotList, snapshotDict)

	var divID = thisElem.parentNode;
	divID.innerHTML = divID.innerHTML + "<br>"
	divID.innerHTML = divID.innerHTML + "question:<br>"
	questionChoiceIterator += 1;
	var questionID = `question-${questionChoiceIterator}`
	divID.innerHTML = divID.innerHTML + `<input type='text' name = 'question' id='${questionID}' value='enter the question' size='30'>`
	divID.innerHTML = divID.innerHTML + "<br> Select the check boxes for correct answers <br>"
	idTracingList.push(questionID)
	addAnswerFields(divID, idTracingList);

	reverseToSnapshot(snapshotList, snapshotDict)
}

function addAnswerFields(divID, idTracingList) {
	addQuestionTypeFields(divID)
	var possibleChoices = ['a', 'b', 'c', 'd', 'e'];
	for (var idx = 0; idx < possibleChoices.length; idx += 1) {
		var checkboxID = `checkbox-${possibleChoices[idx]}-${questionChoiceIterator}`
		var choiceDescID = `choicedesc-${possibleChoices[idx]}-${questionChoiceIterator}`

		divID.innerHTML = divID.innerHTML + `<input type='radio' id='${checkboxID}' name='checkbox-${questionChoiceIterator}' value='${possibleChoices[idx]}'>`
		divID.innerHTML = divID.innerHTML + `${possibleChoices[idx]}.`
		divID.innerHTML = divID.innerHTML + `<input type='text' id='${choiceDescID}' name='choiceDesc-${questionChoiceIterator}' value='enter the answer' size=30><br>`

		idTracingList.push(checkboxID)
		snapshotList.push(checkboxID)
		idTracingList.push(choiceDescID)
	}
	var creditBoxID = `pointBox-${questionChoiceIterator}`
	divID.innerHTML = divID.innerHTML + `credits:<input type='text' id='${creditBoxID}' name='points-${questionChoiceIterator}' value='0.0' size=2>`
	idTracingList.push(creditBoxID)
	divID.innerHTML = divID.innerHTML + "<br><br>"
}

function addQuestionTypeFields(divID) {
	var multichoiceStr = `multichoice-${questionChoiceIterator}`
	var multianswerStr = `multianswer-${questionChoiceIterator}`
	divID.innerHTML = divID.innerHTML + `Select question type: <br>`
	divID.innerHTML = divID.innerHTML + `<input type='radio' id='${multichoiceStr}' onclick="selectQuestionType('${multichoiceStr}')" name='answerType-${questionChoiceIterator}' checked=true value='singleAnswer'> Single Answer Question<br>`
	divID.innerHTML = divID.innerHTML + `<input type='radio' id='${multianswerStr}' onclick="selectQuestionType('${multianswerStr}')" name='answerType-${questionChoiceIterator}' value='multiAnswer'> Multiple Answers Question<br>`
	idTracingList.push(multianswerStr)
	idTracingList.push(multichoiceStr)
	snapshotList.push(multichoiceStr)
	snapshotList.push(multianswerStr)
}

function selectQuestionType(answerTypeEncoded) {
	answerTypeList = answerTypeEncoded.split('-')

	questionID = answerTypeList[answerTypeList.length - 1]
	answerType = answerTypeList[0]
	var possibleChoices = ['a', 'b', 'c', 'd', 'e'];
	for (var i = 0; i < possibleChoices.length; i += 1) {
		var checkboxID = `checkbox-${possibleChoices[i]}-${questionID}`
		if (answerType == 'multichoice') {
			document.getElementById(checkboxID).type = 'radio'
		} else {
			document.getElementById(checkboxID).type = 'checkbox'
		}
	}
}

function submitQuizCreateRequest() {
	var quizDict = {}
	createQuizDict(idTracingList, quizDict)

	xmlHttpManager = new XMLHttpRequest();
	var url = "/createQuiz";
	xmlHttpManager.open("POST", url, true);
	xmlHttpManager.setRequestHeader("Content-type", "application/json");
	var data = JSON.stringify(quizDict);
	xmlHttpManager.send(data);
}

function createQuizDict(idTracingList, quizDict) {
	// var quizDict = {
	// 	"title": 'title',
	// 	"course_id": 0,
	// 	"instructions": 'instruction',
	// 	"shuffle": false,
	// 	"time_limit": 0, //second
	// 	"date_open": 'yyyy-mm-dd',
	// 	"date_close": 'yyyy-mm-dd',
	// 	"quiz_type": "quiz", // "quiz" or "survey",
	// 	"attempts": 0,
	// 	"quiz_group": 'quizGroup',
	// 	"total_points": 0.0,
	// 	"questions": []
	// }
	questionDict = {}
	createQuestionsDict(idTracingList, questionDict)
	quizDict['questions'] = []
	quizDict['title'] = document.getElementById('title_id').value
	quizDict['course_id'] = 0 // No such field
	quizDict['instruction'] = document.getElementById('instruction_id').value
	quizDict['shuffle'] = true// No such field

	var hrs = document.getElementById('hrs_id').value
	var min = document.getElementById('min_id').value
	var totalSeconds = 3600 * parseFloat(hrs) + 60 * parseFloat(min)
	quizDict['time_limit'] = totalSeconds // In second, Not calculated yet

	quizDict['date_open'] = document.getElementById('start_id').value
	quizDict['date_close'] = document.getElementById('end_id').value
	var quizTypSelect = document.getElementById('quizType_id').value
	if (quizTypSelect == 'g') {
		quizDict['quiz_type'] = 'quiz'
	} else {
		quizDict['quiz_type'] = 'survey'
	}

	quizDict['attempts'] = 0 // No recorded
	quizDict['quiz_group'] = document.getElementById('quizGroup_id').value
	var points = 0
	for (var key in questionDict) {
		quizDict['questions'].push(questionDict[key])
		points += questionDict[key]['points']
	}
	quizDict['total_points'] = points
	returnQuizDict = quizDict
}

function createQuestionsDict(idTracingList, questionDict) {
	var tmpDict = {}
	for (var keyIdx = 0; keyIdx < idTracingList.length; keyIdx += 1) {
		var keyword = idTracingList[keyIdx]
		var parseArray = keyword.split('-')
		var questionID = parseArray[parseArray.length - 1]
		var questionKeyword = `question-${questionID}`
		switch (parseArray[0]) {
			case 'question':
				var tmpQuestionDict = {}
				tmpQuestionDict['quesType'] = 'MA'
				tmpQuestionDict['points'] = 0.0
				tmpQuestionDict['content'] = 'placeholderStr'
				tmpQuestionDict['choices'] = []
				questionDict[keyword] = tmpQuestionDict
				break
			case 'checkbox':
				var thisCheckBox = document.getElementById(keyword)
				tmpDict[keyword] = thisCheckBox.checked
				if (thisCheckBox.type == 'radio') {
					questionDict[questionKeyword]['quesType'] = 'MC'
				} else {
					questionDict[questionKeyword]['quesType'] = 'MA'
				}
				break
			case 'choicedesc':
				var correspondingCheckKey = `checkbox-${parseArray[1]}-${questionID}`
				questionDict[questionKeyword]['choices'].push({
					'correct': tmpDict[correspondingCheckKey],
					'content': document.getElementById(keyword).value
				})
				break
			case 'pointBox':
				pointBox = document.getElementById(keyword)
				questionDict[questionKeyword]['points'] = parseFloat(pointBox.value)
				break
			default:
				var hi = 'hi'
		}
	}
}

function snapshot(snapshotList, targetDict) {
	for (var idx = 0; idx < snapshotList.length; idx += 1) {
		var keyword = snapshotList[idx]
		targetDict[keyword] = document.getElementById(keyword).checked
	}
}

function reverseToSnapshot(snapshotList, snapshotDict) {
	for (var idx = 0; idx < snapshotList.length; idx += 1) {
		var keyword = snapshotList[idx]
		var keywordSplit = keyword.split('-')[0]
		if (keywordSplit == 'multichoice' || keywordSplit == 'multianswer' || keywordSplit == 'checkbox') {
			document.getElementById(keyword).checked = snapshotDict[keyword]
		} else {
			if (keyword in snapshot) {
				document.getElementById(keyword).value = snapshotDict[keyword]
			}
		}
	}
}