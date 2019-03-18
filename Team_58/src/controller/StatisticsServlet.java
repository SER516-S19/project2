package controller;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class CourseDashboardServlet is a controller 
 * that routes the User to Course Dashboard Page from Professor Home Page.
 * 
 * @author narenkumarKonchada
 * @author shivamverma
 * @version 1.5
 * @date 03/14/2019
 */
public class StatisticsServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(ProfessorHomeServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.sendRedirect(req.getContextPath() + "/statistics.jsp");
	}
}
