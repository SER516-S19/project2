package student.dto;


import java.util.ArrayList;
import java.util.List;

public class QuizContent {

  private long quizId;
  private long quesId;
  private String quesType;
  private String quesDesc;
  private long ansId;
  private String ansDesc;
  private boolean isCorrect;
  private long maxScore;


  public long getQuizId() {
    return quizId;
  }

  public void setQuizId(long quizId) {
    this.quizId = quizId;
  }


  public long getQuesId() {
    return quesId;
  }

  public void setQuesId(long quesId) {
    this.quesId = quesId;
  }


  public String getQuesType() {
    return quesType;
  }

  public void setQuesType(String quesType) {
    this.quesType = quesType;
  }


  public String getQuesDesc() {
    return quesDesc;
  }

  public void setQuesDesc(String quesDesc) {
    this.quesDesc = quesDesc;
  }


  public long getAnsId() {
    return ansId;
  }

  public void setAnsId(long ansId) {
    this.ansId = ansId;
  }


  public String getAnsDesc() {
    return ansDesc;
  }

  public void setAnsDesc(String ansDesc) {
    this.ansDesc = ansDesc;
  }


  public boolean getIsCorrect() {
    return isCorrect;
  }

  public void setIsCorrect(boolean isCorrect) {
    this.isCorrect = isCorrect;
  }


  public long getMaxScore() {
    return maxScore;
  }

  public void setMaxScore(long maxScore) {
    this.maxScore = maxScore;
  }

  private List<AnswerOption> answerOptions = new ArrayList<>();

  public List<AnswerOption> getAnswerOptions() {
    return answerOptions;
  }

  public void setAnswerOptions(List<AnswerOption> answerOptions) {
    this.answerOptions = answerOptions;
  }

  private int score;

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  private List<String> selectedAnswers = new ArrayList<>();

    public List<String> getSelectedAnswers() {
        return selectedAnswers;
    }

    public void setSelectedAnswers(List<String> selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }
}
