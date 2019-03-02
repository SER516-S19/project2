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
import javax.servlet.http.HttpSession;

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
	
	
	/**
	 * This method verifies question form data and add question details in Question table
	 */
	public void storeQuestion(HttpServletRequest request) {
		boolean isMutiple = false;
		boolean isCorrectAnswer = false;
		String question = request.getParameter("question");
		String[] optionArray = request.getParameterValues("questionOptions");
		
		for(String str: optionArray)
			str.trim();
		
		String points;
		
		if(request.getParameter("points").trim() ==  null) {
			points = "0";
			System.out.println("Inside points - " + points);
		}else {
			points = request.getParameter("points").trim();
			System.out.println("Inside points - " + points);
		}
		
		String[] correctanswers = request.getParameterValues("options");
		HttpSession session = request.getSession(true);
		Quiz quiz = (Quiz)session.getAttribute("quiz");
		request.setAttribute("id", quiz.getQuizId());
		request.setAttribute("quizName", quiz.getQuizName());	
		
		Answer answer;
		AnswerDAO answerDAO = new AnswerDAO();
	
		if(correctanswers.length > 1)
			isMutiple = true;
		else
			isMutiple = false;
		
		int point;
		if(points ==  null)
			point = 0;
		else
			try {
				point = Integer.parseInt(points);
			}catch(NumberFormatException e) {
				point = 0;
			}
		
		Question quest = new Question(quiz, question,isMutiple, point);
		QuestionDAO questionDAO = new QuestionDAO();
		questionDAO.addQuestion(quest);
		
		for(int option=1; option<=optionArray.length; option++) {
			if(optionArray[option - 1] != null) {
			isCorrectAnswer = checkAnswerExist(option,correctanswers);
			answer = new Answer(quest, optionArray[option - 1], isCorrectAnswer);
			answerDAO.addAnswer(answer);
			}
		}
	}
	
	
	public void saveEdited(HttpServletRequest request) {
		boolean isMultiple = false;
		boolean isCorrectAnswer = false;
		String question = request.getParameter("question");
		String questionOption1 = request.getParameter("option1").trim();
		String questionOption2 = request.getParameter("option2").trim();
		String questionOption3 = request.getParameter("option3").trim();
		String questionOption4 = request.getParameter("option4").trim();
		Integer questionId = Integer.parseInt(request.getParameter("questionId").trim());

		String points;
		
		if(request.getParameter("points").trim() ==  null) {
			points = "0";
			System.out.println("Inside points - " + points);
		}else {
			points = request.getParameter("points").trim();
			System.out.println("Inside points - " + points);
		}
		
		String[] correctanswers = request.getParameterValues("options");
		
		String[] optionArray = {questionOption1, questionOption2, questionOption3, questionOption4};
		Answer answer;
		AnswerDAO answerDAO = new AnswerDAO();
	
		if(correctanswers.length > 1)
			isMultiple = true;
		else
			isMultiple = false;
		
		int point;
		if(points ==  null)
			point = 0;
		else
			try {
				point = Integer.parseInt(points);
			}catch(NumberFormatException e) {
				point = 0;
			}

		QuestionDAO questionDAO = new QuestionDAO();
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
	public void insertQuizDetails(HttpServletRequest request) {
		HttpSession sess = request.getSession(true);
		String quizName = request.getParameter("name");
        String quizInstructions = request.getParameter("instructions");
        String quizType = request.getParameter("quiz_type");
        sess.setAttribute("quizType", quizType);
        String isTimeLimitSet = request.getParameter("time_limit");
        String quizTimeLimit = "00:00:00";
        boolean isShuffled = false;
        boolean isPublished = false;

        if(isTimeLimitSet!=null)
        {
        	String hours = request.getParameter("hours");
        	String minutes = request.getParameter("minutes");
        	if(hours.length() == 0)
        		hours = "0";        	
        	if(minutes.length() == 0)
        		minutes = "0";
        	if (hours.length() == 1)
        			hours = "0" + hours;
        	if (minutes.length() == 1)
        		minutes = "0" + minutes;
        	quizTimeLimit = hours+":"+minutes+":00";
        }
        if(request.getParameter("shuffle")!=null)
        	isShuffled = true;
        
		Quiz quiz = new Quiz(quizName, quizInstructions, quizType, quizTimeLimit, isShuffled, isPublished);
		sess.setAttribute("quiz", quiz);
		professorDAO.insertQuizDetails(quiz);
	}

	public List<Question> getAllQuestionFromQuizID(int quizid){
		return professorDAO.getAllQuestionFromQuizID(quizid);
	}
	
	/**
	 * This method generates list containing quiz name, question details and related answers
	 */
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


	public Quiz getQuizFromID(int quizId) {
		ProfessorDAO professorDAO = new ProfessorDAO();
		Quiz quiz = professorDAO.getQuizFromID(quizId);
		return quiz;
	}

}