package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao{

    @Override
    public List<Reimbursement> getAll() {
        String sql = "select * from ers_reimbursement;";
        List<Reimbursement> list = new ArrayList<>();

        try(Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("reimb_id"));
                r.setAmount(rs.getFloat("reimb_amount"));
                r.setSubmitted(rs.getObject("reimb_submitted", LocalDateTime.class));
                r.setResolved(rs.getObject("reimb_resolved", LocalDateTime.class));
                r.setDescription(rs.getString("reimb_description"));
                r.setAuthor(rs.getInt("reimb_author"));
                r.setResolver(rs.getInt("reimb_resolver"));
                r.setStatusId(rs.getInt("reimb_status_id"));
                r.setTypeId(rs.getInt("reimb_type_id"));

                list.add(r);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAllPending() {
        String sql = "select * from ers_reimbursement where reimb_status_id = 1;";
        List<Reimbursement> list = new ArrayList<>();

        try(Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("reimb_id"));
                r.setAmount(rs.getFloat("reimb_amount"));
                r.setSubmitted(rs.getObject("reimb_submitted", LocalDateTime.class));
                r.setResolved(rs.getObject("reimb_resolved", LocalDateTime.class));
                r.setDescription(rs.getString("reimb_description"));
                r.setAuthor(rs.getInt("reimb_author"));
                r.setResolver(rs.getInt("reimb_resolver"));
                r.setStatusId(rs.getInt("reimb_status_id"));
                r.setTypeId(rs.getInt("reimb_type_id"));

                list.add(r);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAllResolved() {
        String sql = "select * from ers_reimbursement reimb_status_id = 2;";
        List<Reimbursement> list = new ArrayList<>();

        try(Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("reimb_id"));
                r.setAmount(rs.getFloat("reimb_amount"));
                r.setSubmitted(rs.getObject("reimb_submitted", LocalDateTime.class));
                r.setResolved(rs.getObject("reimb_resolved", LocalDateTime.class));
                r.setDescription(rs.getString("reimb_description"));
                r.setAuthor(rs.getInt("reimb_author"));
                r.setResolver(rs.getInt("reimb_resolver"));
                r.setStatusId(rs.getInt("reimb_status_id"));
                r.setTypeId(rs.getInt("reimb_type_id"));

                list.add(r);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reimbursement getById(int id) {
        String sql = "select * from ers_reimbursement where reimb_id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("reimb_id"));
                r.setAmount(rs.getFloat("reimb_amount"));
                r.setSubmitted(rs.getObject("reimb_submitted", LocalDateTime.class));
                r.setResolved(rs.getObject("reimb_resolved", LocalDateTime.class));
                r.setDescription(rs.getString("reimb_description"));
                r.setAuthor(rs.getInt("reimb_author"));
                r.setResolver(rs.getInt("reimb_resolver"));
                r.setStatusId(rs.getInt("reimb_status_id"));
                r.setTypeId(rs.getInt("reimb_type_id"));

                return r;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
