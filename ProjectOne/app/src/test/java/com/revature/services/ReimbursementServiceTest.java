package com.revature.services;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ReimbursementServiceTest extends TestCase {

    public void testCreateReimbursement() {
        ReimbursementService rs = new ReimbursementService();

        Reimbursement test = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);

        assertNotNull(test);
    }

    public void testCreate() {
    }

    public void testUpdate() {
    }

    public void testGetAll() {
        //create a list to get the return object from the mock
        List<Reimbursement> list = new ArrayList<>();
        //Mock the class we're testing that requires db connection
        ReimbursementService rs = mock(ReimbursementService.class);

        Reimbursement r = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);
        list.add(r);

        List<Reimbursement> test = rs.getAll();
        //when it calls the function we're testing it returns the expected return type
        when(rs.getAll()).thenReturn(list);
        //makes sure that the test object has something;
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

        List<Reimbursement> test = rs.getAllPending();

        when(rs.getAllPending()).thenReturn(list);

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

        List<Reimbursement> test = rs.getAllResolved();

        when(rs.getAllResolved()).thenReturn(list);
        assertNotNull(test);
    }

    public void testGetById() {
        //ReimbursementService rs = new ReimbursementService();
        ReimbursementService rs = Mockito.mock(ReimbursementService.class);
        ReimbursementService testService = new ReimbursementService();

        Reimbursement test = rs.getById(6);

        Reimbursement r = new Reimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",1, 2, 1, 1);

        when(rs.getById(anyInt())).thenReturn(r);

        verify(rs).getById(anyInt());
        System.out.println(test);
        //assertNotNull(test);
    }
}