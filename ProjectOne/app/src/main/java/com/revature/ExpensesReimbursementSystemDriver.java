package com.revature;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ExpensesReimbursementSystemDriver {


    public static void main(String[] args){

  /*      try {
            Connection c = ConnectionUtil.getConnection();
            System.out.println(c.getMetaData().getDriverName());
        }catch (SQLException e){
            e.printStackTrace();
        }

  */

  /*      UserDao userDao = new UserDaoImpl();
        User u = new User(5,"Tony11", "pass@111","Tony", "Blatter", "Tony.Blatter@email.com", 1);

        boolean success = userDao.createUser(u);
        System.out.println(success);
*/
        Javalin app = Javalin.create().start();

        app.get("/",ctx -> ctx.result("Hello World"));

        UserService userService = new UserService();
        app.get("/ers_user",ctx -> {
            List<User> users = userService.getAllUsers();
            ctx.json(users);

        });

            app.get("/ers_user/{id}",ctx -> {
            String idParam = ctx.pathParam("id");
            int id = Integer.parseInt(idParam);
            User user = userService.getUserById(id);
            ctx.json(user);

        });

            app.post("/ers_user", ctx -> {
                User newUser = ctx.bodyAsClass(User.class);
                boolean success = userService.createUser(newUser);

                if(success) {
                    ctx.status(201);
                }else {
                    ctx.status(400);

                }
            });

            app.put("/ers_user/{id}", ctx ->{
                //interpret incoming request
               String idParam = ctx.pathParam("id");
               User userToUpdate = ctx.bodyAsClass(User.class);
               int idToUpdate = Integer.parseInt(idParam);
               userToUpdate.setId(idToUpdate);
                //fulfill the request
               boolean success = userService.updateUser(userToUpdate);

               //response body msg to client
               if(success) {
                   ctx.status(200);
               }else {
                   ctx.status(400);
               }

            } );

    }

}
