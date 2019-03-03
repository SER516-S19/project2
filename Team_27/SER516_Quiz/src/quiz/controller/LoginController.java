package quiz.controller;

<<<<<<< HEAD
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quiz.dao.login.LoginDao;
import quiz.model.login.Login;

/**
 * Controller to authenticate User credentials
 * 
 * @author Lakshmi Kala Pedarla
 * @version (1.0)
 */
@SuppressWarnings("serial")
@WebServlet(name = "LoginController", urlPatterns = { "/login" }, loadOnStartup = 1)
public class LoginController extends HttpServlet {

	private LoginDao loginDao = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		loginDao = new LoginDao();
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
			Login login = loginDao.findByUsername(username);

			if (password != null && password.equals(login.getPassword())) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("username", username);
				httpSession.setAttribute("userType", login.getUsertype());

				if ("student".equalsIgnoreCase(login.getUsertype())) {
					response.sendRedirect("./StudentHomePage.html");
				} else {
					response.sendRedirect("/Quiz/getQuiz");
				}

			} else {
				response.sendRedirect("./index.html");
			}

		} catch (Exception exc) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}
	}
=======
public class LoginController {
>>>>>>> Team_58

}
