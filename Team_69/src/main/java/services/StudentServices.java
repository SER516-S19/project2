package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import bean.*;
import com.google.gson.Gson;

import dao.CalculatedScoresDAO;
import dao.QuizDAO;
import dao.StatisticsDAO;
import dao.UserDAO;

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
	 * @param userId
	 * @return view
	 */
	public String feedAnswers(String studentResponse, int userId) {

		QuizDetails jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		UserDAO userDao = new UserDAO();
		User user = userDao.getUserById(userId);
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

	public List<String> fetchAllQuizNames() {
		QuizDAO quizDAO = new QuizDAO();
		return quizDAO.fetchAllQuizNames();
	}

	public int fetchQuizId(String quizName) {
		QuizDAO quizDAO = new QuizDAO();
		return quizDAO.fetchQuizId(quizName);
	}

	public List<String> fetchQuizStatus(List<String> quizNames, int userId) {
		List<String> status = new ArrayList<>();
		StatisticsDAO statisticsDAO = new StatisticsDAO();
		for (String quizName : quizNames) {
			int quizID = fetchQuizId(quizName);
			int count = statisticsDAO.checkQuizStatus(quizID, userId);
			if (count >= 1) {
				status.add("Answered");
			} else {
				status.add("Unanswered");
			}
		}
		return status;
	}

	public List<Integer> fetchAllQuizIds(List<String> quizNames) {
		List<Integer> quizIds = new ArrayList<>();
		for (String quizName : quizNames) {
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

	public int getGrade(String studentResponse, int userId) {
		QuizDetails jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		int quizId = jsonResponse.getQuizId();
		CalculatedScoresDAO dao = new CalculatedScoresDAO();
		int score = dao.getStudentScoreByQuizId(quizId, userId);
		return score;
	}

	public void calculateScores(String studentResponse, int userID) {
		QuizDetails jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		int quizID = jsonResponse.getQuizId();
		Map<Integer, Float> questionScore = new HashMap<>();
		List<QuestionDetails> questions = jsonResponse.getQuestion();

		CalculatedScores calculatedScores = new CalculatedScores();
		CalculatedScoresDAO scoresDAO = new CalculatedScoresDAO();

		for (QuestionDetails ques : questions) {
			int questionId = ques.getQuestionId();
			List<AnswerDetails> responseAnswer = ques.getResponseAnswer();
			List<AnswerDetails> availableAnswer = ques.getAvailableAnswers();
			int correctAnswer = 0;
			int correctResponseCount = 0;
			List<Integer> answerID = new ArrayList<>();
			for (AnswerDetails responseAns : responseAnswer) {
				answerID.add(responseAns.getAnswerId());
			}
			for (AnswerDetails answers : availableAnswer) {
				if (answers.getCorrectAnswer()) {
					if (answerID.contains(answers.getAnswerId())) {
						correctResponseCount++;
					}
					correctAnswer++;
				}
			}

			float points = ((float) correctResponseCount / (float) correctAnswer) * ques.getPoints();
			points = points - ((answerID.size() - correctResponseCount) * (ques.getPoints()/(float)ques.getAvailableAnswers().size()));
			points = points < 0 ? 0:points;
			questionScore.put(questionId, points);
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
}