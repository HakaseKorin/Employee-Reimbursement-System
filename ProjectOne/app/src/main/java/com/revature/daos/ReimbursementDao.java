package com.revature.daos;

import com.revature.models.Reimbursement;

import java.time.LocalDateTime;
import java.util.List;

public interface ReimbursementDao {

    List<Reimbursement> getAll();
}
