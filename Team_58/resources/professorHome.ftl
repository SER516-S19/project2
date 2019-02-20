<html>
	<body>
         <p> ${Session.profFirstName} </p>
         <form action="courseDashboard" method="POST">
         <select name="">
         <#list Session.ListCourse as course>
          <option name=${course}> ${course}</option>
           </#list>
         </select>
         <input type ="submit" value="Submit"/>
         </form>
	</body>
</html>