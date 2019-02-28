/** 
  * Author(s): Meng-Ze Chen, Jiayan Wang
  * Date: 2019/2/27
  * Description: Page for creating quizzes
  */
var i = 1;
function addFields(thisElem, nameTracingList) {
    var divX = thisElem.parentNode;
    divX.innerHTML = divX.innerHTML + "<br>"
    divX.innerHTML = divX.innerHTML + "question:<br>"
    questionChoiceIterator += 1;
    var questionID = `question-${questionChoiceIterator}`
    divX.innerHTML = divX.innerHTML + `<input type='text' name='${questionID}' value='enter the question' size='30'>`
    divX.innerHTML = divX.innerHTML + "<br> Select the check boxes for correct answers <br>"
    nameTracingList.push(questionID)
    addAnswerFields(divX, nameTracingList);
}
function addAnswerFields(divX, nameTracingList) {
    var possibleChoices = ['a', 'b', 'c', 'd', 'e'];
    for (var idx = 0; idx < possibleChoices.length; idx += 1) {
        var checkboxID = `checkbox-${possibleChoices[idx]}-${questionChoiceIterator}`
        var choiceDescID = `choice-desc-${possibleChoices[idx]}-${questionChoiceIterator}`
        divX.innerHTML = divX.innerHTML + `<input type='checkbox' name='${checkboxID}' value='${possibleChoices[idx]}'>`
        divX.innerHTML = divX.innerHTML + `${possibleChoices[idx]}.`
        divX.innerHTML = divX.innerHTML + `<input type='text' value='enter the answer' name='${choiceDescID}' size=30><br>`

        nameTracingList.push(checkboxID)
        nameTracingList.push(choiceDescID)
    }
    divX.innerHTML = divX.innerHTML + "credits:<input type='text' name='points' value='enter the points' size=2>"
    divX.innerHTML = divX.innerHTML + "<br>"
}
