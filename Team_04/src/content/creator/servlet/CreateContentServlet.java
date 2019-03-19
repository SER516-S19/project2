package content.creator.servlet;

import static content.creator.helper.CreateContentHelper.processPayload;
import static content.creator.helper.CreateContentHelper.saveDataToDb;

import com.google.gson.Gson;
import content.creator.dao.QuizFormDAO;
import content.creator.dao.QuizQuestionsDAO;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/create")
public class CreateContentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {




  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String responseRedirect = "./quizList";
    Gson gson = new Gson();
    String json = request.getParameter("data");
    QuizQuestionsDAO[] quizQuestions = gson.fromJson(json, QuizQuestionsDAO[].class);
    List<QuizFormDAO> quizFormList = processPayload(Arrays.asList(quizQuestions));
    try {
      for(QuizFormDAO quizForm: quizFormList) {
        saveDataToDb(
            quizForm.getQuizId(),
            quizForm.getQuestionId(),
            quizForm.getQuestionText(),
            quizForm.getAnswerBundle(),
            quizForm.getScore());
      }
    } catch (SQLException sqlEx) {
      System.out.println(sqlEx.getMessage());
      responseRedirect = "createContent.jsp";
    } finally {
      response.sendRedirect(responseRedirect);
    }
  }
}
