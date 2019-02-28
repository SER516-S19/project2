package com.asu.ser516.team47.servlet;

import com.asu.ser516.team47.database.Professor;
import com.asu.ser516.team47.database.ProfessorDAOImpl;
import com.asu.ser516.team47.database.Student;
import com.asu.ser516.team47.database.StudentDAOImpl;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
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
    public final String hash_secret = "some_long_but_random_password_that_ensures_some_amount_of_randomness";

    private String hash_password(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //
        byte[] salt = new byte[16];
        (new SecureRandom()).nextBytes(salt);

        byte[] hash = SecretKeyFactory
                .getInstance("PBKDF2WithHmacSHA1")
                .generateSecret(
                        new PBEKeySpec(
                                hash_secret.toCharArray(),
                                salt,
                                65536,
                                128)).getEncoded();

        return Base64.getEncoder().encodeToString(hash);
    }

    private boolean validate_password(String input_password, String stored_password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return hash_password(input_password).equals(stored_password);
    }

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
        String[] role_val     = req.getParameterValues("role");

        if(username_val == null || password_val == null) {
            resp.setStatus(401);
        } else {
            String username = username_val[0],
                   password = password_val[0],
                   role = role_val[0];

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
                resp.setStatus(401);
            }
            else {
                boolean password_check = false;
                try {
                    password_check = validate_password(hash_password(password), user_hash);
                } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                    resp.setStatus(500);
                }

                if(!password_check) {
                    resp.setStatus(401);
                } else {
                    String new_token = generate_token();

                    resp.addCookie(new Cookie("session-token ", new_token));
                    resp.addCookie(new Cookie("session-user ", username));

                    if(role.equals("student")) new StudentDAOImpl().getStudent(username).setSession(new_token);
                    else                       new ProfessorDAOImpl().getProfessor(username).setSession(new_token);

                }
            }
        }
    }
}
