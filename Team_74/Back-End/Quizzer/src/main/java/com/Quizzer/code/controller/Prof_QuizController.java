package com.Quizzer.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Quizzer.code.service.Prof_QuizService;

@RestController
public class Prof_QuizController {

	@Autowired
	Prof_QuizService quiz;
}
