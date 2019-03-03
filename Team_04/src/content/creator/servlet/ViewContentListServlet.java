package content.creator.servlet;

import content.creator.helper.ViewContentListHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/list")
public class ViewContentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Integer> quizId = ViewContentListHelper.getQuizList();
            request.setAttribute("ids", quizId);
            request.getRequestDispatcher("viewContentList.jsp").forward(request,response);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
