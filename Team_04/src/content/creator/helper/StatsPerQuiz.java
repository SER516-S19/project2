package content.creator.helper;
import content.creator.dao.QuizResultDAO;
import content.creator.operations.DataOps;
import java.sql.SQLException;
import java.util.List;

/**
 * This class has the business logic for displaying statistics for quiz.
 * @author Pallavi Bahl
 */
public class StatsPerQuiz {

    private StatsPerQuiz(){}

    /**
     * This method returns the average score of the quiz passed as a parameter.
     * @param quizId
     * @return
     * @throws SQLException
     */
    public static float getClassAverage(int quizId) throws SQLException {
        List<QuizResultDAO> scoreOfAllStudents = getScoreOfAllStudents(quizId);
        int studentCount =  scoreOfAllStudents.size();
        int totScoreOfAllStudents = 0;
        for (QuizResultDAO studentScore : scoreOfAllStudents) {
            totScoreOfAllStudents += studentScore.getFinalScore();
        }
        float averageQuizScore = totScoreOfAllStudents/studentCount;
        return averageQuizScore;
    }

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
        String COL_NAME = "quizId";
        String TABLE_NAME = "quiz_result";
        return String.format("SELECT * FROM %s WHERE %s = %s", TABLE_NAME,COL_NAME, quizId);
    }

    private static String getQueryForQuesAttempted(int quizId) {
        String COL_NAME = "quizId";
        String TABLE_NAME = "quiz_response";
        return String.format("SELECT * FROM %s WHERE %s = %s", TABLE_NAME,COL_NAME, quizId);
    }


}
