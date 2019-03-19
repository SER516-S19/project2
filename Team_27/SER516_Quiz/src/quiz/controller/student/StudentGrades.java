package quiz.controller.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.dao.professor.QuestionsDao;
import quiz.dao.professor.QuizDetailsDao;
import quiz.dao.student.StudentAttemptDao;
import quiz.model.professor.Question;
import quiz.model.student.QuizAttempt;

/**
 * Controller to insert the grades into the Database.
 * 
 * @author Sumanth Paranjape
 * @version 1.0
 */
public class StudentGrades extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultString = "";
		QuizDetailsDao quizDetails = new QuizDetailsDao();
		int quizId = Integer.parseInt(quizDetails.getQuizId(request.getParameter("quiz_title")));
		int studentId = Integer.parseInt(request.getParameter("student_id"));
		String result = null;
		
		try {
			StudentAttemptDao studentAttemptDao = new StudentAttemptDao();
			QuestionsDao questionsDao = new QuestionsDao();
			QuizAttempt quizAttempt = studentAttemptDao.getQuizAttempt(quizId, studentId);
			ArrayList<Question> answers = questionsDao.getQuestions(quizId);			
			result = studentAttemptDao.getResult(answers,quizAttempt.getResponse());
		}
		catch (Exception exc) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}	
		response.setContentType("text/plain");
		response.getWriter().write(result);
	}

}
