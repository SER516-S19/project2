package edu.asupoly.ser516.model;

public class CreateQuizVO {
	private int courseId;
	private String quizTitle;
	private String quizInstructons;
	private String quizScheduledDate;
	private int quizId;
	private int isShuffled;
	private int assignedTime;
	private int isGraded;

	public CreateQuizVO(int courseId, String quizTitle, String quizInstructons, String quizScheduledDate, int quizId,
			int isShuffled, int assignedTime, int isGraded) {
		super();
		this.courseId = courseId;
		this.quizTitle = quizTitle;
		this.quizInstructons = quizInstructons;
		this.quizScheduledDate = quizScheduledDate;
		this.quizId = quizId;
		this.isShuffled = isShuffled;
		this.assignedTime = assignedTime;
		this.isGraded = isGraded;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public String getQuizInstructons() {
		return quizInstructons;
	}

	public void setQuizInstructons(String quizInstructons) {
		this.quizInstructons = quizInstructons;
	}

	public String getQuizScheduledDate() {
		return quizScheduledDate;
	}

	public void setQuizScheduledDate(String quizScheduledDate) {
		this.quizScheduledDate = quizScheduledDate;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getIsShuffled() {
		return isShuffled;
	}

	public void setIsShuffled(int isShuffled) {
		this.isShuffled = isShuffled;
	}

	public int getAssignedTime() {
		return assignedTime;
	}

	public void setAssignedTime(int assignedTime) {
		this.assignedTime = assignedTime;
	}

	public int getIsGraded() {
		return isGraded;
	}

	public void setIsGraded(int isGraded) {
		this.isGraded = isGraded;
	}
}