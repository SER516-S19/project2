/**
 * Javascript for login.jsp
 *
 * @author  Yu-Ting Tsao
 * @version 1.0
 * @since   2019/3/2
 */
var params = window.location.search
.substring(1)
.split("&")
.map(v => v.split("="))
.reduce((map, [key, value]) => map.set(key, decodeURIComponent(value)), new Map())

if (params.get("error") == "true") {
	document.getElementById("wrong").style.visibility = "visible";
} else {
	document.getElementById("wrong").style.visibility = "hidden";
}

function loginCheck() {
	
	var visitor = { };
	
	visitor["username"] = document.getElementById("username").value;
	visitor["password"] = document.getElementById("password").value;
	
	if (visitor["username"] && visitor["password"]) {
		//Now transmit this information to backend.
		var visitorJson = JSON.stringify(visitor);
		
		var userId = "878712345";
		var userName = "Harry Potter";	
		
		document.querySelector(".login-form").action = pageDirection(userId, userName);
	}
}

function pageDirection(id, name) {
	var queryString = "?userId=" + id + "&userName=" + name;
	
	if(document.querySelectorAll(".rd2")[0].checked) {
		 return "myquizzes.jsp" + queryString;
	} else {
		return "dashboard_professor.jsp" + queryString;
	}
}

