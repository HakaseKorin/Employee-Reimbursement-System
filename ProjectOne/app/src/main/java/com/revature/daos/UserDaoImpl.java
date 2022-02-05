package com.revature.daos;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public List<User> getAllUsers() {
        String sql = "select * from ers_user;";
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


    @Override
    public User getUserById(int id) {
        String sql = "select from ers_user where user id = ? ";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                User user = new User();
                user.setId(id);

                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setRoleId(rs.getInt(7));

                return user;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateUser(User u) {
        String sql = "select ers_user set username = ?, password = ?, firstName = ?, lastName = ?, email = ?, roleId = ? where id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, u.getId());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4,u.getFirstName());
            ps.setString(5,u.getLastName());
            ps.setString(6,u.getEmail());
            ps.setInt(7,u.getRoleId());

            int rowAffected = ps.executeUpdate();

            if(rowAffected==1){
                return true;

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
