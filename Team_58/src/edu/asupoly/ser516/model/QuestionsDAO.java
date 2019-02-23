package edu.asupoly.ser516.model;

import java.sql.SQLException;

/**
 * Interface QuestionsDAO with the following method: a. get questions under this
 * quiz
 * 
 * @author trupti
 * @version 1.0
 * @date 02/22/2019
 * 
 */
public interface QuestionsDAO {
	public void insertingQuestions(QuestionsVO questionsVO) throws SQLException, ClassNotFoundException;
}