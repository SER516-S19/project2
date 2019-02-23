package edu.au.quiz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.au.quiz.utils.StringUtils;

/**
 * @author  Amit Pandey
 * @version 1.0
 * This servlet will perform the form validations,
 * which will be invoked by a JSP / Servlet Action method using HTTP post.
 * 
 * Requirement from Slack is below : 
 * 
 * The form validation fields to be validated based on discussion on slack ai below : 
 * 	quiz_id=1293
 *	student_fk=237878
 *	timeTaken=38477 //I guess this is in seconds? It is an int. we know that.
 *	attempt=3
 *	ques_fk.0=9023
 *	choice_fk.0.0=21323 //typical multiple choice answer
 *	ques_fk.1=9024 //multiple answer where no answers were selected
 *	ques_fk.2=9025
 *	choice_fk.2.0=23873
 *	choice_fk.2.1=23880	
 *	choice_fk_2.2=23878
 * 
 */
@SuppressWarnings("serial") 
@WebServlet("/Validate")
public class Validate extends HttpServlet
{
	protected void doGet(HttpServletRequest request , HttpServletResponse response)
	{
		//Redirect the get request to Post request.
		this.doPost(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response)
	{
		String html_errorMessage = "";
		String quizIdField = request.getParameter("quiz_id");
		String studentIdField = request.getParameter("studentId");
		System.out.println(studentIdField);
		String timetaken = request.getParameter("timetaken");
		String attempt = request.getParameter("attempt");
		//Mandatory fields needed from the Form submission 
		
		String ques_fk = request.getParameter("ques_fk.0");
		String choice_fk0 = request.getParameter("choice_fk.0.0");
		String ques_fk1 = request.getParameter("ques_fk.1");
		String ques_fk2 = request.getParameter("ques_fk.2");
		String choice_fk3 = request.getParameter("choice_fk");
		String choice_fk20 = request.getParameter("choice_fk.2.0");
		String choice_fk21 = request.getParameter("choice_fk.2.1");
		String choice_fk22 = request.getParameter("choice_fk.2.2");
		
		//Step 1 : Validate for mandatory fields in the form.
		if (StringUtils.areNullOrEmpty(ques_fk,choice_fk0,ques_fk1,ques_fk2,choice_fk3,choice_fk20,choice_fk21,choice_fk22))
		{
			html_errorMessage = "One or more mandatory fields is/are missing.";
			System.out.println(html_errorMessage);
		}//if
		
		//Step 2 : Validate for the types of the fields in the Form.
		try 
		{
			int quizField = Integer.parseInt(quizIdField);	
		}//try
		catch(Exception e)
		{
			html_errorMessage = "quizField is not of type integer."; 
			System.out.println(html_errorMessage);
		}//catch
	
		try 
		{
			Integer quizField = Integer.parseInt(studentIdField);	
		}//try
		catch(Exception e)
		{
			html_errorMessage = "studentIdField is not of type integer."; 
			System.out.println(html_errorMessage);
		}//catch
	
		try 
		{
			Integer quizField = Integer.parseInt(timetaken);	
		}//try
		catch(Exception e)
		{
			html_errorMessage = "timetaken is not of type integer."; 
			System.out.println(html_errorMessage);
		}//catch
	
		try 
		{
			Integer quizField = Integer.parseInt(attempt);	
		}//try
		catch(Exception e)
		{
			html_errorMessage = "attempt is not of type integer."; 
			System.out.println(html_errorMessage);
		}//catch
		try
		{
			response.setContentType("text/html");
			PrintWriter pout = response.getWriter();
			pout.println("<html><head></head><body><form><b>"+html_errorMessage+"</b></form></body></html>");
		}//try
		catch(IOException ioe)
		{
			System.out.println("Critical error in Servlet.");
		}//catch				
	}//doPost
}//Validate