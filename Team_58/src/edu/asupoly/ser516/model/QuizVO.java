package edu.asupoly.ser516.model;

import java.util.Date;

public class QuizVO {
	
	private int quizId;
	private boolean isGraded;
	private int assignedTime;
	private String quizInstruction;
	private Date quizScheduledDate;
	private boolean isShuffled;
	private String quizTitle;

	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public int getAssignedTime() {
		return assignedTime;
	}
	public void setAssignedTime(int assignedTime) {
		this.assignedTime = assignedTime;
	}
	public String getQuizInstruction() {
		return quizInstruction;
	}
	public void setQuizInstruction(String quizInstruction) {
		this.quizInstruction = quizInstruction;
	}
	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public boolean isGraded() {
		return isGraded;
	}

	public void setGraded(boolean isGraded) {
		this.isGraded = isGraded;
	}

	public boolean isShuffled() {
		return isShuffled;
	}

	public void setShuffled(boolean isShuffled) {
		this.isShuffled = isShuffled;
	}
	public Date getQuizScheduledDate() {
		return quizScheduledDate;
	}
	public void setQuizScheduledDate(Date quizScheduledDate) {
		this.quizScheduledDate = quizScheduledDate;
	}
	public QuizVO(int quizId, boolean isGraded, int assignedTime, String quizInstruction, Date quizScheduledDate,
			boolean isShuffled, String quizTitle) {
		super();
		this.quizId = quizId;
		this.isGraded = isGraded;
		this.assignedTime = assignedTime;
		this.quizInstruction = quizInstruction;
		this.quizScheduledDate = quizScheduledDate;
		this.isShuffled = isShuffled;
		this.quizTitle = quizTitle;
	}
	
}
