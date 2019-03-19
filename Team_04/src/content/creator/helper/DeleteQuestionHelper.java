package content.creator.helper;

import static content.creator.operations.DataOps.getNamesFromProperty;
import content.creator.operations.DataOps;
import java.sql.SQLException;

public final class DeleteQuestionHelper {

	public static void removeQues(int quizId, int quesId) throws SQLException {
		String tabName = getNamesFromProperty("QUIZ_CONTENT_TABLE_NAME");
		int column = quizId;
		int row = quesId;
		String queryString = delQuesQueryString(tabName, column, row);
		DataOps.saveData(queryString);
	}

	private static String delQuesQueryString(String tableName, int column, int row) {
		return String.format("DELETE FROM %s WHERE quizId = %d AND quesId = %d", tableName, column, row);
	}
}