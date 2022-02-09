package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;
import org.postgresql.util.PGmoney;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao{

    @Override
    public boolean create(Reimbursement reimbursement) {
        String sql = "insert into \"ProjectOne\".ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, " +
                "reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)" +
                " values (? ,? ,? ,? ,? ,? ,? ,?)";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            PGmoney money = new PGmoney(reimbursement.getAmount());
            ps.setObject(1, money);
            Timestamp submitted = Timestamp.valueOf(reimbursement.getSubmitted());
            ps.setTimestamp(2, submitted);
            Timestamp resolved = Timestamp.valueOf(reimbursement.getResolved());
            ps.setTimestamp(3, resolved);
            ps.setString(4, reimbursement.getDescription());
            ps.setInt(5, reimbursement.getAuthor());
            ps.setInt(6, reimbursement.getResolver());
            ps.setInt(7, reimbursement.getStatusId());
            ps.setInt(8, reimbursement.getTypeId());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Reimbursement reimbursement) {
        String sql = "";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){


            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1)
                return true;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Reimbursement> getAll() {
        String sql = "select * from \"ProjectOne\".ers_reimbursement;";
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
        String sql = "select * from \"ProjectOne\".ers_reimbursement where reimb_status_id = 1;";
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
        String sql = "select * from \"ProjectOne\".ers_reimbursement where reimb_status_id = 2";
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
    public List<Reimbursement> getByAuthor(int sid) {
        String sql = "select * from \"ProjectOne\".ers_reimbursement where reimb_author = ?";
        List<Reimbursement> list = new ArrayList<>();

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,sid);

            ResultSet rs = ps.executeQuery();

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
    public List<Reimbursement> getByAuthorAndPending(int sid) {
        String sql = "select * from \"ProjectOne\".ers_reimbursement where reimb_author = ?" +
                " and where reimb_status_id = 1";
        List<Reimbursement> list = new ArrayList<>();

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,sid);

            ResultSet rs = ps.executeQuery();

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
    public List<Reimbursement> getByAuthorAndResolved(int sid) {
        String sql = "select * from \"ProjectOne\".ers_reimbursement where reimb_author = ?" +
                " and where reimb_status_id = 2";
        List<Reimbursement> list = new ArrayList<>();

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,sid);

            ResultSet rs = ps.executeQuery();

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
}
