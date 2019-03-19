<!-- 
Freemarker page to display the Student Homepage
@authour Joshua Drumm
@version 1.3
@date 02/22/2019
 -->
<html>
    <head>
        <#include "stylesheet.css">
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
    <h2 class="fontColor" style="text-transform: uppercase;">Student Home</h2>
	    
			<div class="dropdown">
		  		<button class="dropbtn">v
		    		<i class="fa fa-caret-down"></i>
	    		</button>
	    		<div class="dropdown-content">
	    			<a href="login.jsp" name="logoutProfile">Logout</a>
	    		</div>
		  	</div> 
		
		<div class="boxOuter">
			<center>
	        <p>Welcome ${Session.userVO.getFirstname()}!</p>
	        <form action="StudentCourseHome" method="GET">
	            <select name="CourseId">
	                <#list Session.CourseHashMap as courseId, courseName>
	                    <option value=${courseId}> ${courseName}</option>
	                </#list>
	            </select>
	            <input type = "submit" value="View Course Dashboard"/>
	        </form>
	        <form action="displayGrades" method="GET">
	        	<input type="submit" value="View Grades">
	        </form>
	        <#include "logout.html">
	        </center>
		</div>
    </body>
</html>