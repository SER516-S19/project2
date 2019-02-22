package bean;

/**
 * @author: leharbhatt
 * @version : 1.0
 * @since : 02/22/2019
 * 
 */

public class AnswerMapper {
	private int answerId;
    private String answer;
    private String correctAnswer;
	public int getAnswerId() {
		return answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
}
