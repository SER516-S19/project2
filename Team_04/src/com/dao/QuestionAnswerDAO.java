package com.dao;

import com.model.QuestionAnswers;

import java.sql.*;
import java.util.ArrayList;

public class QuestionAnswerDAO {
    private ArrayList<QuestionAnswers> test_obj = new ArrayList<QuestionAnswers>();

    public ArrayList<QuestionAnswers> getResult()
    {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");

            c = DriverManager.getConnection("jdbc:sqlite:$PROJECT_DIR$/quizDatabase.db");

            //c = DriverManager.getConnection("jdbc:sqlite:C:/Yuvan/Projects/SER-516/project2/Team_04/src/quizDatabase.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        ResultSet rs = null;
        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery( "SELECT * FROM quiz_content" );
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
                String ans_desc = rs.getString("ans_desc");

                QuestionAnswers tes = new QuestionAnswers();

                tes.setQues_desc(ques_desc);
                tes.setAns_desc(ans_desc);
                test_obj.add(tes);




            } catch (SQLException e) {
                e.printStackTrace();
            }


            System.out.println("Sucess");
        }

//        DataOps dtObj = new DataOps();
//        String query = "Select * from quiz_content;";
//
//        try {
//            ResultSet result = dtObj.getData(query);
//        }
//        catch (
//                SQLException e) {
//            System.out.println(e.getMessage());
//        }




//        QuestionAnswers tes = new QuestionAnswers();
//        tes.setQues_id(1);
//        tes.setQues_type("SA");
//        tes.setQues_desc("What is SE");
//
//        tes.setAns_id(2);
//        tes.setAns_desc("Software Engineering");
//        tes.setIs_correct(true);
//        tes.setMax_score(10);
//
//        test_obj.add(tes);
//
//        tes.setQues_id(1);
//        tes.setQues_type("SA");
//        tes.setQues_desc("What is SE");
//
//        tes.setAns_id(3);
//        tes.setAns_desc("Software");
//        tes.setIs_correct(false);
//        tes.setMax_score(0);
//
//        test_obj.add(tes);
//


       return test_obj;

    }
}
