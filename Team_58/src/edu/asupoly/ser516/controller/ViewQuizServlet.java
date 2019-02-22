package edu.asupoly.ser516.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
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
import edu.asupoly.ser516.model.QuizVO;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;




/**
 * Servlet code
 * 
 * @author Aditya Samant
 * @version 1.1
 * */
public class ViewQuizServlet extends HttpServlet{
	// This servlet will not make any Get requests.
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
	/**
	 *Grabs quizId from courseDashboard 
	 *@param req  Request made to server
	 *@param res  Responses from server
	 *
	 *@throws IOException
	 *@throws ServletException
	 * */
	public void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException{
		   //Get general information
	       HttpSession session = req.getSession();
	       List<QuestionsVO> quizQuestions = new ArrayList<>();
	       int quizId = Integer.parseInt(req.getParameter("Quiz"));
	       //Get today's date for comparison
	       Calendar cal = Calendar.getInstance();
	       cal.set(Calendar.HOUR_OF_DAY, 0);
	       cal.set(Calendar.MINUTE, 0);
	       cal.set(Calendar.SECOND,0);
	       cal.set(Calendar.MILLISECOND,0);
	       
	       Date today = new Date(cal.getTime().getTime());
	       boolean isAfter = false;
	       
	       //Initialize Quiz Information
	       String quizName = "";
	       String instruction = "";
	       Date scheduledDate = new Date(0);
	       boolean graded = true;
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
	   				+ "on A.quizId = B.quizId "
	   		   		+ "where A.quizId = ?");
	   		   query.setInt(1, quizId);
	   		   ResultSet result = query.executeQuery();
	   		   
	   		   while (result.next()) {
	   			   //Questions DB results 
	   			   int questionId = result.getInt("questionId");
	   			   int points = result.getInt("totalPoints");
	   			   String question = result.getString("question");
	   			   //Values read as strings but actually JSON
	   			   String answer = result.getString("actualAnswer"); 
	   			   String choices = result.getString("totalChoices"); 
	   			   
	   			   //Parse Json String objects to json Object
                                   /*
	   			   JSONParser parser = new JSONParser();
	   			   JSONObject jo = (JSONObject) parser.parse(choices);
	   			   String choice1 = (String) jo.get("incorrectAnswer1");
	   			   String choice2 = (String) jo.get("incorrectAnswer2");
	   			   String choice3 = (String) jo.get("incorrectAnswer3");
	   			   
	   			   JSONObject jo2 = (JSONObject) parser.parse(answer);
	   			   String ans = (String) jo2.get("CORRECT");
	   			   //Add to Quiz and Questions Objects
	   			   QuestionsVO quest = new QuestionsVO(questionId, points, question, ans, choice1, choice2, choice3);
	   			   quizQuestions.add(quest);
                                           */
	   			   
	   			   //QuizDB results
		   		   quizName = result.getString("quizTitle");
				   instruction = result.getString("quizInstruction");
				   scheduledDate = result.getDate("quizScheduledDate");
				   graded = result.getBoolean("isGraded"); 
	   			    
	   		   }
	   		   
	   		   if (scheduledDate.before(today)) {
	   			   isAfter = true;
	   		   }
	   		   
	   		   QuizVO quizInfo = new QuizVO(quizId, quizName);
	   		   
	   		   System.out.println("Is After: "+ isAfter);
	   		   //Add Quiz info to Session attributes
	   		   session.setAttribute("Id", quizId);
	   		   session.setAttribute("Grade", graded);
	   		   session.setAttribute("Schedule", scheduledDate);
	   		   session.setAttribute("Directions", instruction);
	   		   session.setAttribute("isAfter", isAfter);
	   		   session.setAttribute("QuizQuestions",quizQuestions);
	   		   session.setAttribute("quizInfo", quizInfo);
	   		
	   		   res.sendRedirect(req.getContextPath()+"/viewQuiz.ftl");
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
	}
}
