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
    divX.innerHTML = divX.innerHTML + "<input type='text' name='question" + questionChoiceIterator + "' value='enter the question' size='30'><br> Select the check boxes for correct answers <br>"
    addAnswerFields(divX, nameTracingList);
}
function addAnswerFields(divX, nameTracingList) {
    var possibleChoices = ['a', 'b', 'c', 'd', 'e'];
    for (var idx = 0; idx < possibleChoices.length; idx += 1) {
        divX.innerHTML = divX.innerHTML + `<input type='checkbox' name='checkbox-${possibleChoices[idx]}-${questionChoiceIterator}' value='${possibleChoices[idx]}'> ${possibleChoices[idx]}.`
        divX.innerHTML = divX.innerHTML + `<input type='text' value='enter the answer' name='choice-desc-${possibleChoices[idx]}-${questionChoiceIterator}' size=30><br>`
    }
    divX.innerHTML = divX.innerHTML + "credits:<input type='text' name='points' value='enter the points' size=2>"
    divX.innerHTML = divX.innerHTML + "<br>"
}
