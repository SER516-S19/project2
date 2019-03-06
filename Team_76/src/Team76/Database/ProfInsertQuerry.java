package Team76.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import Team76.Entity.QuizEntity;

/**
 * SER516-Project2
 * 
 * @author Mayank Batra, mbatra3@asu.edu
 * @since 02/19/2019 version 2.0
 */

public class ProfInsertQuerry
{

	private DatabaseConnection con;
	private Connection connect;

	public ProfInsertQuerry() throws Exception 
	{
		con = new DatabaseConnection();
		connect = con.establishConnection();
	}

	public void QuestionPage(QuizEntity entity) throws Exception 
	{
		String marks, question, options, answer;
		int quizid, questionid,loopVar = 0;
		if (connect != null) {
			int size = entity.getQuestionsList().size();

			for (loopVar = 0; loopVar < size; loopVar++)
			{
				question = entity.getQuestionsList().get(loopVar).getQuestion();

				options = entity.getQuestionsList().get(loopVar).getOption1() + "$$@"
						+ entity.getQuestionsList().get(loopVar).getOption2() + "$$@"
						+ entity.getQuestionsList().get(loopVar).getOption3() + "$$@"
						+ entity.getQuestionsList().get(loopVar).getOption4() + "$$@";
				answer = entity.getQuestionsList().get(loopVar).getAnswer();
				marks = entity.getQuestionsList().get(loopVar).getMarks();
				quizid = entity.getQuizId();
				questionid = (quizid * 100) + 1;
				String query = "INSERT INTO Question (QuizId,QuestionId,Questions,Options,"
						+ "CORRECT_ANSWER,marks) VALUES ("
						+ quizid + "," + questionid + ",'" + question + " ' , '" + options + 
						" ' , ' " + answer + "',"+ marks + ") ";
				PreparedStatement pstmt = connect.prepareStatement(query);
				pstmt.executeUpdate();

			}
			connect.close();

		} else 
		{
			System.out.println("Database Connection not Successful");
		}
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
