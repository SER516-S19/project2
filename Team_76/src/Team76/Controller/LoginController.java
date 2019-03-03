package Team76.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Team76.Entity.UserEntity;
import Team76.Utilities.UserValidation;

/**
 * @author aravind
 * @version 2.0
 * 
 *          Servlet implementation class Login-Logout operations.
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String action = request.getParameter("action");
			if (action == null || action.isEmpty()) {
				response.sendRedirect("Login.jsp");
			} else if (action.equalsIgnoreCase("login")) {
				String uName = (String) request.getParameter("uName");
				String password = (String) request.getParameter("password");
				if ((uName == null || uName.isEmpty()) && (password == null || password.isEmpty())) {
					response.getWriter().println("<font color=red>Please enter your proper credentials.</font>");
					response.sendRedirect("Login.jsp");
				}
				UserEntity user = new UserEntity();
				user.setUserName(uName);
				user.setPassword(password);
				if (UserValidation.validateUser(user)) {
					if (user.getUserType().equalsIgnoreCase("Professor")) {
						response.sendRedirect("ProfessorDash.jsp");
					} else {
						response.sendRedirect("StudentDash.jsp");
					}
				} else {
					response.getWriter().println("<font color=red>Either user name or password is wrong.</font>");
					response.sendRedirect("Login.jsp");
				}
				request.getSession().setAttribute("user", user);

				request.getSession().setAttribute("validSession", "true");
				request.getSession().setAttribute("uName", request.getParameter("uName"));
			} else if (action.equalsIgnoreCase("logoff")) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Cache-Control", "no-store");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);
				response.getWriter().println("<font color=red>Logged off successfully.</font>");
				response.sendRedirect("Login.jsp");
			} else {
				response.getWriter().println("<font color=red>Something went wrong please login again.</font>");
				response.sendRedirect("Login.jsp");
			}
		} catch (Exception e) {
			response.getWriter().println("<font color=red>An Exception occured.</font>");
			response.sendRedirect("Login.jsp");
		}
	}
}
