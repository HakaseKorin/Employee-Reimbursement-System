package com.revature.daos;

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

import static org.mockito.Mockito.*;

public class ReimbursementDaoImplTest extends TestCase {

    @Test
    public void testGetAll() {
        //create a list to get the return object from the mock
        List<Reimbursement> list = new ArrayList<>();
        ReimbursementService rs = new ReimbursementService();
        //Mock the class we're testing that requires db connection
        ReimbursementDao rd = mock(ReimbursementDaoImpl.class);
        //Instance of the class we're testing
        ReimbursementDao reDao = new ReimbursementDaoImpl();

        Reimbursement r = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);
        list.add(r);

        List<Reimbursement> test = reDao.getAll();
        //when it calls the function we're testing it returns the expected return type
        when(rd.getAll()).thenReturn(list);
        //makes sure that the test object has something;
        assertNotNull(test);
    }

    @Test
    public void testGetAllPending() {
        List<Reimbursement> list = new ArrayList<>();
        ReimbursementService rs = new ReimbursementService();

        ReimbursementDao rd = mock(ReimbursementDaoImpl.class);

        ReimbursementDao reDao = new ReimbursementDaoImpl();

        Reimbursement r = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);
        list.add(r);

        List<Reimbursement> test = reDao.getAllPending();

        when(rd.getAllPending()).thenReturn(list);

        assertNotNull(test);
    }

    @Test
    public void testGetAllResolved() {
        List<Reimbursement> list = new ArrayList<>();
        ReimbursementService rs = new ReimbursementService();

        ReimbursementDao rd = mock(ReimbursementDaoImpl.class);

        ReimbursementDao reDao = new ReimbursementDaoImpl();

        Reimbursement r = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);
        list.add(r);

        List<Reimbursement> test = reDao.getAllResolved();

        when(rd.getAllResolved()).thenReturn(list);

        assertNotNull(test);
    }

    @Test
    public void testGetById() {
        ReimbursementService rs = new ReimbursementService();

        ReimbursementDao rd = mock(ReimbursementDaoImpl.class);

        Reimbursement r = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);

        rd.getById(1);

        when(rd.getById(anyInt())).thenReturn(r);

        assertNotNull(r);
    }
}