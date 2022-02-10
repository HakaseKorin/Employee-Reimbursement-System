package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;




public class UserController {

    private UserService us;
    private ObjectMapper mapper = new ObjectMapper();

    public UserController(UserService us){
        this.us = us;
    }

    public Handler createUser = (context) -> {
        User u = mapper.readValue(context.body(), User.class);

        System.out.println(u);

        us.createUser(u.getId(), u.getUsername(), u.getPassword(), u.getFirstName(), u.getLastName(), u.getEmail(),
                u.getRoleId());

        context.result(mapper.writeValueAsString(u));
    };

    public Handler getAllUsers = (context) -> {
        context.result(mapper.writeValueAsString(us.getAllUsers()));
    };

    public Handler getUserById = (context) -> {
        String idParam = context.pathParam("id");
        int id = Integer.parseInt(idParam);

        context.result(mapper.writeValueAsString(us.getUserById(id)));
    };

    public Handler updateUser = (context) -> {
        User u = mapper.readValue(context.body(), User.class);

        System.out.println(u);

        us.createUser(u.getId(), u.getUsername(), u.getPassword(), u.getFirstName(), u.getLastName(), u.getEmail(),
                u.getRoleId());

        context.result(mapper.writeValueAsString(u));

    };

}
