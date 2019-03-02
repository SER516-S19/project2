package content.creator.helper;

import content.creator.dao.QuizResultsDAO;
import content.creator.operations.DataOps;
import java.util.List;
import java.sql.SQLException;


public class ViewStudentDetailsHelper {

    public static List<QuizResultsDAO> getStudentDetails(int studentId) throws SQLException {
        String queryString = getStudentContentQuery(studentId);
        return DataOps.getDataQuesResponse(queryString);
    }

    private static String getStudentContentQuery(int studentId) {
        String COL_NAME = "studentId";
        return String.format("SELECT * FROM quiz_result WHERE %s = %s", COL_NAME, studentId);
    }
}
