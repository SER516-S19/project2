package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import edu.asupoly.ser516.model.QuestionsVO;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "DisplayQuiz", urlPatterns = "/DisplayQuizInstruction")
public class DisplayQuizInstructionsServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try {
        	
        	

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

           // PreparedStatement query2 = connection.prepareStatement("select questionId, question, totalChoices from [dbo].[questions]" + " where questionId = 1");
            PreparedStatement query2 = connection.prepareStatement("select quizInstruction from [dbo].[Quiz]" + " where quizId = 1");
            ResultSet userData = query2.executeQuery();
            String quizInstruction = "";
            while(userData.next())
            	quizInstruction = userData.getString("quizInstruction");
            QuizVO quizVO = new QuizVO(quizInstruction, "", "", "", "", "", "" );

            HttpSession session = req.getSession();
            session.setAttribute("QuizVO", quizVO);
            
            System.out.println("Successful connection - Schema: endddd");

            res.sendRedirect(req.getContextPath() + "/displayQuizInstructions.ftl");

        } catch(Exception e){

            e.printStackTrace();
        }

    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	response.sendRedirect(request.getContextPath() + "/submitQuiz.ftl");
    	
    }
    
}
