package com.revature.services;

import com.revature.models.User;

public class UserService {

    public User createUser(int id, String username, String password, String firstName, String lastName, String email, int roleId){
        User user = new User(id, username, password, firstName, lastName, email, roleId);
        return user;
    }
}
