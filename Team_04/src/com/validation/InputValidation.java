package com.validation;

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
    public void signupValidation(String username)
    {
        if (username.equalsIgnoreCase("")) {
            System.out.println("Username not exists");
        }
        else
        {
            System.out.println("Username exists");
        }
    }
}
