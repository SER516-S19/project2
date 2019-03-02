package content.creator.servlet;

/*
 * Modified by: Abhishek Gupta
 * Date: 2/28/19
 * Description: Delete an entire quiz.
 *
 * */

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import content.creator.helper.ModifyQuestionHelper;

@WebServlet(urlPatterns = "/modQues")

public class ModifyQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int quizId = Integer.parseInt(request.getParameter("quizid"));
            int quesId = Integer.parseInt(request.getParameter("quesid"));

            ModifyQuestionHelper.modifyQues(quizId, quesId);
            request.getRequestDispatcher("./viewContentDetails");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
