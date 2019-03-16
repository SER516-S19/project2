package Team76.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import Team76.Entity.QuizEntity;

public class StudentInsertQuery {

	private DatabaseConnection con;
	private Connection connect;

	public StudentInsertQuery() throws Exception 
	{
		con = new DatabaseConnection();
		connect = con.establishConnection();
	}

	public void answerEntry(int studentId, int questionId, int quizId, int marks, String answer) throws Exception 
	{
		System.out.println(studentId + " " + questionId + " "+ quizId + " " + marks + " "+ answer);
		String query = "INSERT INTO answer_table VALUES(?,?,?,?,?)";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1,studentId);
		statement.setInt(2,quizId);
		statement.setInt(3,questionId);
		statement.setString(4, answer);
		statement.setInt(5,marks);
		statement.executeUpdate();    
	}

	public String[] getSolution(int questionId) throws SQLException {
		String solution[] = new String[2];
		String query = "Select marks,CORRECT_ANSWER from question where questionId=?";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1,questionId);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			solution[0] = Integer.toString(rs.getInt(1));
			solution[1] = rs.getString(2);
		}
		//System.out.println("Marks : "+marks);
		 //connect.close();
		return solution;
	}
	public void QuestionDetailPage(QuizEntity entity) throws Exception 
	{
		int quizid = 0;
		String quiztitle, qinstruct, qtype, clockTyp;
		int timelimit;

		Date date;
		
		date = entity.getDueDate();

		if (date==null) 
		{
			
			String lastCrawlDate = "2019-04-03";
			date = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		}
		// because PreparedStatement#setDate(..) expects a java.sql.Date argument
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		Statement statement = connect.createStatement();
        String selectQuery= "select count(*) AS rowcount from quiz";
        ResultSet rs = statement.executeQuery(selectQuery);
        if(rs.next()) {
        quizid=rs.getInt("rowcount");
        }
         quizid++;
         entity.setQuizId(quizid);
		quiztitle = entity.getQuizTitle();
		qinstruct = entity.getQuizInstruct();
		qtype = entity.getQuizType();
		clockTyp = entity.getClockType();
		timelimit = entity.getTimeLimit();

		if (connect != null) 
		{
			String query = "INSERT INTO quiz ( ProfId, QuizId, Status, DueDate,Timelimit,"
					+ " QuizTitle, Qinstruct, Quiztype, OptionSelected) VALUES ( 1 , "
					+ quizid + " ,'Active','" + sqlDate + "', " + timelimit + " ,' " + quiztitle +
					" '  , ' " + qinstruct+ " ' , ' " + qtype + " ', ' " + clockTyp + " '  )";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.executeUpdate();
			
			
		}
		else 
		{
			System.out.println("Database Connection not Successful");
		}

	}
	
	public void connectionClose() throws SQLException
	{
		connect.close();

	}
	
}
