package content.creator.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import content.creator.helper.DeleteQuestionHelper;

/*
 * Modified by: Abhishek Gupta
 * Date: 2/28/19
 * Description: Delete an entire quiz.
 *
 * */

@WebServlet(urlPatterns = "/delQues")

public class DeleteQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int quizId = Integer.parseInt(request.getParameter("quizid"));
            int quesId = Integer.parseInt(request.getParameter("quesid"));
            DeleteQuestionHelper.removeQues(quizId, quesId);
            request.getRequestDispatcher("./viewContentDetails");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
