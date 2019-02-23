package services;

import java.util.ArrayList;
import java.util.List;

import bean.*;
import com.google.gson.Gson;

import dao.QuizDAO;
import dao.StatisticsDAO;

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
	 * @return view
	 */
	public String feedAnswers(String studentResponse) {

		QuizDetails jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		User user = new User(5,"abc", "student", "abc.com", "1234");
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
		return quizDAO.fetchAllQuizName();
	}

	public int fetchQuizId(String quizName){
		QuizDAO quizDAO = new QuizDAO();
		return quizDAO.fetchQuizId(quizName);
	}

	public List<String> fetchQuizStatus(List<String> quizNames){
		List<String> status = new ArrayList<>();
		StatisticsDAO statisticsDAO = new StatisticsDAO();
		for(String quizName : quizNames) {
			int quizID = fetchQuizId(quizName);
			long count = statisticsDAO.checkQuizStatus(quizID);
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


}
