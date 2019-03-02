package content.creator.helper;

//import static content.creator.operations.DataOps.getNamesFromProperty;
import content.creator.operations.DataOps;
import java.sql.SQLException;

public final class ModifyQuestionHelper {
    public ModifyQuestionHelper() {}

    public static void modifyQues(int quizId, int quesId) throws SQLException {
        String tabName = "quiz_content";//getNamesFromProperty("QUIZ_CONTENT_TABLE_NAME");
        int colName = quizId;
        int col2Name = quesId;
        String queryString = modQuesQueryString(tabName, colName, col2Name);
        DataOps.saveData(queryString);
    }

    private static String modQuesQueryString(String tableName, int colName, int col2Name) {
        return String.format("UPDATE %s SET  WHERE quizId = %d AND quesId = %d", tableName, colName, col2Name);
    }
}