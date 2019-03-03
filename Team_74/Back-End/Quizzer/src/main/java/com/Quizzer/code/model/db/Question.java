
package com.Quizzer.code.model.db;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is the model class for Question item.
 * 
 * @author Kumar Prabhu Kalyan
 *
 */
@Document(collection = "Question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@CreatedDate
	private Date date;
	private String questionText;
	private List<String> options;
	private String quizId;
	private String correctAnswer;
	private String type;
	private int totalCorrectAttempts;
	private int marks;
	private String markedAnswer;

	public Question() {

	}

	public Question(String id, Date date, String questionText, List<String> options, String quizId,
			String correctAnswer, String type, int totalCorrectAttempts, int marks, String markedAnswer) {
		super();

		this.id = id;
		this.date = new Date();
		this.questionText = questionText;
		this.options = options;
		this.quizId = quizId;
		this.correctAnswer = correctAnswer;
		this.type = type;
		this.totalCorrectAttempts = totalCorrectAttempts;
		this.marks = marks;
		this.markedAnswer = markedAnswer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalCorrectAttempts() {
		return totalCorrectAttempts;
	}

	public void setTotalCorrectAttempts(int totalCorrectAttempts) {
		this.totalCorrectAttempts = totalCorrectAttempts;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getMarkedAnswer() {
		return markedAnswer;
	}

	public void setMarkedAnswer(String markedAnswer) {
		this.markedAnswer = markedAnswer;
	}

}
