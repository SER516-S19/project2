package content.creator.helper;

import content.creator.dao.QuizContentDAO;
import content.creator.operations.DataOps;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewContentDetailsHelper {
    private ViewContentDetailsHelper() {
    }

    public static ArrayList<QuizContentDAO> getQuizContent() throws SQLException {
        ArrayList<QuizContentDAO> list = new ArrayList<>();
        String queryString = getContentQuery();
        ResultSet rs = DataOps.getData(queryString);
        List<String> colNames =
                Arrays.asList(
                        "quiz_id",
                        "ques_id",
                        "ques_type",
                        "ques_desc",
                        "ans_id",
                        "ans_desc",
                        "is_correct",
                        "max_score");
        System.out.println(rs);

        while (rs.next()) {
            QuizContentDAO quizContentDao = new QuizContentDAO();
            quizContentDao.setQuizId(rs.getInt(colNames.get(0)));
                    quizContentDao.setQuesId(rs.getInt(colNames.get(1)));
                    quizContentDao.setQuesType(rs.getString(colNames.get(2)));
                    quizContentDao.setQuesDesc(rs.getString(colNames.get(3)));
                    quizContentDao.setAnsId(rs.getInt(colNames.get(4)));
                    quizContentDao.setAnsDesc(rs.getString(colNames.get(5)));
                    quizContentDao.setCorrect(rs.getBoolean(colNames.get(6)));
                    quizContentDao.setMaxScore(rs.getInt(colNames.get(7)));
            list.add(quizContentDao);
        }
        return list;
    }

    private static String getContentQuery() {
        return String.format("SELECT * from quiz_content");
    }
}
