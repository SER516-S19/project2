package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.StatisticServices;
import java.io.IOException;

public class StatisticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String flag = request.getParameter("flag");
    	if("quizStats".equals(flag)) {
			String quizID = request.getParameter("id");
			int quizId = Integer.parseInt(quizID);
			StatisticServices statisticServices = new StatisticServices();
			request.setAttribute("professorStatistics", statisticServices.getQuizStatistics(quizId));
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/statistics.jsp");
			rd.forward(request, response);
			
		}
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
        response.sendError(501,"Method not supported yet");

    }


}
