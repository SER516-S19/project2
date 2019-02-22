package edu.asupoly.ser516.model;

/**
 * QuestionVO is the plain old java file for Question
 * 
 * @version 1.0
 * @author trupti khatavkar
 * @date 02/22/2019
 */

public class QuestionsVO {
	public QuestionsVO(int qId, int totalPoints, String correctAnswer, String incorrectAnswer1, String incorrectAnswer2,
			String incorrectAnswer3, String question) {
		super();
		this.qId = qId;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.incorrectAnswer1 = incorrectAnswer1;
		this.incorrectAnswer2 = incorrectAnswer2;
		this.incorrectAnswer3 = incorrectAnswer3;
		this.totalPoints = totalPoints;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
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

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public boolean isMCQ() {
		return isMCQ;
	}

	public void setMCQ(boolean isMCQ) {
		this.isMCQ = isMCQ;
	}

	private int quizId;
	private int qId;
	private String question;
	private String correctAnswer;
	private String incorrectAnswer1;
	private String incorrectAnswer2;
	private String incorrectAnswer3;
	private int totalPoints;
	private boolean isMCQ;

	public QuestionsVO(int quizId, String question, String correctAnswer, String incorrectAnswer1,
			String incorrectAnswer2, String incorrectAnswer3, int totalPoints, boolean isMCQ) {
		super();
		this.quizId = quizId;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.incorrectAnswer1 = incorrectAnswer1;
		this.incorrectAnswer2 = incorrectAnswer2;
		this.incorrectAnswer3 = incorrectAnswer3;
		this.totalPoints = totalPoints;
		this.isMCQ = isMCQ;
	}

}
