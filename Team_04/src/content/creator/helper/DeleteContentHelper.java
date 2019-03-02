package content.creator.helper;

//import static content.creator.operations.DataOps.getNamesFromProperty;
import content.creator.operations.DataOps;
import java.sql.SQLException;

public final class DeleteContentHelper {
    public DeleteContentHelper() {}

    public static void removeQuiz(int quizId) throws SQLException {
        String tabName = "quiz_content";//getNamesFromProperty("QUIZ_CONTENT_TABLE_NAME");
        int colName = quizId;
        String queryString = deleteQueryString(tabName, colName);
        DataOps.saveData(queryString);
    }

    private static String deleteQueryString(String tableName, int colName) {
        return String.format("DELETE FROM %s WHERE quizId = %d", tableName, colName);
    }
}
