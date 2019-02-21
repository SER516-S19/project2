<html>
	<body>
         <p> ${Session.profFirstName} </p>
         <form action="courseDashboard" method="POST">
         <select name="Course">
         <#list Session.CourseHashMap as courseId, courseName>
          <option name=${courseId}> ${courseName}</option>
           </#list>
         </select>
         <input type ="submit" value="Submit"/>
         </form>
	</body>
</html>