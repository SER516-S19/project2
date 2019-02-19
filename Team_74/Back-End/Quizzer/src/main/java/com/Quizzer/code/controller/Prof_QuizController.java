package com.Quizzer.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.Quizzer.code.exceptions.Prof_AddQuiz_Exception;
import com.Quizzer.code.exceptions.Prof_GetQuiz_Exception;
import com.Quizzer.code.model.Quiz;
import com.Quizzer.code.model.Response;
import com.Quizzer.code.service.Prof_QuizService;

@RestController
public class Prof_QuizController {

	@Autowired
	Prof_QuizService quizService;

	@RequestMapping(method = RequestMethod.POST, value = "/prof/add")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {

		try {
			quizService.addQuiz(quiz);
			return new ResponseEntity<>(new Response(HttpStatus.ACCEPTED.toString(), null, null), HttpStatus.ACCEPTED);

		} catch (Prof_AddQuiz_Exception e) {
			return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), null),
					HttpStatus.ACCEPTED);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/prof/getquiz")
	public ResponseEntity<?> getQuiz(){
		
		try {
			return new ResponseEntity<>(new Response(HttpStatus.ACCEPTED.toString(), null, quizService.getQuiz()),
					HttpStatus.ACCEPTED);
		} catch (Prof_GetQuiz_Exception e){
			return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getErrorMessage(), null),
					HttpStatus.ACCEPTED);
		}
	}
}
