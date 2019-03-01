package com.Quizzer.code.model.response;

import java.io.Serializable;
import java.util.List;
/**
 * 
 *  @author Kumar Prabhu Kalyan and Kirti Jha
 */
public class StatisticsResponseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> quizNames;
	private List<Double> averageMarks;
	public StatisticsResponseVO(List<String> quizNames, List<Double> averageMarks) {
		super();
		this.quizNames = quizNames;
		this.averageMarks = averageMarks;
	}
	
	public List<String> getQuizNames() {
		return quizNames;
	}
	public void setQuizNames(List<String> quizNames) {
		this.quizNames = quizNames;
	}
	public List<Double> getAverageMarks() {
		return averageMarks;
	}
	public void setAverageMarks(List<Double> averageMarks) {
		this.averageMarks = averageMarks;
	}
	
	
}
