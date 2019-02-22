package student.dto;


public class QuizContent {

  private long quiz_id;
  private long ques_id;
  private String ques_type;
  private String ques_desc;
  private long ans_id;
  private String ans_desc;
  private String is_correct;
  private long max_score;


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


  public String getQues_type() {
    return ques_type;
  }

  public void setQues_type(String ques_type) {
    this.ques_type = ques_type;
  }


  public String getQues_desc() {
    return ques_desc;
  }

  public void setQues_desc(String ques_desc) {
    this.ques_desc = ques_desc;
  }


  public long getAns_id() {
    return ans_id;
  }

  public void setAns_id(long ans_id) {
    this.ans_id = ans_id;
  }


  public String getAns_desc() {
    return ans_desc;
  }

  public void setAns_desc(String ans_desc) {
    this.ans_desc = ans_desc;
  }


  public String getIs_correct() {
    return is_correct;
  }

  public void setIs_correct(String is_correct) {
    this.is_correct = is_correct;
  }


  public long getMax_score() {
    return max_score;
  }

  public void setMax_score(long max_score) {
    this.max_score = max_score;
  }

}
