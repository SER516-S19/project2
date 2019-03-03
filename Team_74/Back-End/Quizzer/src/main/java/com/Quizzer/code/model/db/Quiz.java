package com.Quizzer.code.model.db;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is the model class for Quiz item.
 * 
 * @author Kumar Prabhu Kalyan
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
	private boolean shouldShuffle;
	private String quizType;
	private String assignmnetGroup;
	@CreatedDate
	private Date date;

	public Quiz() {

	}

	public Quiz(String id, String instruction, String name, List<Question> questions, int time, int totalAttempts,
			int totalMarks, boolean shouldShuffle, String quizType, String assignmnetGroup) {
		super();

		this.id = id;
		this.instruction = instruction;
		this.name = name;
		this.questions = questions;
		this.time = time;
		this.totalAttempts = totalAttempts;
		this.totalMarks = totalMarks;
		this.shouldShuffle = shouldShuffle;
		this.quizType = quizType;
		this.assignmnetGroup = assignmnetGroup;
		this.date = new Date();
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

	public boolean isShouldShuffle() {
		return shouldShuffle;
	}

	public void setShouldShuffle(boolean shouldShuffle) {
		this.shouldShuffle = shouldShuffle;
	}

	public String getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}

	public String getAssignmnetGroup() {
		return assignmnetGroup;
	}

	public void setAssignmnetGroup(String assignmnetGroup) {
		this.assignmnetGroup = assignmnetGroup;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
