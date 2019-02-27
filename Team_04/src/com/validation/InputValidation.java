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
        username = "Pradeep";
        List<QuizContent> userExists = DataManager.getInstance().executeGetQuery(QuizContent.class,
                "SELECT userName from userData where userName=" +username);
        String updateQuery = "INSERT INTO userData(userName,"
                            +"password,userType,isActive)"
                            + "VALUES(?,?,?,?)";

        if (userExists.equals(null) || userExists.isEmpty()){
            int numOfRowsAffected = DataManager.getInstance().
                    executeUpdateQuery(updateQuery, username, "abc", "S","1");
            System.out.println("Username not exists");
        }
        else
        {
            System.out.println("Username exists");
        }
        return "success";
    }
}
