package com.model;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizInstructions extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter pw = response.getWriter();
        pw.println("<html><head>");
        pw.println("<title>Quiz Information</title>");
        pw.println("</head>");
		pw.println("<style>.btn2 {\r\n" + 
        		"\r\n" + 
        		"        display: inline-block;\r\n" + 
        		"        white-space: nowrap;\r\n" + 
        		"        flex-basis: auto;\r\n" + 
        		"        width: auto;\r\n" + 
        		"        font-size: .875rem;\r\n" + 
        		"        background-color: black;\r\n" + 
        		"        border: 2px;\r\n" + 
        		"		 border-style:solid;\n"+
        		"        cursor: pointer;\r\n" + 
        		"        border-radius: 4px;\r\n" + 
        		"        text-align: center;\r\n" + 
        		"        font-family: CircularPro, \"Helvetica Neue\", Helvetica, \"Segoe UI\", Tahoma, Arial, sans-serif;\r\n" + 
        		"        font-weight: 700;\r\n" + 
        		"        line-height: 1.28571429;\r\n" + 
        		"        letter-spacing: .8px;\r\n" + 
        		"        text-transform: uppercase;\r\n" + 
        		"        text-decoration: none;\r\n" + 
        		"        padding: 19px 40px 20px;\r\n" + 
        		"        transition: box-shadow 420ms cubic-bezier(.165, .84, .44, 1), color 420ms cubic-bezier(.165, .84, .44, 1), background 420ms cubic-bezier(.165, .84, .44, 1);\r\n" + 
        		"        color: white;\r\n" + 
        		"\r\n" + 
        		"    }\r\n" + 
        		"");

        pw.println("</style>");
        pw.println("<body>");
        pw.println("<form action =\"./loadquestionanswerservlet\" method=\"get\">");
        pw.println("<p style=\"font-size:200%;\" align=\"center\"> Instructions For Quiz. </p>");
        pw.println("<div style=\"font-family:Sans-serif; font-size:100%; line-height: 1.6; padding: 3em;\">");
        pw.println("The following are the instructions realted to the quiz : <br>");
        pw.print("<ul><li>");
        pw.println("Work in teams of 5 or 7 <br></li>");
        pw.println("<li>Submit a reviewed version of your Quiz 2 here. <br></li>");
        pw.println("<li>Submission should be done by only one member in the team through Blackboard.<br></li>");
        pw.println("<li>Add the team members names to the document in a separated page (only the names of these who collaborate).<br></li>");
        pw.println("<li>Due by Tuesday  February 12<br></li></ul></div><br><br><br>");
        pw.println("<p align=\"center\">");
        pw.println("<input type = \"submit\" class = \"btn2\" name=\"submit\" value = \"START QUIZ\" >");
        pw.println("</p>");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendError(405, "HTTP POST METHOD CANNOT BE CALLED BY THE INSTRUCTIONS SERVLET...");
    }
}
