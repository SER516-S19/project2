package edu.asupoly.ser516.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CreateQuiz extends HttpServlet{
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException) {
            	
            	String quizTitle = request.getParameter("quizTitle");
            	String instructions = request.getParameter("instructions");
            	int timer = Integer.parseInt(request.getParameter("timer"));
            	int isGraded = Integer.parseInt(request.getParameter("isGraded"));
            	int shuffle = Integer.parseInt(request.getParameter("shuffle"));
            	
            	System.out.println("Quiz Title : " + quizTitle);
            	System.out.println("Quiz Instructions : " + instructions);
            	System.out.println("Quiz Duration : " + timer);
            	System.out.println("Is it graded? " + isGraded);
            	System.out.println("Shuffle questions? " + shuffle);
            }
}
