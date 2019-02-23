package services;


import java.util.ArrayList;
import java.util.List;

import bean.Answer;
import bean.Question;
import bean.Quiz;
import dao.ProfessorDAO;

public class ProfessorServices {
	ProfessorDAO professorDAO = new ProfessorDAO();
	
	public List<Quiz> getAllQuizzes(){
		
		List<Quiz> lists = professorDAO.getAllQuizzes();
		return lists;
	}
	
	public void publishQuiz(int quiz_id) {
		professorDAO.publishQuiz(quiz_id);
		
	}
	
	public List<Question> getAllQuestionFromQuizID(int quizid){
		
		List<Question> questions =  professorDAO.getAllQuestionFromQuizID(quizid);
		return questions;
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllAnswersFromQueList(List<Question> questions) {
		
		List questionData = new ArrayList<>();	
		
		for(Question question : questions) {
			int queID = question.getQuestionId();
			List questionInfo = new ArrayList<>();
			questionInfo.add(question.getQuestion());
			questionInfo.add(question.getPoints());
			List<Answer> answers = professorDAO.getAllAnswersFromQuestionID(queID);
			questionInfo.add(answers);
			questionInfo.add(question.getQuestionId());
			questionData.add(questionInfo);
		}
		
		
		return questionData;	
		
	}
	
}
