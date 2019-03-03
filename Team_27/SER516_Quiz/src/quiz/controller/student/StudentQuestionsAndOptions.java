package quiz.controller.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.dao.professor.QuizDetailsDao;
import quiz.dao.student.StudentQuizDao;
import quiz.exceptions.DataAccessException;
import quiz.model.student.QuizAttempt;

public class StudentQuestionsAndOptions extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set Content-Type and other response headers
		//response.setHeader("Cache-Control", "no-cache");
		//Needs to be done on the basis of quiz-id
				StudentQuizDao studentQuizDao = new StudentQuizDao();
				QuizDetailsDao quizDetails = new QuizDetailsDao();
				int quizId = Integer.parseInt(quizDetails.getQuizId(request.getParameter("quiz_title")));
				String jsonResponse = null;
				try {
					jsonResponse = studentQuizDao.getQuestionsAndOptions(quizId);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonResponse);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		System.out.println("Response from the client:"+req.getParameter("answers"));
		QuizDetailsDao quizDetails = new QuizDetailsDao();
		String quizId = quizDetails.getQuizId(req.getParameter("quiz_title"));
		
		QuizAttempt attempt = new QuizAttempt(1, 1, 1, req.getParameter("answers"));
		
		StudentQuizDao quizDetailsDao = new StudentQuizDao();
		try {
			quizDetailsDao.insert(attempt,quizId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setStatus(200);
	}
}
