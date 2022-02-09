package com.revature.services;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

import java.time.LocalDateTime;
import java.util.List;

public class ReimbursementService {

    private ReimbursementDao rd = new ReimbursementDaoImpl();

    public Reimbursement createReimbursement(int id, float amount, LocalDateTime submitted, LocalDateTime resolved,
                                             String description, int author, int resolver, int statusId, int typeId){
        Reimbursement reimbursement = new Reimbursement(id, amount, submitted, resolved, description, author, resolver,
                                                        statusId, typeId);

        rd.create(reimbursement);

        return reimbursement;
    }

    public boolean create(Reimbursement reimbursement){ return rd.create(reimbursement);}

    public boolean update(Reimbursement reimbursement){ return rd.update(reimbursement);}

    public List<Reimbursement> getAll(){ return rd.getAll();}

    public List<Reimbursement> getAllPending(){ return rd.getAllPending();}

    public List<Reimbursement> getAllResolved(){ return rd.getAllResolved();}

    public List<Reimbursement> getByAuthor(int id){ return rd.getByAuthor(id);}

    public List<Reimbursement> getByAuthorAndPending(int id){ return rd.getByAuthorAndPending(id);}

    public List<Reimbursement> getByAuthorAndResolved(int id){ return rd.getByAuthorAndResolved(id);}

}

