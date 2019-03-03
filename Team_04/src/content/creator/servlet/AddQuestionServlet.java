package content.creator.servlet;

/*
 * Modified by: Abhishek Gupta
 * Date: 2/28/19
 * Description: Delete an entire quiz.
 *
 * */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static content.creator.helper.CreateContentHelper.generateRandom;

@WebServlet(urlPatterns = "/addQues")

public class AddQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizid"));
        int quesId = generateRandom(1000, 9999);
        String action = "Add";
        request.setAttribute("action", action);
        request.setAttribute("quizid", quizId);
        request.setAttribute("quesid", quesId);
        request.setAttribute("question_text", "");
        request.setAttribute("choice", 1);
        request.setAttribute("option_a", "");
        request.setAttribute("option_b", "");
        request.setAttribute("option_c", "");
        request.setAttribute("option_d", "");
        request.setAttribute("score", "");
        request.getRequestDispatcher("./addContent.jsp").forward(request,response);
    }
}

