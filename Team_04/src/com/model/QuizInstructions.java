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
        pw.println("<body>");
        pw.println("<form action =\"./login\" method=\"post\">");
        pw.println("<p style=\"font-size:200%;\" align=\"center\"> INSTRUCTIONS FOR QUIZ. </p>");
        pw.println("<div style=\"font-family:Sans-serif;border:3px; font-size:100%; border-style:solid; border-color:black; padding: 3em;\">");
        pw.println("The following are the instructions realted to the quiz : <br>");
        pw.print("<ul><li>");
        pw.println("Work in teams of 5 or 7 <br></li>");
        pw.println("<li>Submit a reviewed version of your Quiz 2 here. <br></li>");
        pw.println("<li>Submission should be done by only one member in the team through Blackboard.<br></li>");
        pw.println("<li>Add the team members names to the document in a separated page (only the names of these who collaborate).<br></li>");
        pw.println("<li>Due by Tuesday  February 12<br></li></ul></div><br><br><br>");
        pw.println("<input type = \"submit\" name=\"submit\" value = \"START QUIZ\" align = \"center\">");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendError(405, "HTTP POST METHOD CANNOT BE CALLED BY THE INSTRUCTIONS SERVLET...");
    }
}
