<!--
Freemarker page to display the Quiz Submitted Successfully
@authour Sami
@version 1.0
@date 03/16/2019
-->
<html>
    <head>
        <#include "stylesheet.css">
        <title>QUIZ Submitted Success</title>
    </head>
 <style>
	
	input[type=button], input[type=submit], input[type=reset] {
  background-color: #555555;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
        <body>
        <h2 class="fontColor" style="text-transform: uppercase;">Quiz Submitted Successfully</h2>
        <div class="box" style="text-align:center">
        <p class="smallFontColor" style="text-align : center;"> <b> Your Quiz has been submitted Successfully </b></p>
         <form action="SubmitQuiz" method = "GET"> 
                <input type="submit" value="Course Dashboard">
            </form>
        </div>
        
    </body>
</html>