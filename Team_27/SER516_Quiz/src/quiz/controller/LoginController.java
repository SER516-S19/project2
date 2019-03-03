package quiz.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quiz.dao.UserDao;
import quiz.model.User;

/**
 * Controller to authenticate User credentials
 * 
 * @author Lakshmi Kala Pedarla
 * @version (1.0)
 */
@SuppressWarnings("serial")
@WebServlet(name = "LoginController", urlPatterns = { "/login" }, loadOnStartup = 1)
public class LoginController extends HttpServlet {

	private UserDao userDao = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userDao = new UserDao();
	}

	/**
	 * This method validates credentials provided by the user. Based on
	 * user_type(Student/professor) appropriate pages will be displayed.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");

		try {
			User user = userDao.findByUsername(username);

			if (password != null && password.equals(user.getPassword())) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("username", username);
				httpSession.setAttribute("userType", user.getUserType());

				if ("student".equalsIgnoreCase(user.getUserType())) {
					response.sendRedirect("./StudentHomePage.html");
				} else if("professor".equalsIgnoreCase(user.getUserType())){
					response.sendRedirect("showQuizes.jsp");
				}
				else {
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "This user doesn't belong to any type!");
				}

			} else {
				response.sendRedirect("./Register.jsp");
			}

		} catch (Exception exc) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}
	}
}
