package com.Quizzer.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Quizzer.code.exceptions.StudentResultsException;
import com.Quizzer.code.model.db.SubmitQuiz;
import com.Quizzer.code.model.response.ResponseVO;
import com.Quizzer.code.service.StudentResultsService;

/**
 * This class is the controller that logs the results of a student in a quiz
 *
 * @author Abhinab Mohanty
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StudentsResultsController {

	@Autowired
	StudentResultsService studentResultsService;

	/**
	 * This method handles filling of Quiz Results in database
	 * 
	 * @param submitQuiz
	 * @return
	 * @throws StudentResultsException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/results")
	public ResponseEntity<?> addResult(@RequestBody SubmitQuiz submitQuiz) throws StudentResultsException {

		try {

			studentResultsService.addResult(submitQuiz);
			return new ResponseEntity<>(new ResponseVO(HttpStatus.ACCEPTED.toString(), null, null),
					HttpStatus.ACCEPTED);

		} catch (StudentResultsException e) {
			return new ResponseEntity<>(new ResponseVO(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), null),
					HttpStatus.ACCEPTED);
		}
	}
}
