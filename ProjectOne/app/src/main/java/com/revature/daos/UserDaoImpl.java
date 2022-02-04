package com.revature.daos;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public List<User> getAllUsers(User u) {

        String sql = "select * from user";
        List<User>users = new ArrayList<>();

        try(Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement();) {

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                int id = rs.getInt("id");
                user.setId(id);

                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setRoleId(rs.getInt(7));

                users.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }

        return null;
    }
}
