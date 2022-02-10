package com.revature.services;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.util.LoggingSingleton;

import java.time.LocalDateTime;
import java.util.List;

public class ReimbursementService {

    private ReimbursementDao rd = new ReimbursementDaoImpl();

    public Reimbursement createReimbursement(int id, float amount, LocalDateTime submitted, LocalDateTime resolved,
                                             String description, int author, int resolver, int statusId, int typeId){
        Reimbursement reimbursement = new Reimbursement(id, amount, submitted, resolved, description, author, resolver,
                                                        statusId, typeId);

        LoggingSingleton.logger.info("New Reimbursement task created: " + reimbursement.toString());

        return reimbursement;
    }

    public boolean create(float amount, String description, int author, int typeId){
        Reimbursement reimbursement = new Reimbursement(amount, description, author, typeId);
        return rd.create(reimbursement);
    }

    public boolean updateStatus(Reimbursement reimbursement){ return rd.updateStatus(reimbursement);}

    public List<Reimbursement> getAll(){ return rd.getAll();}

    public List<Reimbursement> getAllPending(){ return rd.getAllPending();}

    public List<Reimbursement> getAllResolved(){ return rd.getAllResolved();}

    public List<Reimbursement> getByAuthor(int id){ return rd.getByAuthor(id);}

    public List<Reimbursement> getByAuthorAndPending(int id){ return rd.getByAuthorAndPending(id);}

    public List<Reimbursement> getByAuthorAndResolved(int id){ return rd.getByAuthorAndResolved(id);}

}

