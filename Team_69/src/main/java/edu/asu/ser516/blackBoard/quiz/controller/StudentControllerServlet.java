package edu.asu.ser516.blackBoard.quiz.controller;

import edu.asu.ser516.blackBoard.quiz.bean.*;
import edu.asu.ser516.blackBoard.quiz.dao.AnswerDAO;
import edu.asu.ser516.blackBoard.quiz.dao.QuestionDAO;
import edu.asu.ser516.blackBoard.quiz.dao.QuizDAO;
import edu.asu.ser516.blackBoard.quiz.dao.StatisticsDAO;
import edu.asu.ser516.blackBoard.quiz.services.StudentServices;

import java.io.IOException;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Controller class for student page
 * 
 * @author : Sourabh Siddharth
 * @version : 1.0
 * @since : 02/16/2019
 * 
 */
public class StudentControllerServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setStatus(200);
		ResponseStatistics stats;
		String queryParams = req.getQueryString();
		String quizName = queryParams.split("=")[1];
		QuizDAO quizDAO = new QuizDAO();
		int quizId = quizDAO.fetchQuizId(quizName);
		StudentServices service = new StudentServices();
		String questionAnswerJSON = service.getQuestionDetails(quizId);
		HttpSession session = req.getSession();
		session.setAttribute("studentResponseJSON",questionAnswerJSON);
		req.getRequestDispatcher("/views/student.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String var = "[{\"questionId\":3,\"quiz\":{\"quizId\":1,\"quizName\":\"Quiz1\",\"quizInstructions\":\"Read\",\"quizType\":\"Graded\",\"quizTimeLimit\":\"12:30:00 AM\",\"isShuffled\":true,\"isPublished\":false},\"question\":\"Question3\",\"correctAnswerId\":0,\"isMultiple\":true,\"points\":10}]";
		String view = "error";
		//HttpSession session = request.getSession();
		//String studentResponse = (String) request.getParameter("studentResponseJSON");
		StudentServices service = new StudentServices();
		view = service.feedAnswers(var);
		request.getRequestDispatcher(view).forward(request, response);
	}
	
}