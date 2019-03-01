/** 
  * Author(s): Meng-Ze Chen, Jiayan Wang, Suraj Atmakuri
  * Date: 2019/2/20
  * Description: Page for creating quizzes
  */

function addFields(thisElem, nameTracingList) {
    var divID = thisElem.parentNode;
    divID.innerHTML = divID.innerHTML + "<br>"
    divID.innerHTML = divID.innerHTML + "question:<br>"
    questionChoiceIterator += 1;
    var questionID = `question-${questionChoiceIterator}`
    divID.innerHTML = divID.innerHTML + `<input type='text' name = 'question' id='${questionID}' value='enter the question' size='30'>`
    divID.innerHTML = divID.innerHTML + "<br> Select the check boxes for correct answers <br>"
    nameTracingList.push(questionID)
    addAnswerFields(divID, nameTracingList);
}

function addAnswerFields(divID, nameTracingList) {
    addQuestionTypeFields(divID)
    var possibleChoices = ['a', 'b', 'c', 'd', 'e'];
    for (var idx = 0; idx < possibleChoices.length; idx += 1) {
        var checkboxID = `checkbox-${possibleChoices[idx]}-${questionChoiceIterator}`
        var choiceDescID = `choice-desc-${possibleChoices[idx]}-${questionChoiceIterator}`
        //divID.innerHTML = divID.innerHTML + `<input type='checkbox' name='checkbox' id='${checkboxID}' value='${possibleChoices[idx]}'>`

        var checkboxForThisAns = document.createElement('input');
        checkboxForThisAns.id = checkboxID;
        checkboxForThisAns.name = 'checkbox'
        checkboxForThisAns.type = 'checkbox'
        checkboxForThisAns.value = `${possibleChoices[idx]}`
        divID.appendChild(checkboxForThisAns);
        
        divID.innerHTML = divID.innerHTML + `${possibleChoices[idx]}.`
        divID.innerHTML = divID.innerHTML + `<input type='text' value='enter the answer' name='choiceDesc' name='${choiceDescID}' size=30><br>`

        nameTracingList.push(checkboxID)
        nameTracingList.push(choiceDescID)
    }
    var creditBoxID = `pointBox-${questionChoiceIterator}`
    divID.innerHTML = divID.innerHTML + `credits:<input type='text' name='points' id='${creditBoxID}' value='enter the points' size=2>`
    divID.innerHTML = divID.innerHTML + "<br><br>"
}

function addQuestionTypeFields(divID) {
    var multichoiceStr = 'multichoice_' + questionChoiceIterator
    var multianswerStr = 'multianswer_' + questionChoiceIterator 
    divID.innerHTML = divID.innerHTML + `Select question type: <br>`
    divID.innerHTML = divID.innerHTML + `<input type='radio' id='${multichoiceStr}' onclick="selectQuestionType(this, '${multichoiceStr}')" name='answerType' value='singleAnswer'> Single Answer Question<br>`
    divID.innerHTML = divID.innerHTML + `<input type='radio' id='${multianswerStr}' onclick="selectQuestionType(this, '${multianswerStr}')" name='answerType' value='multiAnswer'> Multiple Answers Question<br>`
}

function selectQuestionType(divID, answerTypeEncoded) {
    answerTypeList = answerTypeEncoded.split('_')

    questionID = answerTypeList[answerTypeList.length-1]
    answerType = answerTypeList[0]
    var possibleChoices = ['a', 'b', 'c', 'd', 'e'];
    for (var i=0; i<possibleChoices.length; i+=1) {
        var checkboxID = `checkbox-${possibleChoices[i]}-${questionID}`
        if (answerType == 'multichoice') {
            document.getElementById(checkboxID).type = 'radio'
        } else {
            document.getElementById(checkboxID).type = 'checkbox'
        }
    }
}