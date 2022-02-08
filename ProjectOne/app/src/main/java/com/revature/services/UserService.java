package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

import java.util.List;

public class UserService {

    private final UserDao userDao = new UserDaoImpl();

    public User createUser(int id, String username, String password, String firstName, String lastName, String email, int roleId){
        User user = new User(id, username, password, firstName, lastName, email, roleId);
        return user;
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public boolean updateUser(User u){
        return userDao.updateUser(u);
    }

    public boolean createUser(User newUser) { return userDao.createUser ();}
}
