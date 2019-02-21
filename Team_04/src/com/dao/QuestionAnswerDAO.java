package com.dao;

import com.model.QuestionAnswers;

import java.util.ArrayList;

public class QuestionAnswerDAO {
    private ArrayList<QuestionAnswers> test_obj = new ArrayList<QuestionAnswers>();

    public ArrayList<QuestionAnswers> getResult()
    {


        QuestionAnswers tes = new QuestionAnswers();
        tes.setQues_id(1);
        tes.setQues_type("SA");
        tes.setQues_desc("What is SE");

        tes.setAns_id(2);
        tes.setAns_desc("Software Engineering");
        tes.setIs_correct(true);
        tes.setMax_score(10);

        test_obj.add(tes);

        tes.setQues_id(1);
        tes.setQues_type("SA");
        tes.setQues_desc("What is SE");

        tes.setAns_id(3);
        tes.setAns_desc("Software");
        tes.setIs_correct(false);
        tes.setMax_score(0);

        test_obj.add(tes);

        return test_obj;

    }
}
