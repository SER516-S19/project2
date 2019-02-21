package com.dao;

import com.model.QuestionAnswers;

import java.sql.*;
import java.util.ArrayList;

public class QuestionAnswerDAO {
    private ArrayList<QuestionAnswers> test_obj = new ArrayList<QuestionAnswers>();

    public ArrayList<QuestionAnswers> getResult()
    {
        QuestionAnswers tes = new QuestionAnswers();
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");

            //c = DriverManager.getConnection("jdbc:sqlite:$PROJECT_DIR$/quizDatabase.db");

            c = DriverManager.getConnection("jdbc:sqlite:C:/Users/14807/Documents/Project516/project2/Team_04/src/quizDatabase.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        ResultSet rs = null;
        ResultSet rans = null;
        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery( "SELECT * FROM quiz_content" );
            rans = stmt.executeQuery( "SELECT * FROM quiz_content" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {

                String ques_desc = rs.getString("ques_desc");
                tes.setQues_desc(ques_desc);
                test_obj.add(tes);
                break;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        while (true) {
            try {
                if (!rans.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                String ans_desc = rans.getString("ans_desc");
                tes.setAns_desc(ans_desc);
                test_obj.add(tes);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
       return test_obj;

    }
}
