package content.creator.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import content.creator.dao.QuizFormDAO;
import static content.creator.helper.CreateContentHelper.generateRandom;
import static content.creator.helper.CreateContentHelper.saveDataToDb;

@WebServlet(urlPatterns = "/ques")
public class QuestionStreamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int quizId = Integer.parseInt(request.getParameter("quizid"));
        int quesId = Integer.parseInt(request.getParameter("quesid"));
        QuizFormDAO quiz = new QuizFormDAO();
        quiz.setScore(request.getParameter("score"));
        String correct = request.getParameter("choice");
        quiz.setQuestionText(request.getParameter("question_text"));
        quiz.setQuizId(quizId);
        quiz.setQuestionId(quesId);
        Map<Integer, ArrayList<String>> answerSet = new HashMap<>();
        for (int j = 1; j <= 4; j++) {
            ArrayList<String> ans = new ArrayList<>();
            String aChoice = request.getParameter(String.format("%s", j));
            ans.add(aChoice);
            String i = Integer.toString(j);
            if (correct.equals(i)) {
                ans.add("true");
            } else {
                ans.add("false");
            }
            int ansId = generateRandom(10000, 99999);
            answerSet.put(ansId, ans);
        }
        quiz.setAnswerBundle(answerSet);

        try {
            saveDataToDb(
                    quiz.getQuizId(),
                    quiz.getQuestionId(),
                    quiz.getQuestionText(),
                    quiz.getAnswerBundle(),
                    quiz.getScore()
            );
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        } finally {
            response.sendRedirect("./viewContentDetails?quizId=" + quizId);
        }
    }
}