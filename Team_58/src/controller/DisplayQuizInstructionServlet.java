package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ConnectionFactory;
import model.QuestionsDAOBean;
import model.QuestionsVO;
import model.QuestionsVO;
import model.QuizVO;
import model.QuizDAOBean;

import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

/**
 * Display Quiz Instruction Servlet is a controller that displays Quiz 
 * instructions before student starts the quiz.
 * 
 * @author Prashansa
 * @version 1.3
 * @date 02/25/2019
 **/

@WebServlet(name = "DisplayQuizInstructionServlet", urlPatterns = "/DisplayInst")

public class DisplayQuizInstructionServlet extends HttpServlet  {
	
	private static Logger log = Logger.getLogger(DisplayQuizInstructionServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try {
        	
        	log.info("Coming in doGet method displayquizinstservelt");

        	int quizID = Integer.parseInt(req.getParameter("QuizId"));
//        	int quizID = 1;
        	
        	
        	log.info("sam"+quizID);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String hostName = "showtimefinder.database.windows.net";
            String dbName = "ser516_db";
            String user = "scrum_mates@showtimefinder";
            String password = "Azure@Cloud";
            String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                    + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
            Connection connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
            
            log.info("connect...");
                        
//          ============================================================

            PreparedStatement query2 = connection.prepareStatement("select * from [dbo].[Quiz]" + "where quizId = ?");
            query2.setInt(1, quizID);
            ResultSet userData = query2.executeQuery();
            QuizVO quizVO = null;
            String quizInstruction = "";
            log.info("After query");
            
            ResultSetMetaData rsmd = userData.getMetaData();
            
            String name = rsmd.getColumnName(2);
            
            log.info("column name 2 is"+ name);
            
            
            
            while(userData.next())
            {
            	quizInstruction = userData.getString("quizInstruction");
            	
            	log.info("quizInstruction"+ quizInstruction );
				
				int courseId = userData.getInt("courseId");
				boolean isGraded = userData.getBoolean("isGraded");
				int assignedTime = userData.getInt("assignedTime");;
//				String quizInstruction = userData.getString("quizInstruction");
				Date quizScheduledDate = userData.getDate("quizScheduledDate");
				boolean isShuffled = userData.getBoolean("isShuffled");
				String quizTitle = userData.getString("quizTitle");
            	
				quizVO = new QuizVO(quizID, isGraded, assignedTime, quizInstruction, quizScheduledDate, isShuffled, quizTitle);
				
				log.info("After Values");
            }
            	
        	HttpSession session = req.getSession();
			
			session.setAttribute("QuizVO", quizVO);
			
			log.info("After Assign atttribute");
			
			
			res.sendRedirect(req.getContextPath() + "/DisplayQuizInstruction.ftl");
            
            System.out.println("Successful connection - Schema: endddd");
            log.info("at the end do get inst servlet");

//            ============================================================


        } catch(Exception e){

            e.printStackTrace();
        }

    }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		log.info("Coming in doPost method displayquizinstservelt");
		
		
    	

    }
	

}