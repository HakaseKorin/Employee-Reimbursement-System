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
        //creates a list to return to see if getAll() works;
        List<Reimbursement> list = new ArrayList<>();
        ReimbursementService rs = new ReimbursementService();

        //creates a mock of the daoImpl to test to see if its called
        ReimbursementDao rd = mock(ReimbursementDaoImpl.class);

        Reimbursement r = rs.createReimbursement(1, 10.00f,
                LocalDateTime.of(2022, 2, 4, 0, 0),
                LocalDateTime.of(2022, 2,5, 0, 0),
                "",3, 4, 5, 0);
        list.add(r);

        rd.getAll();

        //when ReimbursementDao.getAll() -> returns list
        when(rd.getAll()).thenReturn(list);

        //just to make sure rd.getAll() actually ran
        assertNotNull(list);
    }

    @Test
    public void testGetAllPending() {
    }

    @Test
    public void testGetAllResolved() {
    }

    @Test
    public void testGetById() {
    }
}