package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import java.io.IOException;

public class StatisticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
        resp.sendError(501,"Method not implemented yet");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
        response.sendError(501,"Method not supported yet");

    }


=======
>>>>>>> origin/master
import services.StatisticServices;
import java.io.IOException;

@SuppressWarnings("serial")
public class StatisticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	StatisticServices statisticServices = new StatisticServices();
    	String flag = request.getParameter("flag");
    	if("quizStats".equals(flag)) {
			String quizID = request.getParameter("id");
			int quizId = Integer.parseInt(quizID);
			statisticServices = new StatisticServices();
			request.setAttribute("professorStatistics", statisticServices.getQuizStatistics(quizId));
			getServletContext().getRequestDispatcher("/views/statistics.jsp").forward(request, response);
		}
    }
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
}
