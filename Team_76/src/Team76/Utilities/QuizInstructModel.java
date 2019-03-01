package Team76.Utilities;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Team76.Database.DatabaseConnection;
import Team76.Entity.QuizEntity;

/**
 * retrieve quiz info from mysql database
 * author: Xiangwei Zheng
 * version: 1.1
 */

public class QuizInstructModel {
	private DatabaseConnection connect = null;
	private Connection conn = null;	
	private Statement stmt = null;
	private String dbname = "ser516p2";	
	
	public QuizInstructModel(){
		try {
			/*
			Connection connection = null;
			Statement statement = null;
			String driver = "com.mysql.jdbc.Driver";
			String connectionUrl = "jdbc:mysql://localhost:3306/";
			String database = "ser516p2";
			String userid = "root";
			String password = "199021";
			connection = DriverManager.getConnection(connectionUrl+database, userid, password);
			statement=connection.createStatement();
			*/
			connect = new DatabaseConnection();
			conn = connect.establishConnection();
		    dbname = "ser516p2";   
		} catch (Throwable t) {
		    t.printStackTrace();
		}
	}

	public QuizEntity getquiz(String quizId) {
		//String quizId="1";//Xiangwei			
		ResultSet resultSet = null;		
		QuizEntity quiztaken = new QuizEntity();//xiangwei
		try {
		    /*
			Connection connection = null;
			Statement statement = null;
			String driver = "com.mysql.jdbc.Driver";
			String connectionUrl = "jdbc:mysql://localhost:3306/";
			String database = "ser516p2";
			String userid = "root";
			String password = "199021";
			try {
				Class.forName(driver);
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			connection = DriverManager.getConnection(connectionUrl+database, userid, password);
			statement=connection.createStatement();
			*/
					
			stmt = conn.createStatement();
			stmt.executeUpdate("use " + dbname);
			//xiangwei
			String sql ="SELECT * FROM quiz WHERE QuizId ='1' ";
			System.out.println("**** SQL SELECT");
			//String sql ="SELECT * FROM quiz WHERE QuizId ="+quizId;//Xiangwei
			resultSet = stmt.executeQuery(sql);
			//resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				System.out.println("******1"+resultSet.getString("qinstruct"));
				quiztaken.setProfessorId(resultSet.getInt("ProfId"));
				quiztaken.setQuizId(resultSet.getInt("QuizId"));
				quiztaken.setQuizStatus(resultSet.getString("status"));
				quiztaken.setDueDate(resultSet.getDate("DueDate"));
				quiztaken.setTimeLimit(resultSet.getInt("Timelimit"));
				quiztaken.setQuizType(resultSet.getString("QuizType"));
				quiztaken.setQuizTitle(resultSet.getString("quiztitle"));
				quiztaken.setQuizInstruct(resultSet.getString("qinstruct"));//xiangwei
				
			}
			//quiztaken.getQuizInstruct()
			System.out.println("******2"+quiztaken.getQuizInstruct());
			stmt.close();
			//statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
		    try {
		    	if (stmt != null) stmt.close();
		    } catch (SQLException se2) {
		    	se2.printStackTrace();
		    	System.out.println("Not all DB resources freed!");
		    }
		}
		return quiztaken;

	}

}
