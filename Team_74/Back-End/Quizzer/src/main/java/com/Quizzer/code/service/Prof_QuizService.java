package com.Quizzer.code.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quizzer.code.dao.QuestionRepo;
import com.Quizzer.code.dao.QuizRepo;
import com.Quizzer.code.exceptions.Prof_AddQuiz_Exception;
import com.Quizzer.code.exceptions.Prof_GetQuiz_Exception;
import com.Quizzer.code.model.Question;
import com.Quizzer.code.model.Quiz;
import com.mongodb.MongoWriteException;

@Service
public class Prof_QuizService {

	@Autowired
	QuestionRepo questionrepo;

	@Autowired
	QuizRepo quizRepo;

	public void addQuiz(Quiz quiz) throws Prof_AddQuiz_Exception {

		if (quiz != null) {
			List<Question> listQuestion = quiz.getQuestions();
			try {
				quizRepo.insert(quiz);
				quiz.setTotalMarks(addQuestions(listQuestion, quiz.getId()));
				quizRepo.save(quiz);
			} catch (MongoWriteException e) {
				throw new Prof_AddQuiz_Exception("Error while writing the object to database." + e.getMessage());

			}

		} else {
			throw new Prof_AddQuiz_Exception("The quiz object is null");
		}

	}

	/**
	 * This method adds all the questions,calculates the total marks, in the quiz to
	 * the DB in Question table.
	 * 
	 * @param listQuestion
	 * @throws Prof_AddQuiz_Exception
	 */
	private int addQuestions(List<Question> listQuestion, String id) throws Prof_AddQuiz_Exception {
		int totalMarks = 0;
		if (listQuestion != null) {
			int iLengthQuestions = listQuestion.size();
			if (iLengthQuestions > 0) {
				for (Question question : listQuestion) {

					if (question.getMarks() == 0)
						throw new Prof_AddQuiz_Exception(
								"The mark for question with text: " + question.getQuestionText() + " is not entered");
					else
						totalMarks = totalMarks + question.getMarks();

					question.setQuizId(id);

					questionrepo.insert(question);

				}
			}
		} else {
			throw new Prof_AddQuiz_Exception(
					"No questions to add in the quiz," + " Please add questions before adding quiz");
		}
		return totalMarks;
	}

	public List<Quiz> getQuiz() throws Prof_GetQuiz_Exception {
		try {
			return quizRepo.findAll();
		} catch (Exception e) {
			throw new Prof_GetQuiz_Exception(e.getMessage());
		}
	}

	public Quiz getQuiz(String quizId) throws Prof_GetQuiz_Exception {
		if (quizId != null && !StringUtils.isEmpty(quizId)) {
		    Optional<Quiz> quiz= quizRepo.findById(quizId);
		    if(quiz!=null)
		    	return quiz.get();
		    else
		    	return null;
			
		}
		return null;
	}

}
