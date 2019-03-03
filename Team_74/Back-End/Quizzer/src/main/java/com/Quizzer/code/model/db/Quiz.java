package com.Quizzer.code.model.db;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is the model class for Quiz item.
 * 
 * @author Kumar Prabhu Kalyan
 *
 */
@Document(collection = "Quiz")
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String instruction;
	private String name;
	private List<Question> questions;
	private int time;
	private int totalAttempts;
	private int totalMarks;

	public Quiz(String id, String instruction, String name, List<Question> questions, int time, int totalAttempts,
			int totalMarks) {
		super();
		this.id = id;
		this.instruction = instruction;
		this.name = name;
		this.questions = questions;
		this.time = time;
		this.totalAttempts = totalAttempts;
		this.totalMarks = totalMarks;
	}

	public Quiz() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTotalAttempts() {
		return totalAttempts;
	}

	public void setTotalAttempts(int totalAttempts) {
		this.totalAttempts = totalAttempts;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

}
