/*
 * Comment
 * */

package com.Quizzer.code.model.response;

import java.io.Serializable;

public class Response_getQuizlist implements Serializable {

	private static final long serialVersionUID = 1L;
	private String quizId;
	private String quizName;
	public Response_getQuizlist(String quizId, String quizName) {
		this.quizName = quizName;
		this.quizId = quizId;
	}
	public String getQuizId() {
		return quizId;
	}
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
}