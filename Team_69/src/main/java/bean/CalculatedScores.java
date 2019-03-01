package bean;

import javax.persistence.*;

/**
 * This is a helper class to store calculated score of students in CalculatedScores table.
 *
 * @author : Bhawana Prasad
 * @version : 1.0
 * @since : 02/26/2019
 */

public class CalculatedScores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Column(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "scores")
    private int score;

    public CalculatedScores( int id, User user, Quiz quiz, int score) {
        this.id = id;
        this.quiz = quiz;
        this.user = user;
        this.score = score;
    }

    public CalculatedScores() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CalculatedScores{" +
                "id=" + id +
                "quiz=" + quiz +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}
