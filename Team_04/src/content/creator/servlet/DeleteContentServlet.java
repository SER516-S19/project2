package content.creator.servlet;

import content.creator.helper.DeleteContentHelper;

import java.io.IOException;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int quizId = Integer.parseInt(request.getParameter("quizid"));
            DeleteContentHelper.removeQuiz(quizId);
            response.sendRedirect("./list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




