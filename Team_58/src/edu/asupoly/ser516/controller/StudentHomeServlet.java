package edu.asupoly.ser516.controller;

import edu.asupoly.ser516.model.CourseVO;
import edu.asupoly.ser516.model.QuizVO;
import edu.asupoly.ser516.model.UserVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StudentHome", urlPatterns = "/StudentHome")
public class StudentHomeServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
       
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    {	
    	try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String hostName = "showtimefinder.database.windows.net"; // update me
            String dbName = "ser516_db"; // update me
            String user = "scrum_mates@showtimefinder"; // update me
            String password = "Azure@Cloud"; // update me
            String url = String.format(
                "jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                hostName, dbName, user, password);
            Connection connection = null;
            connection = DriverManager.getConnection(url);

            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
            
            UserVO userVO = (UserVO) req.getAttribute("UserVO");
            
            PreparedStatement query;
            query = connection.prepareStatement("select * from [dbo].[Course] A " +
                                                " join [dbo].[UserCourseMApping] B" +
                                                " on A.courseId = B.courseId" + " where B.userId = ?");
            query.setInt(1, userVO.getUserId());

            ResultSet resultData = query.executeQuery();

            List<CourseVO> list = new ArrayList<>();

            while (resultData.next()) {
                    int courseId = resultData.getInt("courseId");
                    String courseName = resultData.getString("courseName");
                    String courseNumber = resultData.getString("courseNumber");
                    CourseVO course = new CourseVO(courseName, courseNumber, courseId);
                    list.add(course);
            }
            
            PreparedStatement query3;
            query3 = connection.prepareStatement("select * from [dbo].[Course] A " +
                                                " join [dbo].[UserCourseMApping] B" +
                                                " on A.courseId = B.courseId" + 
                                                " join [dbo].[Quiz] C on B.courseId = C.courseId" +
                                                " where B.userId = ?");
            query3.setInt(1, userVO.getUserId());

            ResultSet resultData3 = query3.executeQuery();

            List<QuizVO> quizList = new ArrayList<>();

            System.out.println(resultData3);
            while (resultData3.next()) {
                    int quizId = resultData3.getInt("quizId");
                    String quizTitle = resultData3.getString("quizTitle");
                    QuizVO quiz = new QuizVO(quizId, quizTitle);
                    quizList.add(quiz);
            }

            HashMap<Integer, String> quizzes = new HashMap<>();
            for (QuizVO list1 : quizList)
                quizzes.put(list1.getQuizId(), list1.getQuizTitle());
            
            HashMap<Integer, String> course = new HashMap<>();
            for (CourseVO list1 : list)
                course.put(list1.getCourseId(), list1.getCourseName());

            HttpSession session = req.getSession();
            session.setAttribute("UserVO", userVO);
            session.setAttribute("CourseHashMap", course);
            session.setAttribute("QuizHashMap", quizzes);
            

            res.sendRedirect(req.getContextPath() + "/studentHome.ftl");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}