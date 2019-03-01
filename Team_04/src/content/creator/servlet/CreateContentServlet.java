package content.creator.servlet;

import static content.creator.helper.CreateContentHelper.generateRandom;
import static content.creator.helper.CreateContentHelper.saveDataToDb;

import content.creator.dao.QuizFormDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import content.creator.dao.QuizQuestionsDAO;

@WebServlet(urlPatterns = "/create")
public class CreateContentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String responseRedirect = "./list";
    List<QuizFormDAO> quizFormList = new ArrayList<>();
    int FORM_LENGTH = 3;
    int NUM_ANS = 4;
    int quizId = generateRandom(100, 999);
    for (int p = 1; p <= FORM_LENGTH; p++) {
      QuizFormDAO quizForm = new QuizFormDAO();
      quizForm.setScore(request.getParameter(String.format("score_%s", p)));
      String isCorrect = request.getParameter(String.format("choice_%s", p));
      quizForm.setQuestionText(request.getParameter(String.format("question_text_%s", p)));
      quizForm.setQuizId(quizId);
      quizForm.setQuestionId(generateRandom(1000, 9999));
      Map<Integer, ArrayList<String>> answerBundle = new HashMap<>();
      for (int i = 1; i <= NUM_ANS; i++) {
        ArrayList<String> ansList = new ArrayList<>();
        String ansChoice = request.getParameter(String.format("%s_%s", i, p));
        ansList.add(ansChoice);
        if (isCorrect.equals(Integer.toString(i))) {
          ansList.add("true");
        } else {
          ansList.add("false");
        }
        int ansId = generateRandom(10000, 99999);
        answerBundle.put(ansId, ansList);
      }
      quizForm.setAnswerBundle(answerBundle);
      quizFormList.add(quizForm);
    }

    try {
      for (int p = 0; p < FORM_LENGTH; p++) {
        saveDataToDb(
            quizFormList.get(p).getQuizId(),
            quizFormList.get(p).getQuestionId(),
            quizFormList.get(p).getQuestionText(),
            quizFormList.get(p).getAnswerBundle(),
            quizFormList.get(p).getScore());
      }
    } catch (SQLException sqlEx) {
      System.out.println(sqlEx.getMessage());
      responseRedirect = "createContent.jsp";
    } finally {
      response.sendRedirect(responseRedirect);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	    Gson gson = new Gson();
    	String json = request.getParameter("test");
    	System.out.println(json);
    	QuizQuestionsDAO[] QuizQuestions = gson.fromJson(json, QuizQuestionsDAO[].class);

      }
}
