package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import io.javalin.http.Handler;
import io.javalin.http.UnauthorizedResponse;

public class AuthController {

    private AuthService as;
    private UserService us;
    private ObjectMapper mapper = new ObjectMapper();

    public AuthController(AuthService as, UserService us){
        this.as = as;
        this.us = us;
    }
    public Handler login = (context) -> {
        //interpret the request
        String username = context.formParam("username");
        String password = context.formParam("password");
        //fulfill the request
        User user = us.getUserByUsernameAndPassword(username, password);

        //preparing response
        if(user == null) {
            throw new UnauthorizedResponse("Incorrect Username and Password.");
        }else {
            context.status(200);
            context.result("Login Successful.");
        }

    };

    class LoginObject {
        public String username;
        public String password;
    }


}
