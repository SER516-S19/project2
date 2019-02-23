package bean;

import javax.persistence.*;

@Entity
@Table(name = "Question")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Question_id")
    private int questionId;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "Quiz_Id")
	private Quiz quiz;

    @Column(name = "Question")
    private String question;

    @Column(name = "Is_Multiple")
    private boolean isMultiple;
    
    @Column(name = "Points")
    private int points;


	public Question(Quiz quiz, String question, boolean isMultiple, int points) {
		super();
		this.quiz = quiz;
		this.question = question;
		this.isMultiple = isMultiple;
		this.points = points;
	}
	
	public Question(Quiz quiz,int questionId, String question, boolean isMultiple, int points) {
		super();
		this.quiz = quiz;
		this.question = question;
		this.isMultiple = isMultiple;
		this.points = points;
		this.questionId = questionId;
	}

	public Question() {
	}

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Question{" +
				"questionId=" + questionId +
				", quiz=" + quiz +
				", question='" + question + '\'' +
				", isMultiple=" + isMultiple +
				", points=" + points +
				'}';
	}
}
