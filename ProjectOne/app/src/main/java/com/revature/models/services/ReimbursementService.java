package com.revature.models.services;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ReimbursementService {

    private ReimbursementDao rd = new ReimbursementDaoImpl();

    public Reimbursement createReimbursement(int id, float amount, LocalDateTime submitted, LocalDateTime resolved,
                                             String description, int author, int resolver, int statusId, int typeId){
        Reimbursement reimbursement = new Reimbursement(id, amount, submitted, resolved, description, author, resolver,
                                                        statusId, typeId);
        return reimbursement;
    }

    public List<Reimbursement> getAll(){ return rd.getAll();}

    public List<Reimbursement> getAllPending(){ return rd.getAllPending();}

    public List<Reimbursement> getAllResolved(){ return rd.getAllResolved();}

    public Reimbursement  getById(int id){ return rd.getById(id);}

}
