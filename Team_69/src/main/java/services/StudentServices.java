package services;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

import bean.Answer;
import bean.AnswerMapper;
import bean.Question;
import bean.QuestionAnswer;
import bean.QuestionMapper;
import bean.Quiz;
import bean.ResponseStatistics;
import bean.User;
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
		QuestionAnswerGenerator quizData = new QuestionAnswerGenerator();
		String jsonString = null;
		QuestionAnswer quizList = quizData.generator(quizId);
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

		QuestionAnswer jsonResponse = StudentServices.convertStringtoJSON(studentResponse);
		User user = new User(5,"abc", "student", "abc.com", "1234");
		int quizId = jsonResponse.getQuizId();
		StatisticsDAO statisticsDAO = new StatisticsDAO();
		ResponseStatistics stats;
		List<QuestionMapper> questions = jsonResponse.getQuestion();
		Quiz quiz = new Quiz(quizId, jsonResponse.getQuizName(), jsonResponse.getQuizInstructions(),
				jsonResponse.getQuizType(), jsonResponse.getQuizTimeLimit(), jsonResponse.isShuffled(),
				jsonResponse.isPublished());
		for (QuestionMapper questionMapper : questions) {
			int questionId = questionMapper.getQuestionId();
			Question question = new Question(quiz, questionId, questionMapper.getQuestion(),
					questionMapper.isMultiple(), questionMapper.getPoints());
			List<AnswerMapper> answers = questionMapper.getResponseAnswer();
			if (answers != null) {
				for (AnswerMapper ansMapper : answers) {
					Answer answer = new Answer(question, ansMapper.getAnswerId(), ansMapper.getAnswer(),
							ansMapper.getCorrectAnswer());
					stats = new ResponseStatistics(user, quiz, question, answer);
					statisticsDAO.insertStudentResponse(stats);
				}
			}
		}

		return "/success";

	}

	private static QuestionAnswer convertStringtoJSON(String studentResponse) {
		Gson gson = new Gson();
		QuestionAnswer quizList = gson.fromJson(studentResponse, QuestionAnswer.class);
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
