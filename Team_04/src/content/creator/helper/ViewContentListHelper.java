package content.creator.helper;

import static content.creator.operations.DataOps.getNamesFromProperty;

import content.creator.dao.QuizContentDAO;
import content.creator.operations.DataOps;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** @author Hari Krishnan Puthiya Veetil */
public final class ViewContentListHelper {

    private ViewContentListHelper() {
    }

    public static List<Integer> getQuizList() throws SQLException {
        String tableName = getNamesFromProperty("QUIZ_CONTENT_TABLE_NAME");
        String colName = getNamesFromProperty("QUIZ_CONTENT_QUIZ_ID_COL_NAME");
        List<Integer> list = new ArrayList<>();
        String queryString = getQueryString(tableName, colName);
        List<QuizContentDAO> data = DataOps.getDataCreateContent(queryString);
        for (QuizContentDAO content: data) {
            list.add(content.getQuizId());
        }
        return list;
    }

    private static String getQueryString(String tableName, String colName) {
        return String.format("SELECT DISTINCT %s FROM %s", colName, tableName);
    }
}
