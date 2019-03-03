package content.creator.dao;

import java.util.ArrayList;
import java.util.Map;

public class QuizFormDAO {
  private int quizId;
  private int questionId;
  private String score;
  private String questionText;
  private Map<Integer, ArrayList<String>> answerBundle;

  public int getQuizId() {
    return quizId;
  }

  public void setQuizId(int quizId) {
    this.quizId = quizId;
  }

  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public Map<Integer, ArrayList<String>> getAnswerBundle() {
    return answerBundle;
  }

  public void setAnswerBundle(
      Map<Integer, ArrayList<String>> answerBundle) {
    this.answerBundle = answerBundle;
  }
}
