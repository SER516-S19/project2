package edu.asu.ser516.blackBoard.quiz.bean;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private int quizId;

    @Column(name = "Name" , nullable = false)
    private String quizName;

    @Column(name="Instructions")
    private String quizInstructions;

    @Column(name ="Type")
    private String quizType;

    @Temporal(TemporalType.TIME)
    @Column(name = "Time_Limit")
    private Date quizTimeLimit;

    @Column(name="Shuffle_Answer")
    private String shuffleAnswer;
    
    Quiz() {}

    public Quiz(String quizName, String quizInstructions, String quizType, Date quizTimeLimit, String shuffleAnswer) {
        this.quizName = quizName;
        this.quizInstructions = quizInstructions;
        this.quizType = quizType;
        this.quizTimeLimit = quizTimeLimit;
        this.shuffleAnswer = shuffleAnswer;
    }


    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizInstructions() {
        return quizInstructions;
    }

    public void setQuizInstructions(String quizInstructions) {
        this.quizInstructions = quizInstructions;
    }

    public String getQuizType() {
        return quizType;
    }

    public void setQuizType(String quizType) {
        this.quizType = quizType;
    }

 

    public Date getQuizTimeLimit() {
		return quizTimeLimit;
	}


	public void setQuizTimeLimit(Date quizTimeLimit) {
		this.quizTimeLimit = quizTimeLimit;
	}


	public String getShuffleAnswer() {
        return shuffleAnswer;
    }

    public void setShuffleAnswer(String shuffleAnswer) {
        this.shuffleAnswer = shuffleAnswer;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", quizName='" + quizName + '\'' +
                ", quizInstructions='" + quizInstructions + '\'' +
                ", quizType='" + quizType + '\'' +
                ", quizTimeLimit=" + quizTimeLimit +
                ", shuffleAnswer='" + shuffleAnswer + '\'' +
                '}';
    }
}
