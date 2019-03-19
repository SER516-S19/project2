/*
 * This class contains stores and returns Quiz Ids and Names
 * */

package com.Quizzer.code.model.response;

import java.io.Serializable;

/**
 * This class is the quiz list model.
 *
 * @author Kumar Prabhu Kalyan
 *
 */
public class ResponseQuizListVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String quizId;
	private String quizName;

	public ResponseQuizListVO(String quizId, String quizName) {
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
