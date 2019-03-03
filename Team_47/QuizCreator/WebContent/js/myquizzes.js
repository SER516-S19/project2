
window.onload=function(){
var rows = document.getElementsByTagName("tr");
    for (var i = 0; i < rows.length; i++) {
        rows[i].onclick = function() {
//           alert("You have chose Quiz" + i + ".");
           window.location.href = '/instruction.jsp';
        };
    }
}