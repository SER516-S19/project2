package content.creator.helper;

import static content.creator.operations.DataOps.getNamesFromProperty;
import content.creator.operations.DataOps;
import java.sql.SQLException;
import content.creator.dao.QuizContentDAO;
import java.util.List;


public final class FetchQuestionHelper {
    public FetchQuestionHelper() {}

    public static List fetchQues(int quizId, int quesId) throws SQLException {
        String tabName = getNamesFromProperty("QUIZ_CONTENT_TABLE_NAME");
        int colName = quizId;
        int row1Name = quesId;
        String queryString = fetchQuesQueryString(tabName, colName, row1Name);
        List<QuizContentDAO> result = DataOps.getDataCreateContent(queryString);
        return result;
    }

    private static String fetchQuesQueryString(String tableName, int colName, int row1Name) {
        return String.format("SELECT * FROM %s WHERE quizId = %d AND quesId = %d", tableName, colName, row1Name);
    }
}