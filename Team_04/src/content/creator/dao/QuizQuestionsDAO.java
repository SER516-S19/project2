package content.creator.dao;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuizQuestionsDAO {
	@SerializedName("choice")
	@Expose
	private Integer choice;
	@SerializedName("question")
	@Expose
	private String question;
	@SerializedName("option_a")
	@Expose
	private String optionA;
	@SerializedName("option_b")
	@Expose
	private String optionB;
	@SerializedName("option_c")
	@Expose
	private String optionC;
	@SerializedName("option_d")
	@Expose
	private String optionD;
	@SerializedName("score")
	@Expose
	private String score;

	public Integer getChoice() {
	return choice;
	}

	public void setChoice(Integer choice) {
	this.choice = choice;
	}

	public String getQuestion() {
	return question;
	}

	public void setQuestion(String question) {
	this.question = question;
	}

	public String getOptionA() {
	return optionA;
	}

	public void setOptionA(String optionA) {
	this.optionA = optionA;
	}

	public String getOptionB() {
	return optionB;
	}

	public void setOptionB(String optionB) {
	this.optionB = optionB;
	}

	public String getOptionC() {
	return optionC;
	}

	public void setOptionC(String optionC) {
	this.optionC = optionC;
	}

	public String getOptionD() {
	return optionD;
	}

	public void setOptionD(String optionD) {
	this.optionD = optionD;
	}

	public String getScore() {
	return score;
	}

	public void setScore(String score) {
	this.score = score;
	}

	}
