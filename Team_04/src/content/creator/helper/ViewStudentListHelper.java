package content.creator.helper;

import content.creator.dao.QuizResultsDAO;
import content.creator.operations.DataOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ViewStudentListHelper {


        public static List<Integer> getStudentList() throws SQLException {
            String tableName = "quiz_result";
            String colName = "studentId";
            List<Integer> studentList = new ArrayList<>();
            String queryString = getQueryString(tableName, colName);
            List<QuizResultsDAO> data = DataOps.getDataQuizResult(queryString);
            for (QuizResultsDAO content: data) {
                studentList.add(content.getStudentId());
            }
            return studentList;
        }

        private static String getQueryString(String tableName, String colName) {
            return String.format("SELECT DISTINCT %s FROM %s", colName, tableName);
        }
}

