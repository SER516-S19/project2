package content.creator.helper;

import static content.creator.operations.DataOps.getNamesFromProperty;
import content.creator.operations.DataOps;
import java.sql.SQLException;

public final class DeleteQuestionHelper {
    public DeleteQuestionHelper() {}

    public static void removeQues(int quizId, int quesId) throws SQLException {
        String tabName = getNamesFromProperty("QUIZ_CONTENT_TABLE_NAME");
        int colName = quizId;
        int row1Name = quesId;
        String queryString = delQuesQueryString(tabName, colName, row1Name);
        DataOps.saveData(queryString);
    }

    private static String delQuesQueryString(String tableName, int colName, int row1Name) {
        return String.format("DELETE FROM %s WHERE quizId = %d AND quesId = %d", tableName, colName, row1Name);
    }
}