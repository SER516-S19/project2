package Team76.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Quiz object 
 * author: Hongfei Ju 
 * version: 2.0
 */
public class QuizEntity {
	private int professorId = 0;
	private int quizId = 0;
	private String quizStatus = "";
	private Date dueDate = null;
	private int timeLimit = 0;
	private String quizType = "";
	private String quizTitle = null;
	private String quizInstruct= null;//Xiangwei
	private List<QuestionEntity> questionsList;
	
	public List<QuestionEntity> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<QuestionEntity> questionsList) {
		this.questionsList = questionsList;
	}

	public void setQuestionsList(QuestionEntity question) {
	if(questionsList==null) {
		questionsList= new ArrayList<>();
	}	
	questionsList.add(question);
	}
	
	public String getQuizInstruct() {//Xiangwei
		return quizInstruct;
	}
	
	public void setQuizInstruct(String quizInstruct) {//Xiangwei
		this.quizInstruct = quizInstruct;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizStatus() {
		return quizStatus;
	}

	public void setQuizStatus(String quizStatus) {
		this.quizStatus = quizStatus;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
	
	@Override
	public String toString() {
		return "QuizEntity [professorId=" + professorId + ", quizId=" + quizId + ", quizStatus=" + quizStatus
				+ ", dueDate=" + dueDate + ", timeLimit=" + timeLimit + ", quizType=" + quizType + ", quizTitle="
				+ quizTitle + ", quizInstruct=" + quizInstruct + ", questionsList=" + questionsList + "]";
	}

}
