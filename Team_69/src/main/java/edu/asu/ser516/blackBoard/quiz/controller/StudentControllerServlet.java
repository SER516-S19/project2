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
	private final static String SUBMIT_ACTION = "submit";
	private static String studentPage = "/student.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setStatus(200);
		ResponseStatistics stats;
		String queryParams = req.getQueryString();
		String quizName = queryParams.split("=")[1];
		QuizDAO quizDAO = new QuizDAO();
		int quizId = quizDAO.fetchQuizId(quizName);
		QuestionDAO questionDAO = new QuestionDAO();
		List<Question> questions = questionDAO.getQuestionsByQuizId(1);
		AnswerDAO answerDAO = new AnswerDAO();
		List<Answer> answers = answerDAO.getAnswersByQuestionId(1);

		StatisticsDAO statisticsDAO = new StatisticsDAO();
		//QuestionDAO questionDAO = new QuestionDAO();
		User user = new User("abc","student","abc.com","1234");
		Time time = new Time(00,10,00);
		Quiz quiz = new Quiz("Quiz3","read/write","graded",time,true,false);
		Question question = new Question(quiz,"q1",1,true,10);
		Answer answer = new Answer(question,"abc","a");
		questionDAO.addQuestion(question);
		stats = new ResponseStatistics(user,quiz,question,answer);
		System.out.println(stats);
		statisticsDAO.insertAnswer(answer);
		statisticsDAO.insertStudentResponse(stats);
		String action = (String) req.getSession().getAttribute("action");
		if(action.equals("load")) {
			req.getRequestDispatcher("/views/student.jsp").forward(req, resp);
		}
		else if(action.equals("data")) {
			StudentServices service = new StudentServices();
			String questionAnswerJSON = service.getQuestionDetails(quizId);
			resp.getWriter().write(questionAnswerJSON);
		}

		req.setAttribute("QuizName",quizName);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("user_id");
		String action = request.getParameter("action");

		//Servlet Action on quiz submission
		if(action.equals(SUBMIT_ACTION)) {
			try {
				response.sendRedirect("Success.jsp");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}