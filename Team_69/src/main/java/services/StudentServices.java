package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> origin/master

import bean.*;
import com.google.gson.Gson;

<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
import dao.QuizDAO;
import dao.StatisticsDAO;
=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
import dao.CalculatedScoresDAO;
import dao.QuizDAO;
import dao.StatisticsDAO;
import dao.UserDAO;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
>>>>>>> origin/master

/**
 * A class to get the JSON string to the student controller
 * 
 * @author amanjotsingh
 * @version 1.0
 * @since 02/21/2019
 * 
 */

public class StudentServices {
	
	public String getQuestionDetails(int quizId) {
		QuizUtility quizData = new QuizUtility();
		String jsonString = null;
		QuizDetails quizList = quizData.generator(quizId);
		jsonString = quizData.ObjectToJSON(quizList);
		return jsonString;
	}

	/**
	 * A method to store the students response in database and return the view as
	 * success if the response has been recorded.
	 * 
	 * @param studentResponse
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
	 * @return view
	 */
	public String feedAnswers(String studentResponse) {

		QuizDetails jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		User user = new User(5,"abc", "student", "abc.com", "1234");
=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
	 * @param userId 
	 * @return view
	 */
	public String feedAnswers(String studentResponse, int userId) {

		QuizDetails jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		UserDAO userDao = new UserDAO();
		User user = userDao.getUserById(userId);
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
>>>>>>> origin/master
		int quizId = jsonResponse.getQuizId();
		StatisticsDAO statisticsDAO = new StatisticsDAO();
		ResponseStatistics stats;
		List<QuestionDetails> questions = jsonResponse.getQuestion();
		Quiz quiz = new Quiz(quizId, jsonResponse.getQuizName(), jsonResponse.getQuizInstructions(),
				jsonResponse.getQuizType(), jsonResponse.getQuizTimeLimit(), jsonResponse.isShuffled(),
				jsonResponse.isPublished());
		for (QuestionDetails questionMapper : questions) {
			int questionId = questionMapper.getQuestionId();
			Question question = new Question(quiz, questionId, questionMapper.getQuestion(),
					questionMapper.isMultiple(), questionMapper.getPoints());
			List<AnswerDetails> answers = questionMapper.getResponseAnswer();
			if (answers != null) {
				for (AnswerDetails ansMapper : answers) {
					Answer answer = new Answer(question, ansMapper.getAnswerId(), ansMapper.getAnswer(),
							ansMapper.getCorrectAnswer());
					stats = new ResponseStatistics(user, quiz, question, answer);
					statisticsDAO.insertStudentResponse(stats);
				}
			}
		}
		return "/success";
	}

	public static QuizDetails convertStringtoJSON(String studentResponse) {
		Gson gson = new Gson();
		QuizDetails quizList = gson.fromJson(studentResponse, QuizDetails.class);
		return quizList;
	}

	public List<String> fetchAllQuizNames(){
		QuizDAO quizDAO = new QuizDAO();
		return quizDAO.fetchAllQuizNames();
	}

	public int fetchQuizId(String quizName){
		QuizDAO quizDAO = new QuizDAO();
		return quizDAO.fetchQuizId(quizName);
	}

<<<<<<< HEAD
<<<<<<< HEAD
	public List<String> fetchQuizStatus(List<String> quizNames,int userId){
=======
<<<<<<< HEAD
	public List<String> fetchQuizStatus(List<String> quizNames){
=======
	public List<String> fetchQuizStatus(List<String> quizNames,int userId){
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
	public List<String> fetchQuizStatus(List<String> quizNames,int userId){
>>>>>>> origin/master
		List<String> status = new ArrayList<>();
		StatisticsDAO statisticsDAO = new StatisticsDAO();
		for(String quizName : quizNames) {
			int quizID = fetchQuizId(quizName);
<<<<<<< HEAD
<<<<<<< HEAD
			int count = statisticsDAO.checkQuizStatus(quizID,userId);
=======
<<<<<<< HEAD
			long count = statisticsDAO.checkQuizStatus(quizID);
=======
			int count = statisticsDAO.checkQuizStatus(quizID,userId);
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
			int count = statisticsDAO.checkQuizStatus(quizID,userId);
>>>>>>> origin/master
			if(count>=1){
				status.add("Answered");
			}
			else {
				status.add("Unanswered");
			}
		}
		return status;
	}

	public List<Integer> fetchAllQuizIds(List<String> quizNames){
		List<Integer> quizIds = new ArrayList<>();
		for(String quizName : quizNames){
			int quizId = fetchQuizId(quizName);
			quizIds.add(quizId);
		}
		return quizIds;
	}
	
	public String getCurrentDateTime() {
		String pattern = "MMM dd HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateTime = simpleDateFormat.format(new Date());
		return dateTime; 
	}

<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
}
=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
	public int getGrade(String studentResponse, int userId) {
		QuizDetails jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		int quizId = jsonResponse.getQuizId();
		CalculatedScoresDAO dao = new CalculatedScoresDAO();
		int score = dao.getStudentScoreByQuizId(quizId, userId);
		return score;
	}

	public void calculateScores(String studentResponse, int userID){
		QuizDetails jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		int quizID = jsonResponse.getQuizId();
		Map<Integer, Integer> questionScore = new HashMap<>();
		List<QuestionDetails> questions = jsonResponse.getQuestion();

		CalculatedScores calculatedScores = new CalculatedScores();
		CalculatedScoresDAO scoresDAO = new CalculatedScoresDAO();

		for (QuestionDetails ques: questions){
			int questionId = ques.getQuestionId();
			List<AnswerDetails> responseAnswer = ques.getResponseAnswer();
			List<AnswerDetails> availableAnswer = ques.getAvailableAnswers();
			int correctAnswer = 0;
			int correctResponseCount = 0;
			List<Integer> answerID = new ArrayList<>();
			for(AnswerDetails responseAns: responseAnswer){
				answerID.add(responseAns.getAnswerId());
			}
			for(AnswerDetails answers: availableAnswer){
				if(answers.getCorrectAnswer() == true){
					if(answerID.contains(answers.getAnswerId())){
						correctResponseCount++;
					}
					correctAnswer++;
				}
			}
			int points = correctResponseCount/correctAnswer * ques.getPoints();
			questionScore.put(questionId,points);
		}
		float sumPoints = 0.0f;
		for (float questionPoints : questionScore.values()) {
			sumPoints += questionPoints;
		}

		Quiz quiz = new Quiz(quizID, jsonResponse.getQuizName(), jsonResponse.getQuizInstructions(),
				jsonResponse.getQuizType(), jsonResponse.getQuizTimeLimit(), jsonResponse.isShuffled(),
				jsonResponse.isPublished());
		UserDAO userDao = new UserDAO();
		User user = userDao.getUserById(userID);
		calculatedScores.setQuiz(quiz);
		calculatedScores.setUser(user);
		calculatedScores.setScore(sumPoints);
		scoresDAO.insertCalculatedScore(calculatedScores);
	}
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
}
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
}
>>>>>>> origin/master
