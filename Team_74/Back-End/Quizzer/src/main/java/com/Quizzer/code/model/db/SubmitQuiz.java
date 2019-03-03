package com.Quizzer.code.model.db;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

/**
 * This class is the model for Student quiz data.
 * 
 * @author Kirti Jha
 *
 */

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

	@CreatedDate
	private Date date;

	public SubmitQuiz() {

	}

	public SubmitQuiz(String id, String studentId, Quiz quiz, String quizId, int marksAchieved) {
		super();

		this.id = id;
		this.studentId = studentId;
		this.quiz = quiz;
		this.quizId = quizId;
		this.marksAchieved = marksAchieved;
		this.date = new Date();
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

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public int getMarksAchieved() {
		return marksAchieved;
	}

	public void setMarksAchieved(int marksAchieved) {
		this.marksAchieved = marksAchieved;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}