package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.CreateQuizVO;
import edu.asupoly.ser516.model.QuizDAOBean;
import edu.asupoly.ser516.model.QuizVO;

/**
 * Class CreateQuiz Servlet is a controller that routes the user to Create Quiz
 * after Course Dashboard.
 * 
 * @author carnic
 * @version 1.1
 * @date 02/21/2019
 **/

public class CreateQuizServlet extends HttpServlet {

	/**
	 * This method is to get CreateQuiz UI page 
	 *@param request  Request made to server
	 *@param response  Responses from server
	 *
	 * @throws IOException
	 */
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.sendRedirect(request.getContextPath() + "/createQuiz.ftl");	
	}
	
	/**
	 * This method is to post CreateQuiz 
	 *@param request  Request made to server
	 *@param response  Responses from server
	 *
	 * @throws IOException, ServletException
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		try {
        	String quizTitle = request.getParameter("quizTitle");
        	String quizInstructions = request.getParameter("quizInstructions");
        	String quizScheduledDate = request.getParameter("quizScheduledDate");
        	int assignedTime = Integer.parseInt(request.getParameter("assignedTime"));
        	boolean isShuffled = Boolean.valueOf(request.getParameter("isShuffled"));
        	
    		HttpSession session = request.getSession();
    		int courseId = (int) session.getAttribute("courseId");
    		
    		/**
    		 * running a query 
    		 * to get insert quiz details in table
    		 */
    		
    		CreateQuizVO createQuizVO = new CreateQuizVO(courseId, quizTitle, quizInstructions, quizScheduledDate, 0, isShuffled, assignedTime, false);
    		
    		QuizDAOBean obj = new QuizDAOBean();
    		obj.creatingQuiz(createQuizVO);
    		
    		System.out.println(request.getContextPath()+"/creatQuiz.ftl");

    		/**
    		 * running a query 
    		 * to get the value of quizId in session
    		 */
    		
    		int quizId = obj.gettingQuizId(createQuizVO);
    		
			session.setAttribute("quizId", quizId);
			//request.getRequestDispatcher("/createQuestions.ftl").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/createQuestions.ftl");
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
