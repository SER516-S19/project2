package com.validation;

import DBUtil.DataManager;
import student.dto.QuizContent;

import java.util.List;

public class InputValidation {
    public void loginValidation(String username, String password)
    {
        if (username.equalsIgnoreCase("") || (password.equalsIgnoreCase(""))
        ) {
            System.out.println("Username");

        }
        else
        {
            System.out.println("Password set");
        }
    }

    /**
     * Method to check the entered username is already there or not
     * @param username
     *        Entered UserName
     */
    public String signupValidation(String username)
    {
        List<QuizContent> userExists = DataManager.getInstance().executeGetQuery(QuizContent.class,
                "SELECT * FROM quiz_content where quizId='1' group by quesId");

        if (userExists.equals("")){
            System.out.println("Username not exists");
        }
        else
        {
            System.out.println("Username exists");
        }
        return "success";
    }
}
