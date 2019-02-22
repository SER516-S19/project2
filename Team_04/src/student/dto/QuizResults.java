package student.dto;


public class QuizResults {

  private long student_id;
  private long attempt_id;
  private long quiz_id;
  private long ques_id;
  private long ans_id;
  private long total_score;
  private java.sql.Date attempted_on;
  private long time_taken;
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


  public long getQuiz_id() {
    return quiz_id;
  }

  public void setQuiz_id(long quiz_id) {
    this.quiz_id = quiz_id;
  }


  public long getQues_id() {
    return ques_id;
  }

  public void setQues_id(long ques_id) {
    this.ques_id = ques_id;
  }


  public long getAns_id() {
    return ans_id;
  }

  public void setAns_id(long ans_id) {
    this.ans_id = ans_id;
  }


  public long getTotal_score() {
    return total_score;
  }

  public void setTotal_score(long total_score) {
    this.total_score = total_score;
  }


  public java.sql.Date getAttempted_on() {
    return attempted_on;
  }

  public void setAttempted_on(java.sql.Date attempted_on) {
    this.attempted_on = attempted_on;
  }


  public long getTime_taken() {
    return time_taken;
  }

  public void setTime_taken(long time_taken) {
    this.time_taken = time_taken;
  }


  public String getIs_final() {
    return is_final;
  }

  public void setIs_final(String is_final) {
    this.is_final = is_final;
  }

}
