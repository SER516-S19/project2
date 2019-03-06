package content.creator.helper;

//import static content.creator.operations.DataOps.getNamesFromProperty;

import content.creator.constants.Constants;
import content.creator.dao.QuizContentDAO;
import content.creator.dao.QuizFormDAO;
import content.creator.dao.QuizQuestionsDAO;
import content.creator.operations.DataOps;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class CreateContentHelper {
  private CreateContentHelper() {}

  public static int generateRandom(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  public static void saveDataToDb(
      int quizId,
      int quesId,
      String questionText,
      Map<Integer, ArrayList<String>> answerBundle,
      String score)
      throws SQLException {
    for (Integer answerKey : answerBundle.keySet()) {
      QuizContentDAO quizContent = new QuizContentDAO();
      quizContent.setQuizId(quizId);
      quizContent.setQuesId(quesId);
      quizContent.setQuesType(null);
      quizContent.setQuesDesc(questionText);
      quizContent.setAnsId(answerKey);
      quizContent.setAnsDesc(answerBundle.get(answerKey).get(0));
      quizContent.setCorrect(Boolean.parseBoolean(answerBundle.get(answerKey).get(1)));
      quizContent.setMaxScore(Integer.parseInt(score));
      String queryString = convertToQueryString(quizContent);
      System.out.println(queryString);
      DataOps.saveData(queryString);
    }
  }

  private static String convertToQueryString(QuizContentDAO quizContent) {
    String tableName = "quiz_content";//getNamesFromProperty("QUIZ_CONTENT_TABLE_NAME");
    List<String> colNames = Constants.colNames;
    return String.format(
        "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES (%s, %s, '%s', '%s', %s, '%s', '%s', %s)",
        tableName,
        colNames.get(0),
        colNames.get(1),
        colNames.get(2),
        colNames.get(3),
        colNames.get(4),
        colNames.get(5),
        colNames.get(6),
        colNames.get(7),
        quizContent.getQuizId(),
        quizContent.getQuesId(),
        quizContent.getQuesType(),
        quizContent.getQuesDesc(),
        quizContent.getAnsId(),
        quizContent.getAnsDesc(),
        quizContent.getCorrect(),
        quizContent.getMaxScore());
  }

  public static List<QuizFormDAO> processPayload(List<QuizQuestionsDAO> quizQuestionsList) {
       List<QuizFormDAO> quizFormList = new ArrayList<>();
      int quizId = generateRandom(100, 999);
      for (QuizQuestionsDAO question: quizQuestionsList) {
        QuizFormDAO quizForm = new QuizFormDAO();
        quizForm.setScore(question.getScore());
        int choice = question.getChoice();
        quizForm.setQuestionText(question.getQuestion());
        quizForm.setQuizId(quizId);
        quizForm.setQuestionId(generateRandom(1000, 9999));
        Map<Integer, ArrayList<String>> answerBundle = new HashMap<>();
        answerBundle.put(generateRandom(10000, 99999), new ArrayList<>(Arrays.asList(question.getOptionA(),
                choice == 1 ? "true" : "false")));
        answerBundle.put(generateRandom(10000, 99999), new ArrayList<>(Arrays.asList(question.getOptionB(),
                choice == 2 ? "true" : "false")));
        answerBundle.put(generateRandom(10000, 99999), new ArrayList<>(Arrays.asList(question.getOptionC(),
                choice == 3 ? "true" : "false")));
        answerBundle.put(generateRandom(10000, 99999), new ArrayList<>(Arrays.asList(question.getOptionD(),
                choice == 4 ? "true" : "false")));
        quizForm.setAnswerBundle(answerBundle);
        quizFormList.add(quizForm);
      }
      return quizFormList;
  }
}
