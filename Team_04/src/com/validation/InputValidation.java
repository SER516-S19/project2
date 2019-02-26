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
}
