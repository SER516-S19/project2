package model;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface QuizDAO with the following method: a. get quizzes under this Course
 * b. enter quiz details c. get quiz Id
 * 
 * @author narenkumarkonchada
 * @author carnic
 * @version 1.1
 * @date 03/14/2019
 * 
 */
public interface QuizDAO {

	public List<QuizVO> getQuizzesForCourse(int courseId) throws SQLException, ClassNotFoundException;

	public void insertingQuizDetails(QuizVO quizVO) throws SQLException, ClassNotFoundException;

	public int gettingQuizId(QuizVO quizVO) throws SQLException, ClassNotFoundException;

	public List<QuizVO> getQuizzesForStudent(UserVO student) throws SQLException, ClassNotFoundException;

	public QuizVO getQuiz(int quizID) throws SQLException, ClassNotFoundException;

	public QuizVO getQuizInfo(int quizId) throws SQLException, ClassNotFoundException;
}
