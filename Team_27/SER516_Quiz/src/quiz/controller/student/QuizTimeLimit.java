package quiz.controller.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.dao.professor.QuizDetailsDao;

public class QuizTimeLimit extends HttpServlet{


	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set Content-Type and other response headers
		//response.setHeader("Cache-Control", "no-cache");
		String timeLimit = "";
		
		try {
			QuizDetailsDao quizDetailsDao = new QuizDetailsDao();
			timeLimit = quizDetailsDao.getTimeLimit(request.getParameter("quiz_title"));
			/*for(String quiz : quizes) {
				resultString += quiz + " ";
			} */
		}
		catch (Exception exc) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}	
		
		response.setContentType("text/plain");
		response.getWriter().write(timeLimit);
	}


}
