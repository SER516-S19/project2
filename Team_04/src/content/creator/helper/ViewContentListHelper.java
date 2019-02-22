package content.creator.helper;

import content.creator.operations.DataOps;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** @author Hari Krishnan Puthiya Veetil */
public final class ViewContentListHelper {

    private ViewContentListHelper() {
    }

    public static List<Integer> getQuizList() {
        String tableName = "quiz_content";
        String colName = "quiz_id";
        List<Integer> list = new ArrayList<Integer>();
        String queryString = getQueryString(tableName, colName);
        try (ResultSet rs = DataOps.getData(queryString)) {
            while (rs.next()) {
                list.add(rs.getInt(colName));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    private static String getQueryString(String tableName, String colName) {
        return String.format("SELECT DISTINCT %s FROM %s", colName, tableName);
    }
}
