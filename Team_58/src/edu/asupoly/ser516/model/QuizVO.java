package edu.asupoly.ser516.model;

public class QuizVO {
	

	private int quizId;
	private Boolean isGraded;
	private int assignedTime;
	private String quizInstruction;
	private String quizScheduledDate;
	private Boolean isShuffled;
	private String quizTitle;
	

	public QuizVO(int quizId, Boolean isGraded, int assignedTime, String quizInstruction, String quizScheduledDate,
			Boolean isShuffled, String quizTitle) {
		super();
		this.quizId = quizId;
		this.isGraded = isGraded;
		this.assignedTime = assignedTime;
		this.quizInstruction = quizInstruction;
		this.quizScheduledDate = quizScheduledDate;
		this.isShuffled = isShuffled;
		this.quizTitle = quizTitle;
	}

	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public Boolean getIsGraded() {
		return isGraded;
	}
	public void setIsGraded(Boolean isGraded) {
		this.isGraded = isGraded;
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
	public String getQuizScheduledDate() {
		return quizScheduledDate;
	}
	public void setQuizScheduledDate(String quizScheduledDate) {
		this.quizScheduledDate = quizScheduledDate;
	}
	public Boolean getIsShuffled() {
		return isShuffled;
	}
	public void setIsShuffled(Boolean isShuffled) {
		this.isShuffled = isShuffled;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	
}
