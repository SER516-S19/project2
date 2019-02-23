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
import jdk.nashorn.internal.parser.JSONParser;

import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "DisplayQuiz", urlPatterns = "/DisplayQuiz")
public class DisplayQuizServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{


        try {
            int questionID = Integer.parseInt(req.getParameter("questionId"));
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

            PreparedStatement query2 = connection.prepareStatement("select questionId, question, actualAnswer, totalChoices from [dbo].[questions]" + " where questionId = ?");
            query2.setInt(1, questionID);
            ResultSet userData = query2.executeQuery();
            QuestionsVO questionsVO = null;

            while(userData.next()){
                int questionId = userData.getInt("questionId");
                int totalPoints = userData.getInt("totalPoints");
                String question = userData.getString("question");
                String answer = userData.getString("actualAnswer");
                int choices = userData.getInt("totalChoices");

                JSONParser parser = new JSONParser(answer, null, false);
                JSONObject jo = null;//(JSONObject) parser.parse(choices);
                //JSONObject jo2 = (JSONObject) parser.parse(answer);

                String choice1 = (String) jo.get("incorrectAnswer1");
                String choice2 = (String) jo.get("incorrectAnswer2");
                String choice3 = (String) jo.get("incorrectAnswer3");

                questionsVO = new QuestionsVO(questionID, totalPoints, question, answer, choice1, choice2, choice3);
            }


            HttpSession session = req.getSession();
            session.setAttribute("QuestionsVO", questionsVO);

            res.sendRedirect(req.getContextPath() + "/displayQuiz.ftl");



        } catch(Exception e){

            e.printStackTrace();
        }

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) {

    }
}