<%--
  Created by IntelliJ IDEA.
  User: jaini
  Date: 2/19/2019
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><h2>Quiz</h2></title>
</head>
<body>
    <form action="" method="post" name="q_form">
        <table align="center">

            <td>
                <tr>
                    <b>Question-1</b>
                     <t /> Name of the screen that recognizes touch input is: <br />

                        <input type="radio" name="Q1" value="A" /> Recog Screen <br />
                        <input type="radio" name="Q1" value="B" /> Point Screen <br />
                        <input type="radio" name="Q1" value="C" /> Touch Screen <br />
                        <input type="radio" name="Q1" value="D" /> Android Screen <br />
                </tr>
                <br />

                <tr>
                    <b>Question-2</b>
                    <t /> Identify the device through which data and instructions are entered into a computer <br />

                        <input type="radio" name="Q2" value="A" /> Software <br />
                        <input type="radio" name="Q2" value="B" /> Output device <br />
                        <input type="radio" name="Q2" value="C" /> Input Device <br />
                        <input type="radio" name="Q2" value="D" /> Memory <br />
                </tr>
                <br />

                <tr>
                    <b>Question-3</b>
                    <t /> Computer Moniter is also known as: <br />

                    <input type="radio" name="Q3" value="A" /> DVU <br />
                    <input type="radio" name="Q3" value="B" /> UVD <br />
                    <input type="radio" name="Q3" value="C" /> VDU <br />
                    <input type="radio" name="Q3" value="D" /> CCTV <br />
                </tr>
                <br />
                <tr>
                    <b>Question-4</b>
                    <t /> Arrange in ascending order the units of memory TB, KB, GB, MB <br />

                    <input type="radio" name="Q4" value="A" /> TB>MB>GB>KB<br />
                    <input type="radio" name="Q4" value="B" /> MB>GB>TB>KB <br />
                    <input type="radio" name="Q4" value="C" /> TB>GB>MB>KB <br />
                    <input type="radio" name="Q4" value="D" /> GB>MB>KB>TB <br />
                </tr>
                <br />

                <tr>
                    <b>Question-5</b>
                    <t /> Which one of these stores more data than a DVD ? <br />

                    <input type="radio" name="Q5" value="A" /> CD Rom <br />
                    <input type="radio" name="Q5" value="B" /> Floppy <br />
                    <input type="radio" name="Q5" value="C" /> Blue Ray Disk <br />
                    <input type="radio" name="Q5" value="D" /> Red Ray Disk <br />
                </tr>


            </td>
        </table>
		
		<input type="button" value="Save and Submit"  onclick="notAnswerdWarn();"/>
		
		<script type="text/javascript">
			//**** "notAnswerdWarn" function displays messages about unanswered questions while submitting the quiz
			// Below code repeats because, each question has manual 'name' in the above code 
			// The below code will be made structured and efficient when the quiz questions above will be populated 
			// dynamically from database (with no hard coding).
			function notAnswerdWarn() {            
				var radio_q1_val = "";

				for (i = 0; i < document.getElementsByName('Q1').length; i++) {
					if (document.getElementsByName('Q1')[i].checked) {
						radio_q1_val = document.getElementsByName('Q1')[i].value;      
					}        
				}
				if (radio_q1_val === "")
				{
					alert("You have not answered question 1");
					return;
				}        
				
				var radio_q2_val = "";
				for (i = 0; i < document.getElementsByName('Q2').length; i++) {
					if (document.getElementsByName('Q2')[i].checked) {
						radio_q2_val = document.getElementsByName('Q2')[i].value;      
					}        
				}
				if (radio_q2_val === "")
				{
					alert("You have not answered Question 2");
					return;
				}   

				
				
				var radio_q3_val = "";
				//var checked = 0;
				for (i = 0; i < document.getElementsByName('Q3').length; i++) {
					if (document.getElementsByName('Q3')[i].checked) {
						//alert("this radio button was clicked: " + document.getElementsByName('gender')[i].value);
						radio_q3_val = document.getElementsByName('Q3')[i].value;      
						//checked = 1;
					}        
				}
				if (radio_q3_val === "")
				{
					alert("You have not answered Question 3");
					return;
				}  
				
				var radio_q4_val = "";
				//var checked = 0;
				for (i = 0; i < document.getElementsByName('Q4').length; i++) {
					if (document.getElementsByName('Q4')[i].checked) {
						//alert("this radio button was clicked: " + document.getElementsByName('gender')[i].value);
						radio_q4_val = document.getElementsByName('Q4')[i].value;      
					}        
				}
				if (radio_q4_val === "")
				{
					alert("You have not answered Question 4");
					return;
				}  
				
				var radio_q5_val = "";
				for (i = 0; i < document.getElementsByName('Q5').length; i++) {
					if (document.getElementsByName('Q5')[i].checked) {
						//alert("this radio button was clicked: " + document.getElementsByName('gender')[i].value);
						radio_q5_val = document.getElementsByName('Q5')[i].value;      
					}        
				}
				if (radio_q5_val === "")
				{
					alert("You have not answered Question 5");
					return;
				} 

				// Begin: Saving answered to DB after Submitting the quiz - Implemented by Sami


				// END: Saving answered to DB after Submitting the quiz
				
				alert("Congrats!!! Quiz has been submitted successfully.");
			}
		</script>

    </form>

</body>
</html>