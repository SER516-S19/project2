package com.Quizzer.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quizzer.code.dao.QuestionRepo;
import com.Quizzer.code.exceptions.Prof_AddQuiz_Exception;
import com.Quizzer.code.model.Question;
import com.Quizzer.code.model.Quiz;

@Service
public class Prof_QuizService {

	@Autowired
	QuestionRepo questionrepo;

	public void addQuiz(Quiz quiz) throws Prof_AddQuiz_Exception {

		if (quiz != null) {
			List<Question> listQuestion = quiz.getQuestions();
			addQuestions(listQuestion);
		} else {
			throw new Prof_AddQuiz_Exception("The quiz object is null");
		}

	}

	/**
	 * This method adds all the questions in the quiz to the DB in Question table.
	 * 
	 * @param listQuestion
	 * @throws Prof_AddQuiz_Exception
	 */
	private void addQuestions(List<Question> listQuestion) throws Prof_AddQuiz_Exception {
		if (listQuestion != null) {
			int iLengthQuestions = listQuestion.size();
			if (iLengthQuestions > 0) {
				for (Question question : listQuestion) {
					questionrepo.insert(question);
				}
			}
		} else {
			throw new Prof_AddQuiz_Exception(
					"No questions to add in the quiz," + " Please add questions before adding quiz");
		}
	}

}
