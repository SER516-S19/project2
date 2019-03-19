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
			/* Connecting to the database */
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
			Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	public static QuizAttempt getQuizAttempt(int quiz_id, int student_id) throws DataAccessException {
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
			     quizAttempt = new QuizAttempt(Integer.parseInt(columnsValues.get(0)),
			    		 Integer.parseInt(columnsValues.get(1)), Integer.parseInt(columnsValues.get(2)), 
			    		 columnsValues.get(3));
			}return quizAttempt;
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
				System.out.println("Unable to close resultset, database connection ");
			}
		}
	}
	public String getResult(ArrayList<Question> answers, String attempt) {
		String result = null;
		int correctAnswers = 0 , i=0;
		int finalPoints = 0, totalPoints = 0 ;
		ArrayList<String> extractedAnswers = new ArrayList<String>();
		ArrayList<Integer> points = new ArrayList<Integer>();
		for(Question answer : answers) {
			extractedAnswers.add(null);
		}
		i=0;
		for(Question answer : answers) {
			points.add(answer.getPoints());
			totalPoints += answer.getPoints();
			for(int j=0;j<4;j++) {
				switch(j) {
					case 0: setIntoExtractedList(answer.getIsOptionACorrect(),i,extractedAnswers,0);
							break;
					case 1: setIntoExtractedList(answer.getIsOptionBCorrect(),i,extractedAnswers,1);
							break;
					case 2: setIntoExtractedList(answer.getIsOptionCCorrect(),i,extractedAnswers,2);
							break;
					case 3: setIntoExtractedList(answer.getIsOptionDCorrect(),i,extractedAnswers,3);
							break;
				}
			}		
			i++;
		}		
		String[] attemptedAns;
		attempt = attempt.substring(1,attempt.length()-1);
		System.out.println("Value of attempt="+attempt);
		try {
			attemptedAns = attempt.split(",");
		}catch(Exception e) {
			System.out.println("There only exists a single element");
			attemptedAns = new String[1];
			attemptedAns[0] = attempt;
		}	
		i=0;
		for(;i<extractedAnswers.size();i++) { 
			System.out.println("Extracted Answers="+extractedAnswers.get(i));
			String extAns = "\"" + extractedAnswers.get(i) + "\"";
			String splitString = attemptedAns[i].split(":")[1];
			System.out.println(splitString+"xxxx");
			if(extAns.equals(splitString)) {
				correctAnswers++; 
				finalPoints += points.get(i);
			}
		} 		
		result = correctAnswers +"/"+ answers.size() + "|" + "Points obtained is "+finalPoints+
				" out of "+totalPoints;
		return result;
	}
	public void setIntoExtractedList(Boolean option, int index, ArrayList<String> extAns,int newAns) {
		if(option) {
			if(extAns.get(index) != null) {
				extAns.set(index,extAns.get(index)+"|"+newAns);
			}else {
				extAns.set(index, ""+newAns);
			}
		}
	}
}
