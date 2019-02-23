package com.Quizzer.code.model.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is the model for User data.
 * 
 * @author Kirti
 *
 */
@Document(collection = "UserDetails")
public class Student_Quiz implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private User studentId;
	private ArrayList<Quiz> quizlist;
	private HashMap<Quiz, Integer> attemptedQuiz;

	public Student_Quiz(User studentId, ArrayList<Quiz> quizlist, HashMap<Quiz, Integer> attemptedQuiz) {
		super();
		this.studentId = studentId;
		this.quizlist =  new ArrayList<Quiz>();
		this.attemptedQuiz = new HashMap<Quiz, Integer>();
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

	public HashMap<Quiz, Integer> getAttemptedQuiz() {
		return attemptedQuiz;
	}

	public void setAttemptedQuiz(HashMap<Quiz, Integer> attemptedQuiz) {
		this.attemptedQuiz = attemptedQuiz;
	}

	public Student_Quiz() {
		
	}
}
