package services;

import java.util.ArrayList;
import bean.Answer;
import bean.Question;
import bean.Quiz;
import dao.AnswerDAO;
import dao.ProfessorDAO;
import dao.QuestionDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * This is the service class for manipulating data models.
 *
 * @version 1.0
 * @since 02-16-2019
 * @authors Aneesh, Gangadhar,  Viraj
 */
public class ProfessorServices {
	
	private final String OPTIONS = "option";
	private static ProfessorDAO professorDAO = new ProfessorDAO();
	AnswerDAO answerDAO = new AnswerDAO();
	QuestionDAO questionDAO = new QuestionDAO();
	
	/**
	 * This method verifies question form data and add question details in Question table
	 */
	public void storeQuestion(String question, String[] optionArray, String points, String[] correctanswers, Quiz quiz) {
		boolean isMutiple = false;
		boolean isCorrectAnswer = false;
		Answer answer = null;
		int point;

		for(String str: optionArray)
			str.trim();
		
		if(points.trim() ==  null) {
			points = "0";
		}
		
		try {
			point = Integer.parseInt(points);
		}catch(NumberFormatException e) {
			point = 0;
		}
	
		isMutiple = (correctanswers.length > 1) ? true : false;
		
		Question quest = new Question(quiz, question,isMutiple, point);
		questionDAO.addQuestion(quest);
		
		for(int option=1; option<=optionArray.length; option++) {
			if(optionArray[option - 1] != null) {
			isCorrectAnswer = checkAnswerExist(option,correctanswers);
			answer = new Answer(quest, optionArray[option - 1], isCorrectAnswer);
			answerDAO.addAnswer(answer);
			}
		}
	}
	
	/**
	 * The method takes the edited question data and saves it to the database 
	 */
	public void saveEdited(HttpServletRequest request) {
		boolean isMultiple = false;
		boolean isCorrectAnswer = false;
		String question = request.getParameter("question");
		String questionOption1 = fetchValue(request, "option1");
		String questionOption2 = fetchValue(request, "option2");
		String questionOption3 = fetchValue(request, "option3");
		String questionOption4 = fetchValue(request, "option4");
		String[] optionArray = {questionOption1, questionOption2, questionOption3, questionOption4};
		Answer answer;
		String points;
		Integer questionId = Integer.parseInt(request.getParameter("questionId").trim());
		String[] correctanswers = null;
		
		try {
			correctanswers = request.getParameterValues("options");
		}catch(NullPointerException e) {
			correctanswers = null;
		}
		
		if(request.getParameter("points").trim() ==  null)
			points = "0";
		else
			points = request.getParameter("points").trim();
	
		isMultiple = (correctanswers.length > 1) ? true : false;
		int point;
		if(points ==  null)
			point = 0;
		else
			try {
				point = Integer.parseInt(points);
			}catch(NumberFormatException e) {
				point = 0;
			}

		Question questionOld = professorDAO.getQuestionFromID(questionId);
		questionOld.setQuestion(question);
		questionOld.setPoints(point);
		questionOld.setMultiple(isMultiple);
		questionDAO.updateQuestion(questionOld);
		answerDAO.deleteAnswer(questionId);
		for(int option=1; option<=optionArray.length; option++) {
			if(optionArray[option - 1] != null) {
			isCorrectAnswer = checkAnswerExist(option,correctanswers);
			answer = new Answer(questionOld, optionArray[option - 1], isCorrectAnswer);
			answerDAO.addAnswer(answer);
			}
		}
	}
	

	private String fetchValue(HttpServletRequest request, String option) {
		String questionOption = null;
		try {
			if(request.getParameter(option).trim() != null)
				questionOption = request.getParameter(option).trim();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		return questionOption;
	}
	
	public List<Quiz> getAllQuizzes(){
		return professorDAO.getAllQuizzes();
	}
	
	public void publishQuiz(int quizId) {
		professorDAO.publishQuiz(quizId);
	}
	
	/**
	 * This method checks if correct answer exists in correctAnswers array.
	 */
	private boolean checkAnswerExist(int i, String[] correctAnswers) {
		if(correctAnswers ==  null)
			return false;
		for(String s: correctAnswers)
			if((OPTIONS+i).equals(s))
				return true;
		return false;
	}

	/**
	 * This method validates provided input from quiz form and insert data into Quiz table.
	 */
	public Quiz insertQuizDetails(String quizName, String quizInstructions, String quizType,
			String isTimeLimitSet, String hours, String minutes, String shuffle) {
		
		String quizTimeLimit = "00:00:00";
        boolean isShuffled = false;
        boolean isPublished = false;

        if(isTimeLimitSet!=null)
        {
        	if(hours.length() == 0)
        		hours = "00";        	
        	if(minutes.length() == 0)
        		minutes = "00";
        	if (hours.length() == 1)
        			hours = "0" + hours;
        	if (minutes.length() == 1)
        		minutes = "0" + minutes;
        	quizTimeLimit = hours+":"+minutes+":00";
        }
        if(shuffle !=null)
        	isShuffled = true;
        
		Quiz quiz = new Quiz(quizName, quizInstructions, quizType, quizTimeLimit, isShuffled, isPublished);
		professorDAO.insertQuizDetails(quiz);
		return quiz;
	}

	public List<Question> getAllQuestionFromQuizID(int quizid){
		return professorDAO.getAllQuestionFromQuizID(quizid);
	}
	
	/**
	 * This method generates list containing quiz name, question details and related answers
	 */
	public List getAllAnswersFromQuestionList(List<Question> questions) {
		List questionData = new ArrayList<>();	
		for(Question question : questions) {
			int queID = question.getQuestionId();
			List<Object> questionInfo = new ArrayList<>();
			questionInfo.add(question.getQuestion());
			questionInfo.add(question.getPoints());
			List<Answer> answers = professorDAO.getAllAnswersFromQuestionID(queID);
			questionInfo.add(answers);
			questionInfo.add(question.getQuestionId());
			questionData.add(questionInfo);
		}
		return questionData;	
	}

	/**
	 * This method is used to get quiz details based on the quiz id
	 */
	public Quiz getQuizFromID(int quizId) {
		Quiz quiz = professorDAO.getQuizFromID(quizId);
		return quiz;
	}

	public void deleteQuestionByQuestionId(String quesID) {
		QuestionDAO questionDAO = new QuestionDAO();
		questionDAO.deleteQuestionByQuestionId(quesID);
	}
}