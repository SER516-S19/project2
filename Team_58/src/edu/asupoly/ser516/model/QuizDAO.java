package edu.asupoly.ser516.model;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface QuizDAO with the following method:
 * 	a. get quizzes under this Course
 * 
 * @author narenkumarkonchada
 * @version 1.0
 * @date 02/21/2019
 * 
 */
public interface QuizDAO {
	public List<QuizVO> getQuizzesForCourse(int courseId) throws SQLException, ClassNotFoundException;
}
