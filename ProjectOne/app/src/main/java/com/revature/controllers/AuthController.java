package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;

public class AuthController {

    private final UserService userService = new UserService();

    public void authenticateLogin(Context ctx){
        //interpret request
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        //fulfil the request
        User user = userService.getUserByUsernameAndPassword(username, password);

        //preparing response
        if(user == null) {
            throw new UnauthorizedResponse("Incorrect credential");
        }else {
            ctx.status(200);
        }
    }
}
