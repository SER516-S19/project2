package content.creator.servlet;

import content.creator.dao.QuizResultDAO;
import content.creator.helper.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/*
 *Modified by :Sakshi Gautam
 *Date: 30/2/19
 *Description: fetches a list of student IDs and dispatches to the view.
 */

@WebServlet(urlPatterns = "/viewStudentDetails")
public class viewStudentDetailsServlet extends HttpServlet {
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try{
                Integer studentNumber=Integer.parseInt(request.getParameter("studentId"));
                List<QuizResultDAO> studentDetailsList= ViewStudentDetailsHelper.getStudentDetails(studentNumber);
                request.setAttribute("studentDetails",studentDetailsList);
                request.setAttribute("totalQuizzes",studentDetailsList.size());
                request.setAttribute("score",StatsPerStudentHelper.getTotalScore(studentDetailsList));
                request.getRequestDispatcher("viewStudentDetails.jsp").forward(request,response);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



