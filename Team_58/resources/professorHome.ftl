<!-- 
Freemarker page to display Professor details
@authour Shivam Verma
@authour NarenkumarKonchada 
@authour Carnic
@version 1.4
@date 03/14/2019
 -->

<html>
	<head>
		<#include "stylesheet.css">
	</head>
	<body>
		<div class="navbar">
			<div class="dropdown">
		  		<button class="dropbtn">v
			    		<i class="fa fa-caret-down"></i>
		    		</button>
		    		<div class="dropdown-content">
		    			<a href="login.jsp" name="logoutProfile">Logout</a>
		    		</div>
		  	</div> 
		</div>
         	<p class="fontColor" style="text-transform: uppercase;">Welcome  ${Session.userVO.getFirstname()}</p>
	        <div class="boxOuter">
       			<div class="boxRight" style="padding-bottom: 75%">
       	 	    		<h2 style="text-align: center">Details</h2>
         	    		<p>Name: <span><b>${Session.userVO.getFirstname()}</b></span> <span><b>${Session.userVO.getLastname()}</b></span></p>
	        		<p>Contact: <b>${Session.userVO.getPhonenumber()}</b> </p>
        	 		<p>E-mail: <b>${Session.userVO.getEmail()} </b></p>
          			<p>UserName: <b>${Session.userVO.getUsername()} </b></p>
	          	</div>
          	  	<div>
          	  	<#if Session.isCoursesAssigned==true>
	        		<div class="shiftTop">
        				<h2>Courses</h2>
	         			<form action="courseDashboard" method="POST">
        	 				<#list Session.CourseHashMap as courseId, courseName>
	         					<input checked="checked" class="marginBelow" type="radio" name=Course value=${courseId}> ${courseName}<br>
         					</#list>
       	 					<input class="button" type ="submit" value="Proceed"/>
       					</form>	
	        		</div>
        			<#else>
        				<p class="shiftTop">${Session.displayMessage}</p>
        			</#if>
        		</div>
        	</div>
	</body>
</html>
