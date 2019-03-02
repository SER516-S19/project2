package com.validation;

import DBUtil.DataManager;
import student.dto.UserData;

import java.util.List;

public class InputValidation {

    public String loginValidation(String userName, String passWord, String userType)
    {
        List<UserData> userExists = DataManager.getInstance().executeGetQuery(UserData.class,
                "SELECT userName,password,userType from userDetails where userName='"+userName+"' and password = '"+passWord+"' and userType = '"+userType+"'");

        if (userExists != null && !userExists.isEmpty()){

            return "success";

        }
        else
        {
            return "failed";
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
            return "newUser";
        }
        else
        {
            System.out.println("Username exists");
            return "returningUser";
        }

    }
}
