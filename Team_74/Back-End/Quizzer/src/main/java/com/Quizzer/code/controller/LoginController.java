package com.Quizzer.code.controller;

import com.Quizzer.code.model.db.User;
import com.Quizzer.code.model.response.ResponseVO;
import com.Quizzer.code.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is the login controller. Which handles following: 1.Registration
 * of New User 2. Login Authentication of each user
 * 
 * @author Koushik Kotamraju GIT ID: 44
 * @author Abhinab Mohanty GIT ID: 53
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class LoginController {
	@Autowired
	LoginService loginService;

	/**
	 * Method for registration of New Users into the system
	 * 
	 * @param userDefine
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public @ResponseBody ResponseEntity<ResponseVO> register(@RequestBody User userDefine) {

		return loginService.addUser(userDefine);
	}

	/**
	 * Method for authentication of new Users into the system
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public @ResponseBody ResponseEntity<ResponseVO> login(@RequestBody User user) {

		return loginService.authenticateUser(user);
	}

}
