package quiz.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import quiz.dao.ConnectionFactory;
import quiz.exceptions.DataAccessException;
import quiz.exceptions.NoDataFoundException;

public class StudentQuizDao {

	private static Properties dbProperties = new Properties();
	static {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
			Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
		}
	}

	public String getQuestionsAndOptions() throws DataAccessException, NoDataFoundException {
		// TODO Auto-generated method stub
		//As of now there are 4 options for each question.
		String[] options = new String[4];
		String jsonResult = "[";

		Connection conn = ConnectionFactory.getConnection();
		ResultSet  rs   = null;

		String sql = dbProperties.getProperty("SELECT_QUESTIONS_BY_ID");

		try{
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				options[0] = rs.getString("option1");
				options[1] = rs.getString("option2");
				options[2] = rs.getString("option3");
				options[3] = rs.getString("option4");

				if(rs.next())
					jsonResult += "{question: " + rs.getString("question") + ",choices: "+Arrays.toString(options)+",correctAnswer: 0},";
				else
					jsonResult += "{question: " + rs.getString("question") + ",choices: "+Arrays.toString(options)+",correctAnswer: 0}]";
			} 

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

}
