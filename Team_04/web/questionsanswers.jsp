<%@ page import="com.model.QuestionAnswers" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.QuestionAnswers" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: yuvan
  Date: 2/20/2019
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<style>
    .QuesAnsDiv
    {
        width:50%;
        margin-top:10%;
        margin-left: 30%;
    }
.navBtn
{
    margin-left:50%;
}
</style>
<body>
<div class="QuesAnsDiv">




    <%Map<String, List<QuestionAnswers>> ques =
            (Map<String, List<QuestionAnswers>>)request.getAttribute("data");
        int count = 1;
        for(String key: ques.keySet()){
    %>
        <h1><%= count++ %>.<%=key %></h1>
            <%
                for (QuestionAnswers answers : ques.get(key)) {
                    String buttonType = "";
                    if(answers.getQues_type().equals("SA"))
                    {
                        buttonType = "radio";
                    }
                    else
                    {
                        buttonType = "checkbox";
                    }
            %>
                    <div class="options"><input type=<%=buttonType%> class="optionTag" data-val=""><%= answers.getAns_desc() %></input></div>
            <%}%>
    <% }%>


</div>
<div class="navBtn">
<input type="button" text="previous" value="previous" class="prevBtn"/>
<input type="button" text="next" value="next" class="nextBtn"/>
</div>

</body>
</html>
