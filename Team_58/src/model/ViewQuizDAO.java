package model;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.parser.ParseException;

/**
 * Interface
 * 
 * @author Aditya Samant
 * @version 1.0
 * @date 02/22/2019
 * 
 */

public interface ViewQuizDAO {
	public QuizVO getQuizInfo(int quizId) throws SQLException, ClassNotFoundException;
	public List<displayQuestionsVO> getQuestionsInfo(int quizId) throws SQLException, ClassNotFoundException, ParseException;
		
}
