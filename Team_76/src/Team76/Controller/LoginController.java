package Team76.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
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
			if (uName.equals("student") && password.equals("123")) {
				response.sendRedirect("StudentDash.jsp");
			} else if (uName.equals("prof") && password.equals("123")) {
				response.sendRedirect("ProfessorDash.jsp");
			} else {
				response.getWriter().println("<font color=red>Either user name or password is wrong.</font>");
				response.sendRedirect("Login.jsp");
			}
			request.getSession().setAttribute("uName", uName);

			request.getSession().setAttribute("validSession", "true");
			request.getSession().setAttribute("uName", request.getParameter("uName"));
		} else if (action.equalsIgnoreCase("logoff")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			response.getWriter().println("<font color=red>Logged off successfully.</font>");
			response.sendRedirect("Login.jsp");
		} else {
			response.getWriter().println("<font color=red>Something went wrong please login again.</font>");
			response.sendRedirect("Login.jsp");
		}
	}

}
