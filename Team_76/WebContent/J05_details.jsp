<!-- UI showing the details tab for the professor -->

<html>
<head>
<title>Details Tab</title>

</head>
<style>
div.ex {
	text-align: right width:100px;
	padding: 1px;
	border: 5px solid grey;
	margin: 0px;
}

div.ex1 {
	text-align: right width:900px;
	padding: 150px;
	border: 5px solid grey;
	margin: 0px;
}

button[id=myButton] {
  width: 20%;
  background-color: #520c0c;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #961212;
}

</style>
<body>
	<form action="QuizServletDetails" method = "POST">
	<h1>DETAILS PAGE</h1>

		<form action="Details-Control" method="post">

		<textbox name="myTextBox1" cols="50" rows="2" style="border:5px solid grey;">
			QUIZ NAME
		</textbox>
        <br>
        <br>
        
	    <div class="ex">
		<textbox name="myTextBox2" cols="50" rows="2" style="border:5px solid grey;">
			QUIZ INSTRUCTIONS
		</textbox>
        <br>
        <br>
		<textarea name ="instructions" rows="20" cols="500">
			Specify the quiz instructions here
		</textarea>
		<br>
		</div>

	<p>Select the quiz type</p>
	<select name="ValueChoosen">
	<option value="1">Multiple Choice</option>
    <option value="2">Subjective</option>
    <option value="3">Practice</option>
    </select>

    <p>Assignment group</p>
	<select name="groupField">
	<option value="1">Quizzes</option>
    <option value="2">Practice</option>
    </select>

    <br>
    <br>
	<button onclick="location.href = 'try.html';" id="myButton" class="float-left submit-button" >CANCEL</button>
	<button onclick="location.href = 'try.html';" id="myButton" class="float-left submit-button" >CONTINUE</button>

</body>
</html>