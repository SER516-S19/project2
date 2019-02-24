package content.creator.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import content.creator.helper.ViewContentListHelper;

/*
* @author Archana Madhavan
*/
@WebServlet(urlPatterns = "/list")
public class ViewContentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      try {
        List<Integer> quizId = ViewContentListHelper.getQuizList();
        System.out.println(quizId.size());
        request.setAttribute("ids", quizId);
        request.getRequestDispatcher("viewContentList.jsp").forward(request,response);
        }
      catch (SQLException e) {
        e.printStackTrace();
      }
    }
}