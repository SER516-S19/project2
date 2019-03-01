package model;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface QuizDAO with the following method:
 * 	a. get quizzes under this Course
 *  b. enter quiz details
 *  c. get quiz Id
 * 
 * @author narenkumarkonchada & carnic
 * @version 1.0
 * @date 02/21/2019
 * 
 */
public interface QuizDAO {
	public List<QuizVO> getQuizzesForCourse(int courseId) throws SQLException, ClassNotFoundException;
	public void insertingQuizDetails (CreateQuizVO createQuizVO) throws  SQLException, ClassNotFoundException;
	public int gettingQuizId (CreateQuizVO createQuizVO) throws  SQLException, ClassNotFoundException;
	public List<QuizVO> getQuizzesForStudent(UserVO student) throws SQLException, ClassNotFoundException;
	public QuizVO getQuiz(int quizID) throws SQLException, ClassNotFoundException;
}
