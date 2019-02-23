package student.dto;


import java.util.ArrayList;
import java.util.List;

public class QuizContent {

  private long quiz_id;
  private long ques_id;
  private String ques_type;
  private String ques_desc;
  private long ans_id;
  private String ans_desc;
  private boolean is_correct;
  private long max_score;

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


  public String getQuesType() {
    return ques_type;
  }

  public void setQuesType(String ques_type) {
    this.ques_type = ques_type;
  }


  public String getQuesDesc() {
    return ques_desc;
  }

  public void setQuesDesc(String ques_desc) {
    this.ques_desc = ques_desc;
  }


  public long getAnsId() {
    return ans_id;
  }

  public void setAnsId(long ans_id) {
    this.ans_id = ans_id;
  }


  public String getAnsDesc() {
    return ans_desc;
  }

  public void setAnsDesc(String ans_desc) {
    this.ans_desc = ans_desc;
  }


  public boolean isIsCorrect() {
    return is_correct;
  }

  public void setIsCorrect(boolean is_correct) {
    this.is_correct = is_correct;
  }


  public long getMaxScore() {
    return max_score;
  }

  public void setMaxScore(long max_score) {
    this.max_score = max_score;
  }

  private List<AnswerOption> answerOptions = new ArrayList<>();

  public List<AnswerOption> getAnswerOptions() {
    return answerOptions;
  }

  public void setAnswerOptions(List<AnswerOption> answerOptions) {
    this.answerOptions = answerOptions;
  }
}
