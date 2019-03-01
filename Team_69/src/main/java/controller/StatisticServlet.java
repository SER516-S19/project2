package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatisticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String flag = request.getParameter("flag");
    	if("quizStats".equals(flag)) {
			String quizID = request.getParameter("id");
			int quizId = Integer.parseInt(quizID);
			response.sendRedirect(request.getContextPath()+"/views/stats.jsp");
		}
    	
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
        response.sendError(501,"Method not supported yet");

    }


}
