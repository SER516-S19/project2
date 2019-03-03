package bean;

import javax.persistence.*;

<<<<<<< HEAD
=======
/**
 * This class reprsents the Answer table
 *
 * @author : Alsha Samantaray
 * @version : 1.0
 * @since : 02/20/2019
 */

>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
@Entity
@Table(name = "Answer")
public class Answer {

	@Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Answer_id",nullable = false)
    private int answerId;

    @OneToOne(cascade = {CascadeType.ALL})
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Answer_id",nullable = false)
    private int answerId;

	@ManyToOne(cascade = {CascadeType.REFRESH})
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
    @JoinColumn(name = "Question_id")
    private Question question;

    @Column(name = "Answer")
    private String answer;

    @Column(name = "Correct_Answer")
    private boolean correctAnswer;

    public Answer() {

  	}
    
    public Answer(Question question, String answer, boolean correctAnswer) {
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }
    
    public Answer(Question question, int answerId, String answer, boolean correctAnswer) {
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
        this.answerId = answerId;
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

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
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
