package services;

import bean.Answer;
import bean.Question;
import bean.Quiz;
import dao.AnswerDAO;
import dao.ProfessorDAO;
import dao.QuestionDAO;
import java.util.List;

public class ProfessorServices {
	
	private static String name = "option";
	private ProfessorDAO professorDAO = new ProfessorDAO();
	

	public void storeQuestion(Quiz quiz, String question, String option1, String option2, String option3,
			String option4, String[] correctanswers, String points) {
		
		boolean isMutiple = false;
		boolean isCorrectAnswer = false;
		String[] optionArray = {option1, option2, option3, option4};
		Answer answer;
		AnswerDAO answerDAO = new AnswerDAO();
		
		if(correctanswers.length > 1)
			isMutiple = true;
		
		Question quest = new Question(quiz, question,isMutiple, Integer.parseInt(points));
		QuestionDAO questionDAO = new QuestionDAO();
		questionDAO.addQuestion(quest);
		
		for(int i=1; i<=optionArray.length; i++) {
			if(optionArray[i - 1] != null) {
			isCorrectAnswer = checkAnswerExist(i,correctanswers);
			answer = new Answer(quest, optionArray[i - 1], isCorrectAnswer);
			answerDAO.addAnswer(answer);
			}
		}
	}
	
	public List<Quiz> getAllQuizzes(){
		List<Quiz> lists = (List<Quiz>) professorDAO.getAllQuizzes();
		return lists;
	}
	
	public void publishQuiz(int quiz_id) {
		professorDAO.publishQuiz(quiz_id);
	}
	
	private boolean checkAnswerExist(int i, String[] correctanswers) {
		
		if(correctanswers ==  null)
			return false;
		
		for(String s: correctanswers)
			if((name+i).equals(s))
				return true;
		
		return false;
	}
}
