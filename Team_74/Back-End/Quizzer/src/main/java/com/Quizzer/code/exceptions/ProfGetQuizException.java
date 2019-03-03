package com.Quizzer.code.exceptions;

/**
 * This class is the custom exception class for get quiz service.
 * 
 * @author Kirti Jha
 *
 */
public class ProfGetQuizException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String errorMessage;

	public ProfGetQuizException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
