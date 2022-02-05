package com.revature.daos;

import com.revature.models.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();
    public User getUserById(int id);
    public boolean updateUser(User u);

}
