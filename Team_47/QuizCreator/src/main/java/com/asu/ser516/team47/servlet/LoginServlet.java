package com.asu.ser516.team47.servlet;

import com.asu.ser516.team47.database.Professor;
import com.asu.ser516.team47.database.ProfessorDAOImpl;
import com.asu.ser516.team47.database.Student;
import com.asu.ser516.team47.database.StudentDAOImpl;
import com.asu.ser516.team47.utils.PasswordStorage;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class LoginServlet extends HttpServlet {
    private final String hash_secret = "some_long_but_random_password_that_ensures_some_amount_of_randomness";

    private String generate_token() {
        byte[] bytes = new byte[20];

        (new SecureRandom()).nextBytes(bytes);

        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

        return encoder.encodeToString(bytes);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] username_val = req.getParameterValues("username");
        String[] password_val = req.getParameterValues("password");
        String[] role_val     = req.getParameterValues("identity");

        if(username_val == null || password_val == null) {
            resp.sendRedirect("/login.jsp?error=true");
        } else {
            String username = username_val[0],
                   password = password_val[0],
                   role = role_val[0];

            //Get the Hashed password for the user
            String user_hash = null;
            if (role.equals("student")) {
                Student user_obj = new StudentDAOImpl().getStudent(username);
                if(user_obj != null) user_hash = user_obj.getHashedpass();
            }
            else {
                Professor user_obj = new ProfessorDAOImpl().getProfessor(username);
                if(user_obj != null) user_hash = user_obj.getHashedpass();
            }

            if(user_hash == null) {
                resp.sendRedirect("/login.jsp?error=true");
            }
            else {
                boolean password_check;
                try {
                    password_check = PasswordStorage.verifyPassword(password, user_hash);
                } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException e) {
                    throw new ServletException(e); //this will bring up the default error page for tomcat
                }

                if(!password_check) {
                    resp.sendRedirect("/login.jsp?error=true");
                } else {
                    String new_token = generate_token();

                    resp.addCookie(new Cookie("session-role", role));
                    resp.addCookie(new Cookie("session-token", new_token));
                    resp.addCookie(new Cookie("session-user", username));


                    if(role.equals("student")) {
                        new StudentDAOImpl().getStudent(username).setSession(new_token);
                        resp.sendRedirect("/myquizzes.jsp");
                    }
                    else {
                        new ProfessorDAOImpl().getProfessor(username).setSession(new_token);
                        resp.sendRedirect("/dashboard_professor.jsp");
                    }
                }
            }
        }
    }
}
