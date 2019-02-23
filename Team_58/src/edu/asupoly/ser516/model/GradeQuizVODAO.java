package edu.asupoly.ser516.model;

import java.util.List;

/**
 * Interface StudentResponseDAO with the following method:
 * a. get GradeVO list 
 * @author akashkadam
 * @version 1.0
 * 
 */
public interface GradeQuizVODAO {

	public List<GradeQuizVO> getgradeQuiz(int quizId,String quizName);
}
