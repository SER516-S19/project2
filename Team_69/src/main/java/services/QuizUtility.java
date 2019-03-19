package services;

import java.util.ArrayList;
import java.util.List;

import bean.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.AnswerDAO;
import dao.QuestionDAO;

/**
 * A class to combine the questions with its answers
 * 
 * @author: leharbhatt
 * @version: 1.0
 * @since : 02/20/2019
 *
 */

public class QuizUtility {
	/**
	 * Generates an QuizDetails object that stores the details of the quiz including
	 * its questions, corresponding answer choices, correct answer and other quiz
	 * details.
	 * 
	 * @param quizId
	 * @return
	 */
	public QuizDetails generator(int quizId) {
		QuestionDAO questionDao = new QuestionDAO();
		AnswerDAO answerDao = new AnswerDAO();
		QuizDetails questionAnswers = new QuizDetails();
		List<Question> questionList = questionDao.getQuestionsByQuizId(quizId);
		if (questionList.size() != 0) {
			Quiz quiz = questionList.get(0).getQuiz();
			questionAnswers.setQuizId(quiz.getQuizId());
			questionAnswers.setQuizName(quiz.getQuizName());
			questionAnswers.setQuizInstructions(quiz.getQuizInstructions());
			questionAnswers.setPublished(quiz.getIsPublished());
			questionAnswers.setShuffled(quiz.isShuffled());
			questionAnswers.setQuizType(quiz.getQuizType());
			questionAnswers.setQuizTimeLimit(quiz.getQuizTimeLimit());
		}
		List<QuestionDetails> questionDetailsList = new ArrayList<QuestionDetails>();
		for (Question question : questionList) {
			QuestionDetails questionDetails = new QuestionDetails();
			questionDetails.setMultiple(question.isMultiple());
			questionDetails.setPoints(question.getPoints());
			questionDetails.setQuestion(question.getQuestion());
			questionDetails.setQuestionId(question.getQuestionId());
			questionDetails.setResponseAnswer(new ArrayList<AnswerDetails>());
			List<AnswerDetails> answerDetailsList = new ArrayList<AnswerDetails>();
			List<Answer> answersList = answerDao.getAnswersByQuestionId(question.getQuestionId());
			for (Answer answer : answersList) {
				AnswerDetails answerDetails = new AnswerDetails();
				answerDetails.setAnswer(answer.getAnswer());
				answerDetails.setAnswerId(answer.getAnswerId());
				answerDetails.setCorrectAnswer(answer.getCorrectAnswer());
				answerDetailsList.add(answerDetails);
			}
			questionDetails.setAvailableAnswers(answerDetailsList);
			questionDetailsList.add(questionDetails);
		}
		questionAnswers.setQuestion(questionDetailsList);
		return questionAnswers;
	}

	public String ObjectToJSON(QuizDetails quizList) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(quizList);
		return result;
	}
}
