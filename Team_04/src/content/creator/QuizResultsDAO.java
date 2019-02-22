package content.creator;

import java.util.Date;

class QuizResultsDAO {
  private int studentId;
  private int attemptId;
  private int quizId;
  private int quesId;
  private int ansId;
  private int totalScore;

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getAttemptId() {
    return attemptId;
  }

  public void setAttemptId(int attemptId) {
    this.attemptId = attemptId;
  }

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

  public int getAnsId() {
    return ansId;
  }

  public void setAnsId(int ansId) {
    this.ansId = ansId;
  }

  public int getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }

  public Date getAttemptedOn() {
    return attemptedOn;
  }

  public void setAttemptedOn(Date attemptedOn) {
    this.attemptedOn = attemptedOn;
  }

  public int getTimeTaken() {
    return timeTaken;
  }

  public void setTimeTaken(int timeTaken) {
    this.timeTaken = timeTaken;
  }

  public boolean isFinal() {
    return isFinal;
  }

  public void setFinal(boolean aFinal) {
    isFinal = aFinal;
  }

  private Date attemptedOn;
  private int timeTaken;
  private boolean isFinal;
}
