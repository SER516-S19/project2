package com.Quizzer.code.exceptions;

/**
 * This class is the custom exception class for add quiz service.
 * 
 * @author Kumar Prabhu Kalyan
 *
 */
public class ProfAddQuizException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String errorMessage;

	public ProfAddQuizException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
