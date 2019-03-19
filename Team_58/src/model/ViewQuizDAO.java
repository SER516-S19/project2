package model;

import java.sql.SQLException;
import java.util.List;
import org.json.simple.parser.ParseException;


/**
 * Interface
 * 
 * @author Aditya Samant
 * @version 1.1
 * @date 03/14/2019
 */
public interface ViewQuizDAO {
	
	public QuizVO getQuizInfo(int quizId) throws SQLException, ClassNotFoundException;
	public List<displayQuestionsVO> getStudentQuestionsInfo(int quizId) throws SQLException, ClassNotFoundException, ParseException;
	public List<QuestionVO> getQuestionsInfo(int quizId) throws SQLException, ClassNotFoundException, ParseException;	

}
