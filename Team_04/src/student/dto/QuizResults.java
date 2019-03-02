package student.dto;

/**
 * This Class represents the model for Question_Response table
 */
public class QuizResults {

  private long student_id;
  private long attempt_id;
  private long quiz_id;
  private long ques_id;
  private long ans_id;
  private long total_score;
  private String attempted_on;
  private String time_taken;
  private String is_final;


  public long getStudentId() {
    return student_id;
  }

  public void setStudentId(long student_id) {
    this.student_id = student_id;
  }

  public long getAttemptId() {
    return attempt_id;
  }

  public void setAttemptId(long attempt_id) {
    this.attempt_id = attempt_id;
  }

  public long getQuizId() {
    return quiz_id;
  }

  public void setQuizId(long quiz_id) {
    this.quiz_id = quiz_id;
  }

  public long getQuesId() {
    return ques_id;
  }

  public void setQuesId(long ques_id) {
    this.ques_id = ques_id;
  }

  public long getAnsId() {
    return ans_id;
  }

  public void setAnsId(long ans_id) {
    this.ans_id = ans_id;
  }

  public long getTotalscore() {
    return total_score;
  }

  public void setTotalscore(long total_score) {
    this.total_score = total_score;
  }

  public String getAttemptedOn() {
    return attempted_on;
  }

  public void setAttemptedOn(String attempted_on) {
    this.attempted_on = attempted_on;
  }

  public String getTimetaken() {
    return time_taken;
  }

  public void setTimetaken(String time_taken) {
    this.time_taken = time_taken;
  }

  public String getIsfinal() {
    return is_final;
  }
  public void setIsfinal(String is_final) {
    this.is_final = is_final;
  }

}
