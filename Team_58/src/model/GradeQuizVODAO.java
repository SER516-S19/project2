package model;

import java.sql.SQLException;
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
	public List<GradeQuizVO> getQuizGradesForStudent(int userId) throws SQLException, ClassNotFoundException;
}
