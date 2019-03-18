package model;

import java.util.List;

/**
 * Interface StudentResponseDAO with the following method:
 *  a. update studentResponse score based on quizId after grade quiz command
 * @author akashkadam
 * @version 1.1
 * @date 03/14/2019
 */
public interface StudentResponseDAO {

	public void updateStudentResponse(int quizId);
	public void insertQuizAnswers(int courseId , int quizId ,int userId , int questionId , String answerSelected , int score) ;
	public List<StudentResponseVO> getStudentListFromQuizIdQuestionId(int quizId, int questionId);
	public void updateStudentResponse(int quizId, int getqId, int userId,int score);
	public void updateStudentResponse(int courseId , int quizId ,int userId , int questionId , String answerSelected );
}
