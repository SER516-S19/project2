package com.Quizzer.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Quizzer.code.exceptions.Prof_AddQuiz_Exception;
import com.Quizzer.code.exceptions.Prof_GetQuiz_Exception;
import com.Quizzer.code.model.db.Quiz;
import com.Quizzer.code.model.response.ResponseListVO;
import com.Quizzer.code.model.response.ResponseVO;
import com.Quizzer.code.model.response.StatisticsResponseVO;
import com.Quizzer.code.service.ProfQuizService;
import com.Quizzer.code.service.ProfStatisticsService;

/**
 * This class is the controller that handles requests for : 1.Adding the quiz.
 * 2.Get list of quizzes. 3.Get a quiz based of id.
 * 
 * @author Kumar Prabhu Kalyan and Kirti Jha
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProfQuizController {

	@Autowired
	ProfQuizService quizService;

	/**
	 * This method handles the add quiz request.
	 * 
	 * @param quiz
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST, value = "/prof/quiz")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {

		try {
			quizService.addQuiz(quiz);
			return new ResponseEntity<>(new ResponseListVO(HttpStatus.ACCEPTED.toString(), null, null),
					HttpStatus.ACCEPTED);

		} catch (Prof_AddQuiz_Exception e) {
			return new ResponseEntity<>(new ResponseListVO(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), null),
					HttpStatus.ACCEPTED);
		}
	}

	/**
	 * This method returns a response with all the quizzes for the professor.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/prof/quiz")
	public ResponseEntity<?> getQuiz() {

		try {

			return new ResponseEntity<>(new ResponseListVO(HttpStatus.ACCEPTED.toString(), null, quizService.getQuiz()),
					HttpStatus.ACCEPTED);

		} catch (Prof_GetQuiz_Exception e) {
			return new ResponseEntity<>(
					new ResponseListVO(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getErrorMessage(), null),
					HttpStatus.ACCEPTED);
		}
	}

	/**
	 * This method returns a response with one quiz data according to the id.
	 * 
	 * @param quizId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/prof/quiz/{quizId}")
	public ResponseEntity<?> getQuiz(@PathVariable String quizId) {

		try {

			return new ResponseEntity<>(
					new ResponseVO(HttpStatus.ACCEPTED.toString(), null, quizService.getQuiz(quizId)),
					HttpStatus.ACCEPTED);

		} catch (Prof_GetQuiz_Exception e) {
			return new ResponseEntity<>(
					new ResponseVO(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getErrorMessage(), null),
					HttpStatus.ACCEPTED);
		}
	}
	

}
