package quiz.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import quiz.dao.ConnectionFactory;
import quiz.dao.professor.QuizDetailsDao;
import quiz.exceptions.DataAccessException;
import quiz.exceptions.NoDataFoundException;
import quiz.model.professor.QuizModel;
import quiz.model.student.QuizAttempt;

/**
 * StudentQuizDao extracts the quiz from the database
 * 
 * @author Sumanth
 * @version (1.0)
 */
public class StudentQuizDao {
	
	private static Properties dbProperties = new Properties();
	static {
		try {
		    /* Connecting to the database */
		    dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
		    Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
		    t.printStackTrace();
		} finally {
		}
	    }		
	@SuppressWarnings("unchecked")
	public String getQuestionsAndOptions(int quiz_id) throws DataAccessException, NoDataFoundException {
		@SuppressWarnings("rawtypes")
		//Initialising options array which contains choices of each question. Each question contains four options 
		String[] options = new String[4];
		String jsonResult = "[";
		Connection conn = ConnectionFactory.getConnection();
	 	ResultSet  rs   = null;
	    	String sql = dbProperties.getProperty("SELECT_QUESTIONS_BY_ID");
		try{
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, quiz_id);
		 	rs = preparedStatement.executeQuery();
			while (rs.next()) {				
				options[0] = "\""+ rs.getString("option1") + "\"";
				options[1] = "\"" + rs.getString("option2") + "\"";
				options[2] = "\"" + rs.getString("option3") + "\"";
				options[3] = "\"" + rs.getString("option4") + "\"";
				jsonResult += "{\"question\": \"" + rs.getString("question") + "\",\"choices\": 
						"+Arrays.toString(options)+",\"isMultipleAnswer\": "+rs.getString("ismultipleanswer")+"},";
			} 
			/* The format must be like this , so that it can be parsed in the front end.
			 * var questions = $.parseJSON('[{"question": "question1","choices": ["answer1", "answer2", "answer3", "option4"],
							"correctAnswer": 0},{"question": "What is your favorite colour",
							"choices": ["blue", "yellow", "black", "orange"],"correctAnswer": 0}]');
			 */
		jsonResult = jsonResult.substring(0, jsonResult.length() - 1) + "]";
		return jsonResult;
		}
	    	catch(SQLException e){
	      		/*Aborting the transaction*/
	    		e.printStackTrace();
	        	return jsonResult;
	    	}
		finally{
			try{
		        	if (rs!=null)   rs.close();
				if (conn!=null) conn.close();
		      	}
		      	catch(SQLException e){
				System.out.println("Unable to close resultset, database connection " +
					   "or statement in findByPrimaryKey");
		      	}
		}
	}	
	public static void insert(QuizAttempt pValueObject,String id) throws DataAccessException {		
		String  sql = dbProperties.getProperty("INSERT_ANSWERS");
		QuizAttempt attempt = (QuizAttempt) pValueObject;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;   
		try{
			/*Populating the prepared statement with data from the value object*/
			preparedStatement = conn.prepareStatement(sql.toString());
		        preparedStatement.setInt(1, Integer.parseInt(id));
		        preparedStatement.setInt(2, attempt.getStudentId());
		        preparedStatement.setInt(3, attempt.getQuestionId());
		        preparedStatement.setString(4, attempt.getResponse());
		        preparedStatement.execute();
		}
		catch(SQLException e){
			/*Aborting the transaction*/
		        e.printStackTrace();
		        DataAccessException exc = new DataAccessException("Error in insert()",e);
		        try {
		        	conn.rollback();
		        }
		        catch (SQLException e2) {
		        	throw new DataAccessException("Error rolling back during recovery, nested exception has original error", exc);
		        }
		        throw exc;
		    }
		    finally{
		    	try{
		    		if (preparedStatement!=null) preparedStatement.close();
		    		if (conn!=null) conn.close();
		      	}catch(SQLException e){
				System.out.println("Unable to close resultset, database connection " +
					   "or statement in insert()");
		    	}
		    }
		}
}
