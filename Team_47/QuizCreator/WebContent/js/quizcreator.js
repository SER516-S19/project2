
function addFields(thisElem) {
    var divX = thisElem.parentNode;
    divX.innerHTML = divX.innerHTML + "<br>"
    divX.innerHTML = divX.innerHTML + "question:<br>"
    divX.innerHTML = divX.innerHTML + "<input type='text' name='question' value='enter the question'size='30'+i><br> Select the check boxes for correct answers <br>"
    addAnswerFields(divX);
}
function addAnswerFields(divX) {
    divX.innerHTML = divX.innerHTML + "<input type='checkbox' name='choice' value='a'>&#97.<input type='text' value='enter the answer' name='a'size=30><br>"
    divX.innerHTML = divX.innerHTML + "<input type='checkbox' name='choice' value='b'>&#98.<input type='text' value='enter the answer' name='b'size=30><br>"
    divX.innerHTML = divX.innerHTML + "<input type='checkbox' name='choice' value='c'>&#99.<input type='text' value='enter the answer' name='c'size=30><br>"
    divX.innerHTML = divX.innerHTML + "<input type='checkbox' name='choice' value='d'>&#100.<input type='text' value='enter the answer' name='d'size=30><br>"
    divX.innerHTML = divX.innerHTML + "credits:<input type='text' name='points' value='enter the points'size=2>"
    divX.innerHTML = divX.innerHTML + "<br>"
}
