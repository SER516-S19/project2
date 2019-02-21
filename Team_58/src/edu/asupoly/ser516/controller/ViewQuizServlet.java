package edu.asupoly.ser516.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import edu.asupoly.ser516.model.QuestionsVO;
import org.json.simple.JSONObject;


/**
 * The following code will render the View Quiz Page
 * 
 * @author Aditya Samant
 * @version 1.0
 * */
public class ViewQuizServlet extends HttpServlet{
	// This servlet will not make any Get requests.
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
	/**
	 * 
	 *
	 * @throws IOException
	 * @throws ServletException
	 * */
	public void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {
		   //Get general information
	       HttpSession sesh = req.getSession();
	       List<QuestionsVO> quizQuestions = new ArrayList<>();
	       int quizId = Integer.parseInt(req.getParameter("Quiz"));
	       try {
	    	   //The information in the following items will be placed securely on a seperate file.
	    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	  
	           String hostName = "showtimefinder.database.windows.net"; 
	           String dbName = "ser516_db"; 
	           String user = "scrum_mates@showtimefinder"; 
	           String password = "Azure@Cloud"; 
	           String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
	               + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	           Connection connection = null;
	   		   connection = DriverManager.getConnection(url);
	   		   String schema;
	   		   schema = connection.getSchema();
	   		   System.out.println("Successful connection - Schema: " + schema); 
	   		   
	   		   //Query strings to gets entire question info and only the isGraded boolean from Quiz table
	   		   PreparedStatement query;
	   		   query = connection.prepareStatement("select A.*, B.isGraded, B.quizTitle, B.quizScheduledDate, B.quizInstruction " 
	   				+ "from [dbo].[Questions] A "
	   				+ "join [dbo].[Quiz] B "
	   				+ "on A.quizId = B.quizId"
	   		   		+ "where B.quizId = ?");
	   		   query.setInt(1, quizId);
	   		   ResultSet result = query.executeQuery();
	   		   
	   		   //QuizDB results
	   		   String quizName = result.getString("quizTitle");
	   		   String instruction = result.getString("quizInstruction");
			   Date scheduledDate = result.getDate("quizScheduledDate");
			   boolean graded = result.getBoolean("isGraded");
			   
	   		   while (result.next()) {
	   			   //Questions DB results 
	   			   int questionId = result.getInt("questionId");
	   			   int points = result.getInt("totalPoints");
	   			   String question = result.getString("question");
	   			   String answer = result.getString("actualAnswer");
	   			   String choices = result.getString("totalChoices");
	   			   
	   			   //Parse Json String object to json Object
	   			   JSONObject jo = new JSONObject(choices);
	   			   String choice1 = jo.getString("IncorrectAnswer1");
	   			   String choice2 = jo.getString("IncorrectAnswer2");
	   			   String choice3 = jo.getString("IncorrectAnswer3");
	   			   
	   			   
	   			   //Add to Quiz and Questions Objects
	   			   QuestionsVO quest = new QuestionsVO(questionId, points, question, answer, choice1, choice2, choice3);
	   			   quizQuestions.add(quest);
	   		   }
	   		   sesh.setAttribute("Name", quizName);
	   		   sesh.setAttribute("Grade", graded);
	   		   sesh.setAttribute("Schedule", scheduledDate);
	   		   sesh.setAttribute("Directions", instruction);
	   		   
	   		   sesh.setAttribute("QuizQuestions",quizQuestions);
	   		   res.sendRedirect(req.getContextPath()+"/viewQuiz.ftl");
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
	}  
}
