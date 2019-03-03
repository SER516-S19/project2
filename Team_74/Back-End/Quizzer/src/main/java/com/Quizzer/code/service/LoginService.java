package com.Quizzer.code.service;

import com.Quizzer.code.dao.UserRepo;
import com.Quizzer.code.exceptions.LoginException;
import com.Quizzer.code.model.db.User;
import com.Quizzer.code.model.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class is the model for User data.
 *
 * @author Koushik Kotamraju GIT ID: 44
 * @author Abhinab Mohanty GIT ID: 53
 *
 */

@Service
public class LoginService {

	@Autowired
	private UserRepo userRepo;
	private User user = null;

	/**
	 * This method authenticates each incoming request with the database
	 * 
	 * @param user
	 * @return
	 */
	public ResponseEntity<ResponseVO> authenticateUser(User user) {
		User loginCred = user;
		if (ifEmailIdExists(loginCred.getUserEmailId())) {
			user = userRepo.findByUserEmailId(loginCred.getUserEmailId());
			if (user.getUserPassword().equals(loginCred.getUserPassword())) {
				return new ResponseEntity<>(new ResponseVO(HttpStatus.OK.toString(), "", user), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseVO("104", "Wrong Password", null), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(new ResponseVO("105", "User does not exist", null), HttpStatus.OK);
	}

	/**
	 * This method adds each entry into the database
	 * 
	 * @param userDefine
	 * @return
	 * @throws LoginException
	 */
	public boolean addUserRepo(User userDefine) throws LoginException {
		try {
			userDefine.setUserPassword(userDefine.getUserPassword());
			userRepo.insert(userDefine);

			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new LoginException(ex.getMessage());
		}

	}

	/**
	 * This method handles the request and send appropriate response
	 * 
	 * @param user
	 * @return
	 */

	public ResponseEntity<ResponseVO> addUser(User user) {
		ResponseVO response = new ResponseVO(HttpStatus.OK.toString(), "", "");

		if (!validateUserRequest(response, user)) {
			return new ResponseEntity<ResponseVO>(response, HttpStatus.OK);
		}
		try {

			if (addUserRepo(user)) {
				return new ResponseEntity<>(new ResponseVO(HttpStatus.OK.toString(), "", ""), HttpStatus.OK);
			}

		} catch (LoginException e) {
			response.setStatus("500");
			response.setErrorMessage("Internal Server Error!");
			return new ResponseEntity<ResponseVO>(response, HttpStatus.OK);
		}

		response.setStatus("400");
		response.setErrorMessage("Bad Request");
		return new ResponseEntity<ResponseVO>(response, HttpStatus.OK);
	}

	public boolean ifEmailIdExists(String strEmailId) {
		return (null != userRepo.findByUserEmailId(strEmailId));

	}

	private boolean validateUserRequest(ResponseVO response, User user) {
		if (ifEmailIdExists(user.getUserEmailId())) {
			response.setStatus("103");
			response.setErrorMessage("Email Id is already registered !");
			return false;
		}

		return true;
	}

}
