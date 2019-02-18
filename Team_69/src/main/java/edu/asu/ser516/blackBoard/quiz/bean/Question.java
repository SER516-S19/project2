package main.java.edu.asu.ser516.blackBoard.quiz.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Quiz_Id")
    private int quizId;

    @Column(name = "Question")
    private String question;

    @Column(name = "Correct_Answer_id")
    private int correctAnswerId;

    @Column(name = "Type")
    private char type;
    
    @Column(name = "Points")
    private int points;

	public Question(int id, int quizId, String question, int correctAnswerId, char type, int points) {
		this.id = id;
		this.quizId = quizId;
		this.question = question;
		this.correctAnswerId = correctAnswerId;
		this.type = type;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getCorrectAnswerId() {
		return correctAnswerId;
	}

	public void setCorrectAnswerId(int correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

    
}
