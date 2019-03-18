package bean;

/**
 * @author: leharbhatt
 * @version : 1.0
 * @since : 02/22/2019
 * 
 */

public class AnswerDetails {
	private int answerId;
	private String answer;
	private boolean correctAnswer;

	public int getAnswerId() {
		return answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
}
