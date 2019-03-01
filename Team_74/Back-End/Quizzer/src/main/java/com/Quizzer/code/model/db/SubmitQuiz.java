package com.Quizzer.code.model.db;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SubmittedQuiz")
public class SubmitQuiz implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String studentId;
	private Quiz quiz;
	private String quizId;
	private int marksAchieved;

	public SubmitQuiz(String studentId, Quiz quiz, int marksAchieved, String quizId) {
		super();
		this.studentId = studentId;
		this.quiz = quiz;
		this.marksAchieved = marksAchieved;
		this.quizId = quizId;
	}

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public int getMarksAchieved() {
		return marksAchieved;
	}

	public void setMarksAchieved(int marksAchieved) {
		this.marksAchieved = marksAchieved;
	}

}