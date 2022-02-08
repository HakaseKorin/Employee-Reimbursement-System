package com.revature.daos;

import com.revature.models.User;
import com.revature.services.UserService;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDaoImplTest extends TestCase {

    @Test
    public void testGetAllUsers(){
        //create a list to get the return object from the mock
        List<User> users = new ArrayList<>();
        UserService us = new UserService();
        //Mock the class we're testing that requires db connection
        UserDao userDao = mock(UserDaoImpl.class);
        //Instance of the class we're testing
        UserDao usrDao = new UserDaoImpl();

        User user = us.createUser(1,"JohnDoe", "password", "John", "Doe", "JohnDoe@email.com", 1 );
        users.add(user);

        List<User> test = usrDao.getAllUsers();
        //when it calls the function we're testing it returns the expected return type
        when(userDao.getAllUsers()).thenReturn(users);
        //makes sure that the test object has something;
        assertNotNull(test);
    }

    @Test
    public void testGetUserById(){
        UserService us = new UserService();

        UserDao userDao = mock(UserDaoImpl.class);

        User user = us.createUser(1,"JohnDoe", "password", "John", "Doe", "JohnDoe@email.com", 1 );
        userDao.getUserById(1);

        when(userDao.getUserById(anyInt())).thenReturn(user);

        assertNotNull(user);

    }
    @Test
    public void testUpdateUser(){
        UserService us = new UserService();

        UserDao userDao = mock(UserDaoImpl.class);
        User user = us.createUser(1,"JohnDoe", "password", "John", "Doe", "JohnDoe@email.com", 1 );
        userDao.updateUser(user);

        when(userDao.updateUser(user)).thenReturn(true);

        assertNotNull(user);

    }


}

