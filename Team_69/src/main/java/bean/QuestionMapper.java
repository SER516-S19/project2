/**
 * 
 */
package bean;

import java.util.List;

/**
 * @author: leharbhatt
 * @version : 1.0
 * @since : 02/22/2019
 * 
 */
public class QuestionMapper {
	private int questionId;
	private String question;
	private int correctAnswerId;
	private boolean isMultiple;
	private List<AnswerMapper> responseAnswer;
	private List<AnswerMapper> availableAnswers;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getCorrectAnswerId() {
		return correctAnswerId;
	}

	public void setCorrectAnswerId(int correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	private int points;

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public List<AnswerMapper> getResponseAnswer() {
		return responseAnswer;
	}

	public void setResponseAnswer(List<AnswerMapper> responseAnswer) {
		this.responseAnswer = responseAnswer;
	}

	public List<AnswerMapper> getAvailableAnswers() {
		return availableAnswers;
	}

	public void setAvailableAnswers(List<AnswerMapper> availableAnswers) {
		this.availableAnswers = availableAnswers;
	}
}
