
var id=0;
function addFields()
{
div1.innerHTML = div1.innerHTML + "<br>question:<br>"
div1.innerHTML = div1.innerHTML + "<input type='text' name='question' value='enter the question'size='30'+i><br> Select the check boxes for correct answers <br>"
addAnswerFields();
}
function addAnswerFields()
{
	var checkname = 'choice'+id;
	var questioncontent= 'questioncontent'+id;
	var points = 'points'+id;
div1.innerHTML = div1.innerHTML + "<input type='checkbox' name="+checkname+" value='a'>&#97.<input type='text' value='enter the answer' name="+questioncontent+" size=30><br>"
div1.innerHTML = div1.innerHTML + "<input type='checkbox' name="+checkname+" value='b'>&#98.<input type='text' value='enter the answer' name="+questioncontent+" size=30><br>"
div1.innerHTML = div1.innerHTML + "<input type='checkbox' name="+checkname+" value='c'>&#99.<input type='text' value='enter the answer' name="+questioncontent+" size=30><br>"
div1.innerHTML = div1.innerHTML + "<input type='checkbox' name="+checkname+" value='d'>&#100.<input type='text' value='enter the answer' name="+questioncontent+" size=30><br>"
div1.innerHTML = div1.innerHTML +"credits:<input type='text' name="+points+" value='enter the points'size=2>"
id++;
}
