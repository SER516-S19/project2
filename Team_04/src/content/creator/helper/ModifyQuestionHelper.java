package content.creator.helper;

import static content.creator.operations.DataOps.getNamesFromProperty;
import content.creator.operations.DataOps;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import content.creator.dao.QuizContentDAO;

public final class ModifyQuestionHelper {
    public ModifyQuestionHelper() {}

    public static void updateDataInDb(
            int quizId,
            int quesId,
            String question_text,
            Map<Integer, ArrayList<String>> answerBundle,
            String score)
            throws SQLException {
        for (Integer answer_key : answerBundle.keySet()) {
            QuizContentDAO quiz = new content.creator.dao.QuizContentDAO();
            quiz.setQuizId(quizId);
            quiz.setQuesId(quesId);
            quiz.setQuesType(null);
            quiz.setQuesDesc(question_text);
            quiz.setAnsId(answer_key);
            quiz.setAnsDesc(answerBundle.get(answer_key).get(0));
            quiz.setCorrect(Boolean.parseBoolean(answerBundle.get(answer_key).get(1)));
            quiz.setMaxScore(Integer.parseInt(score));
            String queryString = queryString(quiz);
            DataOps.saveData(queryString);
        }
    }

    private static String queryString(content.creator.dao.QuizContentDAO quizContent) {
        String tableName = getNamesFromProperty("QUIZ_CONTENT_TABLE_NAME");
        List<String> colNames = content.creator.constants.Constants.colNames;
        return String.format(
                "UPDATE %s" +
                        " SET %s = '%s'," + //quesType
                        " %s = '%s'," +    //quesDesc
                        " %s = '%s'," +    //isCorrect
                        " %s = %s," +      //maxScore
                        " %s = '%s'" +     //ansDesc
                        " WHERE quizId = %s" +
                        " AND quesId = %s" +
                        " AND ansId = %s;",
                tableName,
                colNames.get(2), quizContent.getQuesType(),
                colNames.get(3), quizContent.getQuesDesc(),
                colNames.get(6), quizContent.getCorrect(),
                colNames.get(7), quizContent.getMaxScore(),
                colNames.get(5), quizContent.getAnsDesc(),
                quizContent.getQuizId(),
                quizContent.getQuesId(),
                quizContent.getAnsId()
        );
    }
}