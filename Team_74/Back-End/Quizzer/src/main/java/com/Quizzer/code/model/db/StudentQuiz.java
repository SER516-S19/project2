package com.Quizzer.code.model.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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
	private String studentId;
	private ArrayList<Quiz> quizlist;
	private HashMap<String, Integer> attemptedQuiz;

	public StudentQuiz(String studentId, ArrayList<Quiz> quizlist, HashMap<String, Integer> attemptedQuiz) {
		super();
		this.studentId = studentId;
		this.quizlist = new ArrayList<Quiz>();
		this.attemptedQuiz = new HashMap<String, Integer>();
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
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

	public StudentQuiz() {

	}
}
