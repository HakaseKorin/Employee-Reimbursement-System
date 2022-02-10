package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest extends TestCase {

    @Test
    public void testCreateUser() {
        UserDao ud = new UserDaoImpl();
        UserService us = new UserService();

        User test = us.createUser(1,"JohnDoe", "password", "John", "Doe", "JohnDoe@email.com", 1 );

        assertNotNull(test);

    }

    @Test
    public void testGetAllUsers(){
        //create a list to get the return object from the mock
        List<User> users = new ArrayList<>();
        UserService us = mock(UserService.class);
        //Instance of the class we're testing

        User user = us.createUser(1,"JohnDoe", "password", "John", "Doe", "JohnDoe@email.com", 1 );
        users.add(user);

        List<User> test = us.getAllUsers();
        //when it calls the function we're testing it returns the expected return type
        when(us.getAllUsers()).thenReturn(users);
        //makes sure that the test object has something;
        assertNotNull(test);
    }
    @Test
    public void testGetUserById(){
    }

    @Test
    public void testUpdateUser(){
    }
}