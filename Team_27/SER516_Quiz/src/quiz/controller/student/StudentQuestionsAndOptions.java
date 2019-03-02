package quiz.controller.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.dao.student.StudentQuizDao;
import quiz.exceptions.DataAccessException;

public class StudentQuestionsAndOptions extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set Content-Type and other response headers
		//response.setHeader("Cache-Control", "no-cache");
		//Needs to be done on the basis of quiz-id
		StudentQuizDao studentQuizDao = new StudentQuizDao();
		String jsonResponse = null;
		try {
			jsonResponse = studentQuizDao.getQuestionsAndOptions();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonResponse);
	}
}
