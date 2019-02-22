package controller;

import dao.QuizDAO;
import services.StudentServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Controller class for student page
 * 
 * @author : Sourabh Siddharth
 * @version : 1.0
 * @since : 02/16/2019
 * 
 */
public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String queryParams = req.getQueryString();
		String quizName = queryParams.split("=")[1];
		QuizDAO quizDAO = new QuizDAO();
		int quizId = quizDAO.fetchQuizId(quizName);
		StudentServices service = new StudentServices();
		String questionAnswerJSON = service.getQuestionDetails(quizId);
		HttpSession session = req.getSession();
		session.setAttribute("studentResponseJSON", questionAnswerJSON);
		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_OK);
		req.getRequestDispatcher("/views/student.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/error";
		HttpSession session = request.getSession();
		//String studentResponse = (String) session.getAttribute("studentResponseJSON");
		String studentResponse = "{\"quizId\":1,\"quizName\":\"Quiz1\",\"quizInstructions\":\"Read\",\"quizType\":\"Graded\",\"quizTimeLimit\":\"12:30:00 AM\",\"isShuffled\":true,\"isPublished\":false,\"question\":[{\"questionId\":3,\"question\":\"Question3\",\"correctAnswerId\":0,\"isMultiple\":true,\"responseAnswer\":[{\"answerId\":19,\"answer\":\"some answer\",\"correctAnswer\":\"correct answer\"},{\"answerId\":16,\"answer\":\"some answer\",\"correctAnswer\":\"correct answer\"}],\"availableAnswers\":[{\"answerId\":19,\"answer\":\"some answer\",\"correctAnswer\":\"correct answer\"},{\"answerId\":16,\"answer\":\"some answer\",\"correctAnswer\":\"correct answer\"},{\"answerId\":169,\"answer\":\"some answer\",\"correctAnswer\":\"correct answer\"},{\"answerId\":9869,\"answer\":\"some answer\",\"correctAnswer\":\"correct answer\"}],\"points\":10},{\"questionId\":4,\"question\":\"Question4\",\"correctAnswerId\":0,\"isMultiple\":true,\"responseAnswer\":null,\"availableAnswers\":[],\"points\":10}]}";
		System.out.print(studentResponse);
		StudentServices service = new StudentServices();
		try {
			view = service.feedAnswers(studentResponse);
			response.setContentType("text/html");
			if ("/success".equals(view))
				response.setStatus(HttpServletResponse.SC_CREATED);
			else
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			request.getRequestDispatcher(view).forward(request, response);
		} catch (Exception exception) {
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}

}