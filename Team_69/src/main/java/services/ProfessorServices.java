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
	
	private static String name = "option";
	ProfessorDAO professorDAO = new ProfessorDAO();
	/**
	 * The method creates the question model and sends it to the DAO for processing
	 */
	public void storeQuestion(HttpServletRequest request) {
		String question = request.getParameter("question");
		String questionOption1 = request.getParameter("option1").trim();
		String questionOption2 = request.getParameter("option2").trim();
		String questionOption3 = request.getParameter("option3").trim();
		String questionOption4 = request.getParameter("option4").trim();
		String points = request.getParameter("points").trim();
		String[] correctanswers = request.getParameterValues("options");
		HttpSession session = request.getSession(true);
		Quiz quiz = (Quiz)session.getAttribute("quiz");
		
		boolean isMutiple = false;
		boolean isCorrectAnswer = false;
		String[] optionArray = {questionOption1, questionOption2, questionOption3, questionOption4};
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
		return professorDAO.getAllQuizzes();
	}
	
	public void publishQuiz(int quizId) {
		professorDAO.publishQuiz(quizId);
	}
	
	/**
	 * Check if correct answer exist.
	 */
	private boolean checkAnswerExist(int i, String[] correctanswers) {
		if(correctanswers ==  null)
			return false;
		for(String s: correctanswers)
			if((name+i).equals(s))
				return true;
		return false;
	}

	/**
	 * Insert quiz details and validate the input.
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
	 * Returns a new list having question details and corresponding options
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

}