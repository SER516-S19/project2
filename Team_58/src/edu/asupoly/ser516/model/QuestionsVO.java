package edu.asupoly.ser516.model;

/**
 * QuestionVO is the plain old java file for CreateQuestions and ViewQiz pages
 * 
 * @version 1.1
 * @author trupti khatavkar / @author aditya samant
 * @date 02/22/2019
 */

public class QuestionsVO {

	private int quizId;
	private int questionId;
	private String question;
	private String correctAnswer;
	private String incorrectAnswer1;
	private String incorrectAnswer2;
	private String incorrectAnswer3;
	private int totalPoints;
	private boolean isMCQ;

	/**
	 * Constructor for setting values while creating questions
	 * 
	 * @date 02/22/2019
	 */
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

	/**
	 * Constructor for retrieving values while displaying questions
	 * 
	 * @date 02/22/2019
	 */
	public QuestionsVO(int qId, int totalPoints, String correctAnswer, String incorrectAnswer1, String incorrectAnswer2,
			String incorrectAnswer3, String question) {
		this.questionId = questionId;
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
		return questionId;
	}

	public void setqId(int questionId) {
		this.questionId = questionId;
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

}
