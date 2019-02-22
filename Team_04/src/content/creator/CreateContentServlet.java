package content.creator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateContentServlet")
public class CreateContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
private void savaDataToDb(int quizId,int quesId,String question,Map<Integer,ArrayList<String>> data, int score) {
    String strScore = Integer.toString(score);
    for (Integer answerKey : data.keySet()) {
        QuizContentDAO quizContent = DataOps.getQuizContentDAO();
        quizContent.setQuizId(quiz);
        quizContent.setQuesId(quesId);
        quizContent.setQuesType("MCQ");
        quizContent.setQuesDesc(question);
        quizContent.setAnsId(data.getKey(answerKey));
        quizContent.setAnsDesc(data.get[answerKey][0]);
        quizContent.setCorrect(data.get(answerKey)[1]);
        quizContent.setMaxScore(strScore);
        String quizCon=convertToQueryString(quizContent);
        DataOps.saveData(quizCon);
    }

}

private String convertToQueryString(QuizContentDAO quizContent){
        String tableName = "quiz_content";
        ArrayList<String> colName = new ArrayList<String>["quiz_id", "ques_id", "quest_type","ques_desc", "ans_id", "ans_desc", "is_correct", "max_score"];
        String values = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES (%s \t %s \t %s \t %s \t %s \t %s \t %s \t %s)", tableName,
                colName.get(0),colName.get(1),colName.get(2),colName.get(3),colName.get(4),colName.get(5),colName.get(6),colName.get(7),
                quizContent.getQuizId(),
                quizContent.getQuesId(),
                quizContent.getQuesType(),
                quizContent.getQuesDesc(),
                quizContent.getAnsId(),
                quizContent.getAnsDesc(),
                quizContent.getCorrect(),
                quizContent.getMaxScore())
        return values;
    }
}