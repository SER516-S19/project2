<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bean.Question"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Quiz ${title}</title>
<style>
label input[type=radio] {
	visibility: hidden;
}

label input[type=radio]:checked {
	visibility: visible;
}

label: visited {
	display: none;
}
</style>
</head>
<body>
	<%
		Question[] questionArray;
		questionArray = (Question[]) session.getAttribute("Question");
	%>
	<form action="quiz" method="GET">
		<div class="container">
			<div class="row" align="center">
				<div class="col-md"></div>
				<div class="col-md">
					<div class="form-check ">
						<%
							for (int j = 0; j < 4; j++) {
								String[] options = questionArray[j].getOptions().split(",", 0);
						%>
						<h3><%=questionArray[j].getQuestions()%></h3>
						<label for="<%=questionArray[j].getQuestionId() + "a"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="1" name="options"
							id="<%=questionArray[j].getQuestionId() + "a"%>" required>
							<%=options[0]%></label> <label
							for="<%=questionArray[j].getQuestionId() + "b"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="2" name="options"
							id="<%=questionArray[j].getQuestionId() + "b"%>" required>
							<%=options[1]%></label> <label
							for="<%=questionArray[j].getQuestionId() + "c"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="3" name="options"
							id="<%=questionArray[j].getQuestionId() + "c"%>" required>
							<%=options[2]%></label> <label
							for="<%=questionArray[j].getQuestionId() + "d"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="4" name="options"
							id="<%=questionArray[j].getQuestionId() + "d"%>" required>
							<%=options[3]%></label>
						<%
							}
						%>
					</div>
					<div class="row" style="margin: 15px;">
						<div class="col">
							<button type="reset" 
								class="btn btn-danger  btn-block">Cancel</button>
						</div>
						<div class="col">
							<button type="submit" 
								style="margin-left: 20px" class="btn btn-success btn-block">Submit</button>
						</div>
					</div>
				</div>
				<div class="col-md"></div>
			</div>
		</div>

	</form>
</body>

</html>
