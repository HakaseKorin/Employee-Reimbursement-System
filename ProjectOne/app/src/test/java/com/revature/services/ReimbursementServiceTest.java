package com.revature.services;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import junit.framework.TestCase;
import net.bytebuddy.asm.Advice;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ReimbursementServiceTest extends TestCase {

    @Mock
    static ReimbursementDao rd;

    @InjectMocks
    private static ReimbursementService rs = new ReimbursementService();

    @Before
    public void initMocks(){
        MockitoAnnotations.openMocks(this);
    }

    public void testCreateReimbursement() {
        ReimbursementService rs = mock(ReimbursementService.class);

        Reimbursement test = new Reimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);

        when(rs.createReimbursement(
                anyInt(), anyFloat(), any(), any(), anyString(),anyInt(),anyInt(),anyInt(),anyInt())).thenReturn(test);

        rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);

        assertNotNull(test);

    }

    public void testCreate(){
        ReimbursementService rs = mock(ReimbursementService.class);

        when(rs.create(anyFloat(),anyString(),anyInt(),anyInt())).thenReturn(true);

        boolean status = rs.create(100.00f, "test", 1,1);
        assertTrue(status);
    }

    public void testUpdateStatus() {
        ReimbursementService rs = mock(ReimbursementService.class);

        Reimbursement r = new Reimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);

        when(rs.updateStatus(r)).thenReturn(true);
        boolean status = rs.updateStatus(r);
        assertTrue(status);
    }


    public void testGetAll() {
        List<Reimbursement> list = new ArrayList<>();
        ReimbursementService rs = mock(ReimbursementService.class);

        Reimbursement r = new Reimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);
        list.add(r);

        when(rs.getAll()).thenReturn(list);
        List<Reimbursement> test = rs.getAll();
        assertNotNull(test);
    }

    public void testGetAllPending() {
        List<Reimbursement> list = new ArrayList<>();
        ReimbursementService rs = mock(ReimbursementService.class);

        Reimbursement r = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);
        list.add(r);

        when(rs.getAllPending()).thenReturn(list);
        List<Reimbursement> test = rs.getAllPending();

        assertNotNull(test);
    }

    public void testGetAllResolved() {
        List<Reimbursement> list = new ArrayList<>();
        ReimbursementService rs = mock(ReimbursementService.class);

        Reimbursement r = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);
        list.add(r);

        when(rs.getAllResolved()).thenReturn(list);
        List<Reimbursement> test = rs.getAllResolved();

        assertNotNull(test);
    }

}