package content.creator.servlet;

import content.creator.helper.ViewContentListHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * Modified by: Archana Madhavan
 * Date: 23/2/19
 * Description: Fetches the quiz list and sends response to the view.
 *
 * */

@WebServlet(urlPatterns = "/quizList")
public class ViewContentListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Integer> quizId = ViewContentListHelper.getQuizList();
            request.setAttribute("quizIds", quizId);
            request.getRequestDispatcher("viewContentList.jsp").forward(request,response);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
