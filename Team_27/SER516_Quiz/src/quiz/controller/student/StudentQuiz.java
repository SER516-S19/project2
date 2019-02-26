package quiz.controller.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.dao.professor.QuizDetailsDao;
import quiz.dao.student.StudentQuizDao;
import quiz.exceptions.DataAccessException;
import quiz.model.professor.QuizModel;
import quiz.model.student.QuizAttempt;

public class StudentQuiz extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set Content-Type and other response headers
		//response.setHeader("Cache-Control", "no-cache");
		String resultString = "";
		
		try {
			QuizDetailsDao quizDetailsDao = new QuizDetailsDao();
			ArrayList<String> quizes = quizDetailsDao.getAll();
			for(String quiz : quizes) {
				resultString += quiz + " ";
			}
		}
		catch (Exception exc) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}	
		
		response.setContentType("text/plain");
		response.getWriter().write(resultString);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuizAttempt attempt = new QuizAttempt(1, 1, 1, "");
		StudentQuizDao quizDetailsDao = new StudentQuizDao();
		try {
			quizDetailsDao.insert(attempt);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
