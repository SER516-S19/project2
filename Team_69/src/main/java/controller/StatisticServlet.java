package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.StatisticServices;
import java.io.IOException;

/**
 * This is the controller for retrieving quiz statistic of the students
 *
 * @authors Jinal Patel
 * @version 1.0
 * @since : 03/01/2019
 */
@SuppressWarnings("serial")
public class StatisticServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StatisticServices statisticServices = new StatisticServices();
		String flag = request.getParameter("flag");
		if ("quizStats".equals(flag)) {
			String quizID = request.getParameter("id");
			int quizId = Integer.parseInt(quizID);
			statisticServices = new StatisticServices();
			request.setAttribute("professorStatistics", statisticServices.getQuizStatistics(quizId));
			getServletContext().getRequestDispatcher("/views/statistics.jsp").forward(request, response);
		}
	}
}