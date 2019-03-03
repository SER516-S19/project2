package model;

import java.sql.SQLException;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
 * Interface QuestionsDAO with the following method: a. get questions under this
 * quiz
 * 
 * @author trupti khatavkar
 * @version 1.0
 * @date 02/22/2019
 * 
 */
public interface QuestionsDAO {
	public void insertingQuestions(QuestionsVO questionsVO) throws SQLException, ClassNotFoundException;


	public List<displayQuestionsVO> getQuestionsForQuiz(int quizID) throws SQLException, ClassNotFoundException, ParseException;
	public List<displayQuestionsVO> getStudentQuestionsForInfo(int quizID) throws SQLException, ClassNotFoundException, ParseException;

	public void updateQuestionsTable(String question, String answer, String wrongOne,
			String wrongTwo, String wrongThree, int points, int qId)throws SQLException, ClassNotFoundException;
	
	public List<QuestionsVO> getQuestionsInfo(int quizID) throws SQLException, ClassNotFoundException;

}