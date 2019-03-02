package com.Quizzer.code.controller;


import com.Quizzer.code.model.db.User;
import com.Quizzer.code.model.response.ResponseVO;
import com.Quizzer.code.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is the model for User data.
 *
 * @author Koushik Kotamraju GIT ID: 44
 * @author Abhinab Mohanty GIT ID: 53
 *
 */


@RestController
@CrossOrigin(origins="*", allowedHeaders="*")

public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public @ResponseBody
    ResponseEntity<ResponseVO> register(@RequestBody User userDefine) {

        return loginService.addUser(userDefine);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public @ResponseBody
    User login(@RequestBody String email, String pass) {

        return loginService.authenticateUser(email, pass);
    }

}
