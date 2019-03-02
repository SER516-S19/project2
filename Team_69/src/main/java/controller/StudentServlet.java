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

	/**
	 * Handles the get request coming to the student
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */

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

	/**
	 * Handles the post request going from student
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/error";
		String studentResponse = request.getParameter("data");
		String action = request.getParameter("action");
		StudentServices service = new StudentServices();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		try {
			if(action.equals("submit")) {
				response.setContentType("text/html");
				view = service.feedAnswers(studentResponse, userId);
				if ("/success".equals(view)) {
					int score = service.getGrade(studentResponse, userId);
					session.setAttribute("grade", score);
					response.setStatus(HttpServletResponse.SC_CREATED);
				}
				else
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				session.removeAttribute("data");
				request.getRequestDispatcher(view).forward(request, response);
			}else if(action.equals("save")) {
				session.setAttribute("data", studentResponse);
				if ("/success".equals(view))
					response.setStatus(HttpServletResponse.SC_OK);
				else
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} catch (Exception exception) {
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}

}