//var buttonList=document.querySelectorAll(".drum ");
//can be used
var questions=["Which of the followings are prerequisites of this course?",
	"What is time complexity of mergesort?",
	"What is value of 5!?"
]
var  answers=[
	[" proficient in a high-level programming language like Java or C++ and " +
			"the environment in which a program is developed, e.g., editor, " +
			"compiler/interpreter, etc.",
			" understood basic concept of computer organization, including registers, memory arithmetic and logic units, processor, input and output.",
			"Nothing",
			"Hellow world"
		],
		["nlogn","n*n","log n","squareroot(n)"],
		["1","2","12","120"]
				
		]



var nextQ=document.querySelector(".nextQ");
var prevQ=document.querySelector(".prevQ");

nextQ.addEventListener("click",
		
function incre_question_num(){
	var text=document.querySelector(".question_num").innerHTML;
	var question_num = text.slice(9,11);
	question_num=question_num-'0';
	question_num+=1;
	if(question_num==10){
		nextQ.style.visibility = 'hidden';
	}
	prevQ.style.visibility = 'visible';
	document.querySelector(".question_num").innerHTML="Question "+question_num;
	var question=Math.floor(Math.random()*3);
	setQuestionAnswers(question);
	
//	alert(question_num);
});
prevQ.addEventListener("click",function original(){
	

	var text=document.querySelector(".question_num").innerHTML;
	var question_num = text.slice(9,11);
	question_num=question_num-'0';
	question_num-=1;
//	alert(question_num);
	if(question_num==1){
		prevQ.style.visibility = 'hidden';
	}
	nextQ.style.visibility = 'visible';

	document.querySelector(".question_num").innerHTML="Question "+question_num;
	var question=Math.floor(Math.random()*3);
	setQuestionAnswers(question);
  })

function setQuestionAnswers(id){

	document.querySelector(".question-title").innerHTML=questions[id];
	document.querySelector(".option1").innerHTML=answers[id][0];
	document.querySelector(".option2").innerHTML=answers[id][1];
	document.querySelector(".option3").innerHTML=answers[id][2];
	document.querySelector(".option4").innerHTML=answers[id][3];
	
}
