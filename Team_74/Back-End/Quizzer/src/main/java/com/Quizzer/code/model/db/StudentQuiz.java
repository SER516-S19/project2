package com.Quizzer.code.model.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is the model for Student quiz data.
 * 
 * @author Kirti Jha
 *
 */
@Document(collection = "StudentQuiz")
public class StudentQuiz implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private User studentId;
	private ArrayList<Quiz> quizlist;
	private HashMap<String, Integer> attemptedQuiz;
	@CreatedDate
	private Date date;	
	public StudentQuiz(User studentId, ArrayList<Quiz> quizlist, HashMap<String, Integer> attemptedQuiz, Date date) {
		super();
		this.studentId = studentId;
		this.quizlist = quizlist;
		this.attemptedQuiz = attemptedQuiz;
		this.date = date;
	}
	
	public User getStudentId() {
		return studentId;
	}
	public void setStudentId(User studentId) {
		this.studentId = studentId;
	}
	public ArrayList<Quiz> getQuizlist() {
		return quizlist;
	}
	public void setQuizlist(ArrayList<Quiz> quizlist) {
		this.quizlist = quizlist;
	}
	public HashMap<String, Integer> getAttemptedQuiz() {
		return attemptedQuiz;
	}
	public void setAttemptedQuiz(HashMap<String, Integer> attemptedQuiz) {
		this.attemptedQuiz = attemptedQuiz;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
