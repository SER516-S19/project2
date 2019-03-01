package com.validation;

import DBUtil.DataManager;
import student.dto.QuizContent;
import student.dto.UserData;

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



    public String loginValidation(String userName, String passWord, String userType)
    {
        List<UserData> userExists = DataManager.getInstance().executeGetQuery(UserData.class,
                "SELECT udername,password  from userDetails where userName='"+userName+"'");



        //String updateQuery = "INSERT INTO userDetails(userName,password,userType,isActive) VALUES(?,?,?,?)";

        if (userExists != null || !userExists.isEmpty()){

            System.out.println("Username exists");
            return "success";

        }
        else
        {
            return "signup";
        }

    }

    /**
     * Method to check the entered username is already there or not
     * @param userName
     *        User name for login
     * @param passWord
     *        Password for login
     * @param userType
     *        denotes the type of user (Professor or Student)
     * @return
     */
    public String signupValidation(String userName, String passWord, String userType)
    {
        List<UserData> userExists = DataManager.getInstance().executeGetQuery(UserData.class,
                "SELECT * from userDetails where userName='"+userName+"'");



        String updateQuery = "INSERT INTO userDetails(userName,password,userType,isActive) VALUES(?,?,?,?)";

        if (userExists == null || userExists.isEmpty()){
            DataManager.getInstance().
                    executeUpdateQuery(updateQuery, userName, passWord, userType, true);
            System.out.println("Username not exists");
        }
        else
        {
            System.out.println("Username exists");
        }
        return "success";
    }
}
