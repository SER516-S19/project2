package content.creator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "ViewContentListServlet", urlPatterns = {"/viewContentList"})
public class ViewContentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FetchQuizData quizData=new FetchQuizData();
        List<Integer> quizId=quizData.getQuizList();
        request.setAttribute("ids",quizId);
        RequestDispatcher view = request.getRequestDispatcher("viewContentList.jsp");
        view.forward(request, response);
    }
}