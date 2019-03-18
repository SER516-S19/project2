package bean;

import javax.persistence.*;

/**
 * This class represents the Response Statistics table
 *
 * @author : Jahnvi Rai
 * @version : 1.0
 * @since : 02/18/2019
 */

@Entity
@Table(name="Response_stats")
public class ResponseStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Response_id", nullable = false)
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Quiz_Id")
    private Quiz quiz;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Question_id")
    private Question question;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Answer_id")
    private Answer answer;

    public ResponseStatistics(User user, Quiz quiz, Question question, Answer answer) {
        this.user = user;
        this.quiz = quiz;
        this.question = question;
        this.answer = answer;
    }

    public ResponseStatistics() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ResponseStatistics{" +
                "id=" + id +
                ", user=" + user +
                ", quiz=" + quiz +
                ", question=" + question +
                ", answer=" + answer +
                '}';
    }
}
