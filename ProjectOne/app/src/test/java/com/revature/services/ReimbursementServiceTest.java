package com.revature.services;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatcher.*;
import static org.mockito.Mockito.*;

public class ReimbursementServiceTest extends TestCase {

    @Test
    public void testCreateReimbursement() {

        ReimbursementService rs = new ReimbursementService();

        Reimbursement test = rs.createReimbursement(1, 10.00f, LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),3, 4, 5, 0);

        assertNotNull(test);
    }
}