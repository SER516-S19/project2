function onBtnClick(){
	if(document.querySelectorAll(".rd2")[0].checked){
		document.querySelector(".login-form").action="myquizzes.jsp"
	} else {
		document.querySelector(".login-form").action="dashboard_professor.jsp"
	}
}