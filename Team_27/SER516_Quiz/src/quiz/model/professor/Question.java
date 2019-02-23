package quiz.model.professor;

public class Question {

	private Integer quizId;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Boolean isOptionACorrect;
	private Boolean isOptionBCorrect;
	private Boolean isOptionCCorrect;
	private Boolean isOptionDCorrect;
	private Integer points;
	private Boolean isMultipleAnswer;

	public Question(String quizId, String question, String optionA, String optionB, String optionC, String optionD,
			Boolean isOptionACorrect, Boolean isOptionBCorrect, Boolean isOptionCCorrect, Boolean isOptionDCorrect,
			String points, Boolean isMultipleAnswer) {
		super();
		this.quizId = Integer.parseInt(quizId);
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.isOptionACorrect = isOptionACorrect;
		this.isOptionBCorrect = isOptionBCorrect;
		this.isOptionCCorrect = isOptionCCorrect;
		this.isOptionDCorrect = isOptionDCorrect;
		this.points = Integer.parseInt(points);
		this.isMultipleAnswer = isMultipleAnswer;
	}
	
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public Integer getQuizId() {
		return quizId;
	}

	
	public String getQuestion() {
		return question;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setIsOptionACorrect(Boolean isOptionACorrect) {
		this.isOptionACorrect = isOptionACorrect;
	}

	public Boolean getIsOptionACorrect() {
		return isOptionACorrect;
	}

	public void setIsOptionBCorrect(Boolean isOptionBCorrect) {
		this.isOptionBCorrect = isOptionBCorrect;
	}

	public Boolean getIsOptionBCorrect() {
		return isOptionBCorrect;
	}

	public void setIsOptionCCorrect(Boolean isOptionCCorrect) {
		this.isOptionCCorrect = isOptionCCorrect;
	}

	public Boolean getIsOptionCCorrect() {
		return isOptionCCorrect;
	}

	public void setIsOptionDCorrect(Boolean isOptionDCorrect) {
		this.isOptionDCorrect = isOptionDCorrect;
	}

	public Boolean getIsOptionDCorrect() {
		return isOptionDCorrect;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getPoints() {
		return points;
	}

	public void setIsMultipleAnswer(Boolean isMultipleAnswer) {
		this.isMultipleAnswer = isMultipleAnswer;
	}

	public Boolean getIsMultipleAnswer() {
		return isMultipleAnswer;
	}
}