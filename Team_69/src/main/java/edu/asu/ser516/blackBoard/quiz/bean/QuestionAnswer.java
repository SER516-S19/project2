package edu.asu.ser516.blackBoard.quiz.bean;

import java.util.List;

/**
 * 
 * This class represents a Questions and its answers.
 * 
 * @author: leharbhatt
 * @version: 1.0
 * @since: 02/20/2019
 */

public class QuestionAnswer {
	private int questionId;
	private Quiz quiz;
	private String question;
	private int correctAnswerId;
	private boolean isMultiple;
	private int points;
	private List<Answer> answerList;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
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

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

}
