package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.CourseVO;
import edu.asupoly.ser516.model.QuizVO;
import edu.asupoly.ser516.model.UserVO;

public class CourseDashboardServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)  throws IOException {
		
		
		HttpSession session = req.getSession();
		HashMap<Integer, String> courseMap = (HashMap<Integer, String>) session.getAttribute("CourseHashMap");
		
		int courseId = Integer.parseInt(req.getParameter("Course"));
		
		String courseName = courseMap.get(courseId);
		
		session.setAttribute("courseName",courseName);
		session.setAttribute("courseId", courseId);
		
		
		try {
			
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String hostName = "showtimefinder.database.windows.net"; // update me
        String dbName = "ser516_db"; // update me
        String user = "scrum_mates@showtimefinder"; // update me
        String password = "Azure@Cloud"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;
		connection = DriverManager.getConnection(url);
		String schema;
		schema = connection.getSchema();
		System.out.println("Successful connection - Schema: " + schema);
        
		
		
		PreparedStatement query;
		query = connection.prepareStatement("select * from [dbo].[Quiz] where courseId = ?");
		query.setInt(1,courseId);
		
		
		      
		ResultSet resultData = query.executeQuery();
		
		List<QuizVO> list = new ArrayList<>();
	
		while(resultData.next()) {
			int quizId = resultData.getInt("quizId");
			int assignedTime = resultData.getInt("assignedTime");
			Boolean isGraded = resultData.getBoolean("isGraded");
			String quizInstruction = resultData.getString("quizInstruction"); 
			String quizScheduledDate = resultData.getString("quizScheduledDate");
			Boolean isShuffled = resultData.getBoolean("isShuffled");
			String quizTitle = resultData.getString("quizTitle");
			QuizVO quiz = new QuizVO(quizId, isGraded, assignedTime, quizInstruction, quizScheduledDate, isShuffled, quizTitle);
			list.add(quiz);
		}
		
		HashMap<Integer, String> quiz = new HashMap<>();
		for(int i=0;i<list.size();i++)
			quiz.put(list.get(i).getQuizId(), list.get(i).getQuizTitle());
		
		session.setAttribute("QuizHashMap", quiz);

		System.out.println(req.getContextPath()+"/courseDashboard.ftl");
		
		res.sendRedirect(req.getContextPath()+"/courseDashboard.ftl");  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}