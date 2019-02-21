package edu.asu.ser516.blackBoard.quiz.bean;

import javax.persistence.*;

@Entity
@Table(name = "Question")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Question_id")
    private int questionId;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "Quiz_Id")
	private Quiz quiz;

    @Column(name = "Question")
    private String question;

    @Column(name = "Correct_Answer_id")
    private int correctAnswerId;

    @Column(name = "Type")
    private char type;
    
    @Column(name = "Points")
    private int points;

	public Question(Quiz quiz, String question, int correctAnswerId, char type, int points) {
		this.quiz = quiz;
		this.question = question;
		this.correctAnswerId = correctAnswerId;
		this.type = type;
		this.points = points;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Question{" +
				"questionId=" + questionId +
				", quiz=" + quiz +
				", question='" + question + '\'' +
				", correctAnswerId=" + correctAnswerId +
				", type=" + type +
				", points=" + points +
				'}';
	}
}
