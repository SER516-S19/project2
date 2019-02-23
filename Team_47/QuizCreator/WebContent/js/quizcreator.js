
var i=1;
function addFields()
{
div1.innerHTML = div1.innerHTML + "question:<br>"
div1.innerHTML = div1.innerHTML + "<input type='text' name='question' value='enter the question'size='30'+i><br> Select the check boxes for correct answers <br>"
addAnswerFields();
}
function addAnswerFields()
{
div1.innerHTML = div1.innerHTML + "<input type='checkbox' name='choice' value='a'>&#97.<input type='text' value='enter the answer' name='a'size=30><br>"
div1.innerHTML = div1.innerHTML + "<input type='checkbox' name='choice' value='b'>&#98.<input type='text' value='enter the answer' name='b'size=30><br>"
div1.innerHTML = div1.innerHTML + "<input type='checkbox' name='choice' value='c'>&#99.<input type='text' value='enter the answer' name='c'size=30><br>"
div1.innerHTML = div1.innerHTML + "<input type='checkbox' name='choice' value='d'>&#100.<input type='text' value='enter the answer' name='d'size=30><br>"
div1.innerHTML = div1.innerHTML +"credits:<input type='text' name='points' value='enter the points'size=2>"
}
