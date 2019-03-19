package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Team76.Database.DatabaseConnection;
import Team76.Entity.Questions;

public class FetchQuestionsQuery {

	public List<Questions> fetchQuestions(String quizId) throws Exception {
		Connection connect = new DatabaseConnection().establishConnection();
		List<Questions> questions = new ArrayList<>();
		Statement statement = connect.createStatement();
		String selectQuery= "select * from Question where QuizId = " + quizId ;
		
		ResultSet resultSet = statement.executeQuery(selectQuery);
		while(resultSet.next()) {
			String quizID = resultSet.getString("QuizId");
			String questionID = resultSet.getString("QuestionId");
			String question = resultSet.getString("Questions");
			String options = resultSet.getString("Options");
			String correct = resultSet.getString("CORRECT_ANSWER");
			System.out.println(options);
			
			String replaceString = options.replace("$$@", ",");
			System.out.println(replaceString);
			String[] option = replaceString.split(",", 0);
			for(int i = 0 ; i< option.length; i++)
			System.out.println(option[i]);
			questions.add(new Questions(quizID, questionID, question, replaceString, correct));
		}
		return questions;
	}
}
