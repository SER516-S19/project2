package quiz.controller.professor;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import quiz.dao.professor.QuestionsDao;
import quiz.model.professor.Question;

/**
 * Controller to add questions along with the specific parameters.
 * This controller will take input from user and prepare the question
 * model.
 * 
 * @author Sarthak Tiwari
 * @version (1.0)
 */

@SuppressWarnings("serial")
public class UpdateQuestionsInQuiz extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html");

		try {
			String quizId = request.getSession().getAttribute("quizId").toString();
			
			ArrayList questions = new ArrayList<Question>();
			
			questions = QuestionsDao.getQuestions(Integer.parseInt(quizId));

			request.getSession().setAttribute("questions", questions);
			response.sendRedirect("UpdateQuestionsInQuiz.jsp");
			
		} catch (Exception exc) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}