package content.creator.helper;

import content.creator.dao.QuizResultDAO;
import java.sql.SQLException;
import java.util.List;
/*
 *Modified by :Sakshi Gautam
 * Description: The following file creates methods for the total no of quizes and total score by every student.
 */
public class StatsPerStudentHelper {

	public static float getTotalScore(List<QuizResultDAO> studentDetails) throws SQLException {
		float totalScore = 0;
		try {
			for (QuizResultDAO quizResult : studentDetails) {
				totalScore += quizResult.getFinalScore();
			}
		} catch (ArithmeticException aE) {
			totalScore = (float) 0;
		}
		return totalScore;
	}
}
