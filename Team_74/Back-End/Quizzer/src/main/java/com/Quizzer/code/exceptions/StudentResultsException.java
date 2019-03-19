package com.Quizzer.code.exceptions;

/**
 * This class is the exception class for Results Data Posting.
 * 
 * @author Abhinab Mohanty GIT ID: 53
 *
 */
public class StudentResultsException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String errorMessage;

	public StudentResultsException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
