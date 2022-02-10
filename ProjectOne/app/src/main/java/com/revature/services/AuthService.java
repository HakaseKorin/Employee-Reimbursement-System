package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class AuthService {

    private UserDao userDao;

    public AuthService (UserDao userDao){
        this.userDao = userDao;
    }
    public boolean loginUser(String username, String password){
        User login = userDao.getUserByUsernameAndPassword(username, password);

        if(login == null || !login.getPassword().equals(password)) {
            return false;
        }
        return true;
    }
}
