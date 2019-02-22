package bean;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {

  

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Answer_id",nullable = false)
    private int answerId;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Question_id")
    private Question question;

    @Column(name = "Answer")
    private String answer;

    @Column(name = "Correct_Answer")
    private String correctAnswer;


    public Answer() {

  	}
    
    public Answer(Question question, String answer, String correctAnswer) {
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
