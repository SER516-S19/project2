package content.creator.dao;

public class QuizContentDAO {
  private int quizId;
  private int quesId;
  private String quesType;
  private String quesDesc;
  private int ansId;
  private String ansDesc;
  private boolean isCorrect;
  private int maxScore;

  public int getQuizId() {
    return quizId;
  }

  public void setQuizId(int quizId) {
    this.quizId = quizId;
  }

  public int getQuesId() {
    return quesId;
  }

  public void setQuesId(int quesId) {
    this.quesId = quesId;
  }

  public String getQuesType() {
    return quesType;
  }

  public void setQuesType(String quesType) {
    if (quesType == null) {
      quesType = "MCQ";
    }
    this.quesType = quesType;
  }

  public String getQuesDesc() {
    return quesDesc;
  }

  public void setQuesDesc(String quesDesc) {
    this.quesDesc = quesDesc;
  }

  public int getAnsId() {
    return ansId;
  }

  public void setAnsId(int ansId) {
    this.ansId = ansId;
  }

  public String getAnsDesc() {
    return ansDesc;
  }

  public void setAnsDesc(String ansDesc) {
    this.ansDesc = ansDesc;
  }

  public boolean getCorrect() {
    return isCorrect;
  }

  public void setCorrect(boolean correct) {
    isCorrect = correct;
  }

  public int getMaxScore() {
    return maxScore;
  }

  public void setMaxScore(int maxScore) {
    this.maxScore = maxScore;
  }
}
