package content.creator.helper;
import content.creator.helper.CreateContentHelper;
import content.creator.operations.DataOps;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** @author Sai Vinay */
public final class ViewContentDetailsHelper {

    private ViewContentDetailsHelper() {
    }

    public static List<String> getQuizDetails(int id) {
        String tableName = "quiz_content";
        String colName1 = "ques_desc";
        String colName2 = "ans_desc";
        String colName3 = "max_score";
        List<String> list = new ArrayList<String>;
        String queryString = getQueryString(tableName, colName1, colName2, colName3);
        ResultSet rs = DataOps.getData(queryString);
        while (rs.next()) {
            list.add(rs.getString(colName1));
            list.add(rs.getString(colName2));
            list.add(rs.getString(colName3));
        }
        return list;
    }

    private static String getQueryString(String tableName, String  colName1,String colName2,String colName3) {
        return String.format("SELECT  %s,%s,%s FROM %s WHERE quiz_id="+id, colName1, colName2, colName3, tableName);
    }
