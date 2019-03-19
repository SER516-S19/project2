package content.creator.helper;
import content.creator.dao.QuizResultDAO;
import content.creator.operations.DataOps;
import java.util.List;
import java.sql.SQLException;
/*
 *@author Sakshi Gautam
 *@version 1.4
 *@since   2019-03-01
 *Description: fetches the student details for every student id.
 */

public class ViewStudentDetailsHelper {

    public static List<QuizResultDAO> getStudentDetails(int studentId) throws SQLException {
        String queryString = getStudentContentQuery(studentId);
        return DataOps.getDataQuizResult(queryString);
    }



    private static String getStudentContentQuery(int studentId) {
        String COL_NAME = "studentId";
        return String.format("SELECT * FROM quiz_result WHERE %s = %s", COL_NAME, studentId);
    }
}
