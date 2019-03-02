package content.creator.servlet;

import content.creator.helper.DeleteContentHelper;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * Modified by: Abhishek Gupta
 * Date: 2/27/19
 * Description: Delete an entire quiz.
 *
 * */

@WebServlet(urlPatterns = "/delete")
public class DeleteContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int quizId = Integer.parseInt(request.getParameter("quizid"));
            DeleteContentHelper.removeQuiz(quizId);
            request.getRequestDispatcher("./list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




