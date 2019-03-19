package content.creator.helper;

import static content.creator.operations.DataOps.getNamesFromProperty;

import content.creator.dao.QuizContentDAO;
import content.creator.operations.DataOps;

import java.sql.SQLException;
import java.util.List;

public final class ViewContentDetailsHelper {

	public static List<QuizContentDAO> getQuizContent(int quizId) throws SQLException {
		String queryString = getContentQuery(quizId);
		return DataOps.getDataCreateContent(queryString);
	}

	private static String getContentQuery(int quizId) {
		String colName = getNamesFromProperty("QUIZ_CONTENT_QUIZ_ID_COL_NAME");
		return String.format("SELECT * FROM quiz_content WHERE %s = %s", colName, quizId);
	}
}
