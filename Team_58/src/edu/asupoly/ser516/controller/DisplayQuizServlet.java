package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.asupoly.ser516.model.QuestionsVO;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "DisplayQuiz", urlPatterns = "/DisplayQuiz")
public class DisplayQuizServlet extends HttpServlet{
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

            PreparedStatement query2 = connection.prepareStatement("select questionId, question, totalChoices from [dbo].[questions]" + " where questionId = 1");
            ResultSet userData = query2.executeQuery();
            String question = "";
            while(userData.next())
                question = userData.getString("question");
            QuestionsVO questionsVO = new QuestionsVO(question, "", "", "", "");

            HttpSession session = req.getSession();
            session.setAttribute("QuestionsVO", questionsVO);

            res.sendRedirect(req.getContextPath() + "/displayQuiz.ftl");

           /* Statement conStatement = connection.createStatement("select qu.guizId,q.questionId, q.question, q.totalchoices from [dbo].[Questions] INNER JOIN [dbo].[Quiz] ON where q.questionId = qu.questionId");
            ArrayList questionList = null;
            ArrayList arrList = new ArrayList();
            ResultSet resultData = conStatement.executeQuery();

            while(resultData.next()){
                questionList = new ArrayList();
                questionList.add(resultData.getString("questionId"));
                questionList.add(resultData.getString("question"));
                questionList.add(resultData.getString("totalChoices"));

                arrList.add(questionList);
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("resources/displayQuiz.ftl");
            req.setAttribute("quesList", arrList);
            requestDispatcher.forward(req, res); */

        } catch(Exception e){

            e.printStackTrace();
        }

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) {

    }
}