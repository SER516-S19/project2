package com.Quizzer.code.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * This class is a response model for single object responses.
 * @author Kumar Prabhu Kalyan
 */
public class ResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String status;
	private String errorMessage;
	private Object response;

	public ResponseVO(String status, String errorMessage, Object response) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(List<?> response) {
		this.response = response;
	}

}