package model;


/**
 * Interface StudentResponseDAO with the following method:
 * 	a. update studentResponse score based on quizId after grade quiz command
 * @author akashkadam
 * @version 1.0
 * 
 */
public interface StudentResponseDAO {

	public void updateStudentResponse(int quizId);
	public void InsertQuizAnswers(int courseId , int quizId ,int userId , int questionId , String answerSelected , int score) ;
}
