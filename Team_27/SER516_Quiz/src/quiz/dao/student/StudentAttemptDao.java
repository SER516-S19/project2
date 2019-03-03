package quiz.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import quiz.dao.ConnectionFactory;
import quiz.exceptions.DataAccessException;
import quiz.model.professor.Question;
import quiz.model.student.QuizAttempt;

/**
 * StudentAttemptDao returns and stores all the attempted answers in the database
 * 
 * @author Manisha Miriyala, Sumanth
 * @version (1.0)
 */
public class StudentAttemptDao {

	private static Properties dbProperties = new Properties();
		static {
			try {
				dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
				Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	public static QuizAttempt getQuizAttempt(int quiz_id, int student_id) throws DataAccessException {
	// @SuppressWarnings("rawtypes") 
		//ArrayList<QuizAttempt> allRows = new ArrayList<QuizAttempt>();
		QuizAttempt quizAttempt = null;
		ResultSetMetaData resultSetMetaData;
		ArrayList<String> columnsValues = new ArrayList<String>(); 

		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs = null;
		String sql = dbProperties.getProperty("SELECT_ANSWERS_IN_QUIZ");
		try {
			/* Updating the preparedstatement with the answers attempted by student */
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1,quiz_id);
			preparedStatement.setInt(2,student_id);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				 	resultSetMetaData = rs.getMetaData();
			        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
			        	columnsValues.add(rs.getString(i));
			         }
			        quizAttempt = new QuizAttempt(Integer.parseInt(columnsValues.get(0)), Integer.parseInt(columnsValues.get(1)), Integer.parseInt(columnsValues.get(2)), columnsValues.get(4));
			        //allRows.add(quizAttempt);
			}
			
			return quizAttempt;
		} catch (SQLException e) {
			/* Transaction is aborted*/
			e.printStackTrace();
			return quizAttempt;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(
						"Unable to close resultset, database connection ");
			}
		}
	}
	
	public String getResult(ArrayList<Question> answers, String attempt) {
		String result = null;
		int correctAnswers = 0 , i=0;
		ArrayList<String> extractedAnswers = new ArrayList<String>();
		for(Question answer : answers) {
			for(int j=0;j<4;j++) {
				switch(j) {
					case 0: setIntoExtractedList(answer.getIsOptionACorrect(),j,extractedAnswers,0);break;
					case 1: setIntoExtractedList(answer.getIsOptionBCorrect(),j,extractedAnswers,1);break;
					case 2: setIntoExtractedList(answer.getIsOptionCCorrect(),j,extractedAnswers,2);break;
					case 3: setIntoExtractedList(answer.getIsOptionDCorrect(),j,extractedAnswers,3);break;
					default: continue;
				}
			}		
		}
		
		String[] attemptedAns;
		if(null != attempt.split("|"))
			attemptedAns = attempt.split("|");
		else {
			attemptedAns = new String[1];
			attemptedAns[0] = attempt;
		}
			
		
		for(String extAns :  extractedAnswers ) { 
			if(extAns.equals(attemptedAns[i].split(":")[1].trim()))
				correctAnswers++;
			i++;
		} 
		
		result = correctAnswers +"/"+ answers.size();
		return result;
	}

	public void setIntoExtractedList(Boolean option, int index, ArrayList<String> extAns,int newAns) {
		if(option) {
			if(extAns.get(index) != null) {
				extAns.set(index,extAns.get(index)+","+newAns);
			}else {
				extAns.set(index, ""+newAns);
			}
		}
	}
}
