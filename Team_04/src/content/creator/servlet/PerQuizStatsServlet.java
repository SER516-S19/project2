package content.creator.servlet;

import static content.creator.helper.StatsPerQuizHelper.getClassAverage;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/quizstats")
public class PerQuizStatsServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException {
    float classAvg = (float) -1.0;
    int quizId = Integer.parseInt(request.getParameter("quizid"));
    try {
     classAvg = getClassAverage(quizId);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      request.setAttribute("classavg", classAvg);
      request.getRequestDispatcher("viewPerQuizStats.jsp").forward(request,response);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
