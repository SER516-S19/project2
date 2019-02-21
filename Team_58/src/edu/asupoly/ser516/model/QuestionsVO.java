package edu.asupoly.ser516.model;

public class QuestionsVO {
	private int qId;
	private String question;
	private String correctAnswer;
	private String incorrectAnswer1;
	private String incorrectAnswer2;
	private String incorrectAnswer3;
	private int totalPoints;
	

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getIncorrectAnswer1() {
		return incorrectAnswer1;
	}

	public void setIncorrectAnswer1(String incorrectAnswer1) {
		this.incorrectAnswer1 = incorrectAnswer1;
	}

	public String getIncorrectAnswer2() {
		return incorrectAnswer2;
	}

	public void setIncorrectAnswer2(String incorrectAnswer2) {
		this.incorrectAnswer2 = incorrectAnswer2;
	}

	public String getIncorrectAnswer3() {
		return incorrectAnswer3;
	}

	public void setIncorrectAnswer3(String incorrectAnswer3) {
		this.incorrectAnswer3 = incorrectAnswer3;
	}

	public QuestionsVO(String question, String correctAnswer, String incorrectAnswer1, String incorrectAnswer2,
			String incorrectAnswer3) {
		super();
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.incorrectAnswer1 = incorrectAnswer1;
		this.incorrectAnswer2 = incorrectAnswer2;
		this.incorrectAnswer3 = incorrectAnswer3;
	}
	/**
	 * 
	 * 
	 * 
	 * */
	public QuestionsVO(int id, int points, String quest, String ans, String wrongAns1, String wrongAns2, String wrongAns3){
		qId = id;
		totalPoints = points;
		question = quest;
		correctAnswer = ans;
		incorrectAnswer1 = wrongAns1;
		incorrectAnswer2 = wrongAns2;
		incorrectAnswer3 = wrongAns3;
	}
}
