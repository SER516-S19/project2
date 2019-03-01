
var queryString = decodeURIComponent(window.location.search);
queryString = queryString.substring(1);
var queries = queryString.split("&");
// Not working now....
for (var i = 0; i < queries.length; i++) {
//  alert(queries[i]);
}

window.onload=function(){
	
var rows = document.getElementsByTagName("tr");
    for (var i = 0; i < rows.length; i++) {
        rows[i].onclick = function() {
//           alert("You have chose Quiz" + i + ".");
           window.location.href = '/instruction.jsp';
        };
    }
}

