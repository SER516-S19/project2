package controller;

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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String queryParams = req.getQueryString();
		String quizId = queryParams.split("=")[1];
		StudentServices service = new StudentServices();
		String questionAnswerJSON = service.getQuestionDetails(Integer.parseInt(quizId));
		HttpSession session = req.getSession();
		session.setAttribute("studentResponseJSON", questionAnswerJSON);
		session.setAttribute("startTime", service.getCurrentDateTime());
		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_OK);
		req.getRequestDispatcher("/views/student.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/error";
		String studentResponse = request.getParameter("data");
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