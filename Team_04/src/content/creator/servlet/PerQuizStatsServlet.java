package content.creator.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static content.creator.helper.StatsPerQuizHelper.*;

@WebServlet(urlPatterns = "/quizstats")
public class PerQuizStatsServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException {
    float classAvg = (float) -1.0;
    int studentStrength = 0;
    float highestScore = 0;
    int quizId = Integer.parseInt(request.getParameter("quizid"));
    try {
     classAvg = getClassAverage(quizId);
     studentStrength = getStudentStrengthForQuiz(quizId);
     highestScore = getHighestScoreForQuiz(quizId);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      request.setAttribute("classavg", classAvg);
      request.setAttribute("studentStrength", studentStrength);
      request.setAttribute("highestScore", highestScore);
      request.setAttribute("quizId",quizId);
      request.getRequestDispatcher("viewPerQuizStats.jsp").forward(request,response);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
