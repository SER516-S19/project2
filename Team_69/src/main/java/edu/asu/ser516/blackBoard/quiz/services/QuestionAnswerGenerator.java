package edu.asu.ser516.blackBoard.quiz.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import edu.asu.ser516.blackBoard.quiz.bean.Question;
import edu.asu.ser516.blackBoard.quiz.bean.QuestionAnswer;
import edu.asu.ser516.blackBoard.quiz.dao.QuestionDAO;

public class QuestionAnswerGenerator {
	public List<QuestionAnswer> generator(int quizId){
		QuestionDAO questionDao = new QuestionDAO();
		List<Question> questionList = questionDao.getQuestionsByQuizId(quizId);
		List<QuestionAnswer> questionAnswerList = new ArrayList<QuestionAnswer>();
		for(Question question: questionList) {
			question.getQuestionId();
			//get answer

			QuestionAnswer questionAnswer = new QuestionAnswer();
			questionAnswer.setQuestionId(question.getQuestionId());
			questionAnswer.setQuiz(question.getQuiz());
			questionAnswer.setQuestion(question.getQuestion());
			questionAnswer.setPoints(question.getPoints());
			questionAnswer.setMultiple(question.isMultiple());
			//questionAnswer.setAnswerList("");
			questionAnswerList.add(questionAnswer);
			
		}
		return questionAnswerList;
		
	}
	
	public String ObjectToJSON(List<QuestionAnswer> list) {
		Gson gson = new Gson();
		String result = gson.toJson(list);
		return result;
	}
}
