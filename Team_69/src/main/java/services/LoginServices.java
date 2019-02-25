package services;


import dao.LoginDAO;

public class LoginServices {

    public String checkUserType(String userEmail){
        LoginDAO loginDAO = new LoginDAO();
        String userType = loginDAO.checkUserType(userEmail);
        return userType;
    }



}
