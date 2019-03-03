package model;


import java.util.List;


/**
 * Interface StudentResponseDAO with the following method:
 * 	a. update studentResponse score based on quizId after grade quiz command
 * @author akashkadam
 * @version 1.0
 * 
 */
public interface StudentResponseDAO {

	public void updateStudentResponse(int quizId);

	
	public List<StudentResponseVO> getStudentListFromQuizIdQuestionId(int quizId, int questionId);
	
	public void updateStudentResponse(int quizId, int getqId, int userId,int score);

}
