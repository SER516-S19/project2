package content.creator.helper;

//import static content.creator.operations.DataOps.getNamesFromProperty;
import static java.lang.System.getProperties;

import DBUtil.DbHelper;
import content.creator.dao.QuizResultDAO;
import content.creator.operations.DataOps;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * This class has the business logic for displaying statistics for quiz.
 *
 * @author Pallavi Bahl
 */
public class StatsPerQuizHelper {

  private StatsPerQuizHelper() {}

  /**
   * This method returns the average score of the quiz passed as a parameter.
   *
   * @param quizId
   * @return
   * @throws SQLException
   */
  public static float getClassAverage(int quizId) throws SQLException {
    List<QuizResultDAO> scoreOfAllStudents = getScoreOfAllStudents(quizId);
    int studentCount = scoreOfAllStudents.size();
    int totScoreOfAllStudents = 0;
    for (QuizResultDAO studentScore : scoreOfAllStudents) {
      totScoreOfAllStudents += studentScore.getFinalScore();
    }
    float averageQuizScore;
    try {
      averageQuizScore =  Float.parseFloat(String.valueOf(totScoreOfAllStudents / studentCount));
    } catch (ArithmeticException aE) {
      averageQuizScore = (float) 0;
    }
    return averageQuizScore;
  }

<<<<<<< HEAD
  public static int getStudentStrengthForQuiz(int quizId) throws SQLException {
    List<QuizResultDAO> scoreOfAllStudents = getScoreOfAllStudents(quizId);
    return scoreOfAllStudents.size();
  }

  //    public static float getAverageNumOfQuesAttempted(int quizId)
  //    {
  //        getQueryForQuesAttempted
  //    }

  private static List<QuizResultDAO> getScoreOfAllStudents(int quizId) throws SQLException {
    String queryString = getQueryForStudentScore(quizId);
    return DataOps.getDataQuizResult(queryString);
  }

  private static String getQueryForStudentScore(int quizId) {
    String colName = getNamesFromProperty("QUIZ_RESULT_QUIZ_ID_COL_NAME");
    String tableName = getNamesFromProperty("QUIZ_RESULT_TABLE_NAME");
    return String.format("SELECT * FROM %s WHERE %s = %s", tableName, colName, quizId);
  }

  private static String getQueryForQuesAttempted(int quizId) {
    String colName = getNamesFromProperty("QUES_RESPONSE_QUIZ_ID_COL_NAME");
    String tableName = getNamesFromProperty("QUES_RESPONSE_TABLE_NAME");
    return String.format("SELECT * FROM %s WHERE %s = %s", tableName, colName, quizId);
=======
    /**
     * This method returns the highest score for the quiz passed as a parameter
     * @param quizId
     * @return
     * @throws SQLException
     */
    public static float getHighestScoreForQuiz(int quizId) throws SQLException {
      List<QuizResultDAO> quizResultDAO = getScoreOfAllStudents(quizId);
      if(quizResultDAO.isEmpty())
        return 0;
      else {
        float maxScore = quizResultDAO.get(0).getFinalScore();
        for (QuizResultDAO quizResultRow : quizResultDAO) {
          float score = quizResultRow.getFinalScore();
          if (score > maxScore)
            maxScore = score;
        }
        return maxScore;
      }
    }
    private static List<QuizResultDAO> getScoreOfAllStudents(int quizId) throws SQLException {
      String queryString = "quizId";//getQueryForStudentScore(quizId);
      return DataOps.getDataQuizResult(queryString);
    }

    private static String getQueryForStudentScore(int quizId) {
      String colName = "ques_response";//getNamesFromProperty("QUIZ_RESULT_QUIZ_ID_COL_NAME");
      String tableName = "ques_response";//getNamesFromProperty("QUIZ_RESULT_TABLE_NAME");
      return String.format("SELECT * FROM %s WHERE %s = %s", tableName, colName, quizId);
    }
>>>>>>> parent of 72b2cc1f... Revert.
  }
}
