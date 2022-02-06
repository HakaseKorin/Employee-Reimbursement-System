package com.revature;

import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.Javalin;

import java.util.List;

public class ExpensesReimbursementSystemDriver {

    public static void main(String[] args){

        Javalin app = Javalin.create().start();

        app.get("/",ctx -> ctx.result("Hello World"));

        UserService userService = new UserService();
        app.get("/users",ctx -> {
            List<User> users = userService.getAllUsers();
            ctx.json(users);


        });
    }

}
