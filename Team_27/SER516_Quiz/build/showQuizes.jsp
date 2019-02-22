<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cosmo/bootstrap.min.css">
  	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />  
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>  
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
	body {
  background-color: #F7F7F7;
}


.header {
    padding: 5px;
    text-align:center;
    background:transparent;
    color:#000000;
    font-size: 50px;
    font-family:'Josefin Sans', sans-serif;  
}
</style>
</head>
<meta charset="ISO-8859-1">
<title>Quiz page</title>
</head>
<body>

</div>
</br>
</br>
<div class="header">
  <p>My quizes!</p>    
</div>
<br/>
<br/>
<div class="container-fluid">
  <!-- <div class="form-row text-center"> -->
                <div class="form-group">  
                     <form name="add_name" id="add_name" action="#">  
                          <div class="table-responsive">  
                          	 <div class="d-flex justify-content-center">
                               <table class="table table-bordered" id="dynamic_field" style="width: 650px">  
									<tr>
										<td><button type="button" name="add" id="add" class="btn btn-success"><i class="fas fa-plus"></i> Click Here to Add More Quizes</button></td>
									</tr>
                                    <tr>  
                                        <td><%  ArrayList rowValues = (ArrayList)session.getAttribute("rowValues");
	
	int i=0;
	%>
	<form action="/Quiz/deleteQuiz" method="get">
	<select id="mySelect" name="select"/>
	<option>--------------------SELECT-------------------</option>
	<%
	while(i < rowValues.size())
	
	{%>
		<option value="<%= rowValues.get(i)%>"/><%= rowValues.get(i)%>
<%
	i++;
	}
%>
</form>
                                        </td>
										  <td><button type="button" name="go" id="go" class="btn btn-primary"><i class="fas fa-arrow-right"></i> Go To Quiz</button></td> 
										  <td><button type="button" name="delete" id="delete" class="btn btn-danger"><i class="fas fa-trash-alt"></i><a href="/Quiz/deleteQuiz">Delete</a></button></td>
										  <td><button type="button" name="update" id="update" class="btn btn-warning"><i class="fas fa-pen"></i> Update</button></td>
										   
                                    </tr>  
                               </table>  
                              </div>
                          </div>  
                     </form>  
                </div>      	
  </div> 
  
  <script>
function myFunction() {
  var x = document.getElementById("mySelect");
  x.remove(x.selectedIndex);
}
</script>
  
</body>
</html>