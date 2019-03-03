package com.Quizzer.code.exceptions;

/**
 * This class is the exception class for User data.
 *
 * @author Koushik Kotamraju GIT ID: 44
 * @author Abhinab Mohanty GIT ID: 53
 *
 */

public class LoginException extends Exception {
	private static final long serialVersionUID = 1L;

	private final String errorMessage;

	public LoginException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
