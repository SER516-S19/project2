package com.validation;

import DBUtil.DataManager;
import student.dto.UserData;

import java.util.List;

/**
 * The {@code InputValidation} class represents a class.
 *  * It includes methods to validate the login and sign up
 *
 *  @author Ankita Shivanand Bhandari
 */
public class InputValidation {

    /**
     *
     * @param userName
     * userName for login
     * @param passWord
     * passWord for login
     * @param userType
     * userType of the user
     * @return success on successful validating and failed if validation is unsuccessful
     */
    public String loginValidation(String userName, String passWord, String userType)
    {
        List<UserData> userExists = DataManager.getInstance().executeGetQuery(UserData.class,
                "SELECT userName,password,userType from userDetails where userName='"
                        +userName+"' and password = '"+passWord+"' and userType = '"+userType+"'");

        if (userExists != null && !userExists.isEmpty()){
            return "success";
        }
        else {
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

            return "newUser";
        }
        else {
            return "returningUser";
        }
    }
}
