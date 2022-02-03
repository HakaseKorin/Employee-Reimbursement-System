package com.revature.services;

import com.revature.models.Reimbursement;

import java.sql.Date;

public class ReimbursementService {

    public Reimbursement createReimbursement(int id, float amount, Date submitted, Date resolved, int author,
                                             int resolver, int statusId, int typeId){
        Reimbursement reimbursement = new Reimbursement(id, amount, submitted, resolved, author, resolver, statusId,
                                                        typeId);
        return reimbursement;
    }
}
