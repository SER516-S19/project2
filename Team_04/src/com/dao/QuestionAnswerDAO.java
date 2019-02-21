package com.dao;

import com.model.QuestionAnswers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionAnswerDAO {

    private ArrayList<QuestionAnswers> test_obj = new ArrayList<QuestionAnswers>();

    public Map<String, List<QuestionAnswers>> getResult()
    {
        Connection c = null;
        Statement stmt = null;
        Statement stmt1 = null;
        String ques_desc = "";
        ResultSet rs = null;
        ResultSet rans = null;
        ArrayList<String> quesDescList = new ArrayList<String>();
        Map<String, List<QuestionAnswers>> questionAnsMap= new HashMap<String, List<QuestionAnswers>>();

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:/Yuvan/Projects/SER-516/project2/Team_04/src/quizDatabase.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        try {
            stmt = c.createStatement();
            stmt1 = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs = stmt.executeQuery( "SELECT * FROM quiz_content group by ques_id" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!rs.next()) break;

                QuestionAnswers quesObj = new QuestionAnswers();
                ques_desc = rs.getString("ques_desc");
                quesDescList.add(ques_desc);
                quesObj.setQues_desc(ques_desc);
                test_obj.add(quesObj);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int i=0;i<quesDescList.size(); i++)
        {
            try {
                rans = stmt1.executeQuery("SELECT * FROM quiz_content where ques_desc = '"+ quesDescList.get(i) +"'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            List<QuestionAnswers> answerDesList = new ArrayList<QuestionAnswers>();

            while (true) {
                try {
                    if (!rans.next()) break;

                    QuestionAnswers ansObj = new QuestionAnswers();
                    String ans_desc = rans.getString("ans_desc");
                    boolean is_correct = rans.getBoolean("is_correct");
                    String ques_type = rans.getString("ques_type");
                    ansObj.setAns_desc(ans_desc);
                    ansObj.setIs_correct(is_correct);
                    ansObj.setQues_type(ques_type);
                    answerDesList.add(ansObj);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            questionAnsMap.put(quesDescList.get(i), answerDesList);
        }

       return questionAnsMap;
    }
}