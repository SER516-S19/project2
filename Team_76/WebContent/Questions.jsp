<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>
</head>
<body>

<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'Questions')">Questions</button>
</div>



<div id="Questions" class="tabcontent">
  <h3>Questions</h3>
  <form action="ProfessorQuestions" method="POST">
 <%= request.getAttribute("Questions") %>
  
  <div class="form-group">
  <label for="q1">Question:</label>
  <input type="text" class="form-control" name="Question" id="q1" placeholder="Enter your question">
</div>
<div class="form-group">
  <label for="a1">Answer1:</label>
  <input type="text" class="form-control" name="Option1" id="a1" placeholder="Enter option1">
</div>
<div class="form-group">
  <label for="a2">Answer2:</label>
  <input type="text" class="form-control" name="Option2" id="a2" placeholder="Enter option2">
</div>
<div class="form-group">
  <label for="a3">Answer3:</label>
  <input type="text" class="form-control" name="Option3" id="a3" placeholder="Enter  option3">
</div>
<div class="form-group">
  <label for="a4">Answer4:</label>
  <input type="text" class="form-control" name="Option4" id="a4" placeholder="Enter option4">
</div>
<button class="btn btn-primary" > Continue </button>
 <input class="btn btn-primary" type="submit" name="submit"></input>
  </form>
</div>



<script>
function openTab(evt, tabName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
   
</body>
</html> 