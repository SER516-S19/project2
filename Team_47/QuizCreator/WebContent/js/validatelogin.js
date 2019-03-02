
function onBtnClick() {
	
	var visitor = { };
	
	visitor["username"] = document.getElementById("email").value;
	visitor["password"] = document.getElementById("password").value;
	
	if (visitor["username"] && visitor["password"]) {
		//Now transmit this information to backend.
		var visitorJson = JSON.stringify(visitor);
		
		document.querySelector(".login-form").action = pageDirection();
		
//		//Do calls and use call back
//		$.ajax({
//	        type: $form.attr('method'),
//	        url:  $form.attr('action'),
//	        data: visitorJson,
//	        success: function (data) {
//	            console.log("Data received: ");
//	            console.log(data);
//	            if(data === "SUCCESS") {
//	            	alert ("Login SUCCESS");
//	            	window.location = pageDirection();
//	            } else {
//	            	alert ("Login FAILED");
//	            }
//	        }
//	    });
	}
}

function pageDirection() {
	if(document.querySelectorAll(".rd2")[0].checked) {
		return "myquizzes.jsp";
	} else {
		return "dashboard_professor.jsp";
	}
}

