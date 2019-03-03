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
import content.creator.helper.FetchQuestionHelper;
import content.creator.dao.QuizContentDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/modQues")

public class ModifyQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int quizId = Integer.parseInt(request.getParameter("quizid"));
            int quesId = Integer.parseInt(request.getParameter("quesid"));
            List<QuizContentDAO> result = FetchQuestionHelper.fetchQues(quizId, quesId);
            String question_text = result.get(0).getQuesDesc();
            int score = result.get(0).getMaxScore();
            List<String> option = new ArrayList<>();
            int choice = 1;
            for(int i = 0; i < 4; i++) {
                option.add(result.get(i).getAnsDesc());
                if(result.get(i).getCorrect()) {
                    choice = i;
                }
            }
            request.setAttribute("action", "Modify");
            request.setAttribute("quizid", quizId);
            request.setAttribute("quesid", quesId);
            request.setAttribute("question_text", question_text);
            request.setAttribute("choice", choice);
            request.setAttribute("option_a", option.get(0));
            request.setAttribute("option_b", option.get(1));
            request.setAttribute("option_c", option.get(2));
            request.setAttribute("option_d", option.get(3));
            request.setAttribute("score", score);
            request.getRequestDispatcher("./addContent.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
