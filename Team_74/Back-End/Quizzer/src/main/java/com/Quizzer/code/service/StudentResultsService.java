package com.Quizzer.code.service;

import com.Quizzer.code.dao.SubmitQuizRepo;
import com.Quizzer.code.exceptions.StudentResultsException;
import com.Quizzer.code.model.db.SubmitQuiz;
import com.Quizzer.code.model.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This is the service layer for adding results of Quizzes taken.
 *
 * @author Abhinab Mohanty
 *
 */
@Service
public class StudentResultsService {

	@Autowired
	SubmitQuizRepo submitQuizRepo;

	/**
	 * This method handles the request and send appropriate response
	 * 
	 * @param submitQuiz
	 * @return
	 * @throws StudentResultsException
	 */
	public ResponseEntity<ResponseVO> addResult(SubmitQuiz submitQuiz) throws StudentResultsException {
		ResponseVO response = new ResponseVO(HttpStatus.OK.toString(), "", "");
		if (submitQuiz != null) {
			submitQuiz.setId(null);

			try {

				if (addResultRepo(submitQuiz)) {
					return new ResponseEntity<>(new ResponseVO(HttpStatus.OK.toString(), "", ""), HttpStatus.OK);
				}

			} catch (StudentResultsException e) {
				response.setStatus("500");
				response.setErrorMessage("Internal Server Error!");
				return new ResponseEntity<ResponseVO>(response, HttpStatus.OK);
			}
		}

		response.setStatus("400");
		response.setErrorMessage("Null Request");
		return new ResponseEntity<ResponseVO>(response, HttpStatus.OK);

	}

	/**
	 * This method adds individual entries into the database
	 * 
	 * @param submitQuiz
	 * @return
	 * @throws StudentResultsException
	 */
	private boolean addResultRepo(SubmitQuiz submitQuiz) throws StudentResultsException {
		try {
			submitQuiz.setMarksAchieved(submitQuiz.getMarksAchieved());
			submitQuiz.setQuiz(submitQuiz.getQuiz());
			submitQuiz.setQuizId(submitQuiz.getId());
			submitQuiz.setStudentId(submitQuiz.getStudentId());
			submitQuizRepo.insert(submitQuiz);

			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new StudentResultsException(ex.getMessage());
		}

	}
}
