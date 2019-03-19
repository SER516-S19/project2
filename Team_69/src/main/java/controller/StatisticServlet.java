package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.StatisticServices;
import java.io.IOException;

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
