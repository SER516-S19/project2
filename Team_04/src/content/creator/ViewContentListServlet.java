package content.creator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ViewContentListServlet")
public class ViewContentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ContentList content=new ContentList();
        content.setQuestion_id(1);
        content.setQuestion_type("MAQ");
        content.setQuestion_description("Which is not a step of requirement engineering ?");
        content.setAns_description("Requirement Design");
        content.setCorrect(true);

        request.setAttribute("question",content);
        RequestDispatcher view = request.getRequestDispatcher("viewContentList.jsp");
        view.forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
