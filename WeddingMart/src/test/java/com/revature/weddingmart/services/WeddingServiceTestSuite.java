package com.revature.weddingmart.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.WeddingDAO;
import com.revature.weddingmart.models.Wedding;

public class WeddingServiceTestSuite {
	WeddingService sut;
	WeddingDAO mockWeddingDAO;
	
	@Before
	public void testPrep() {
		mockWeddingDAO = mock(WeddingDAO.class);
		sut = new WeddingService(mockWeddingDAO);
	}
	
	@Test
	public void test_addWedding() {
		Wedding wedding = new Wedding();
		when(mockWeddingDAO.addWedding(wedding)).thenReturn(wedding);
		wedding = sut.addWedding(wedding);
		assertNotNull(wedding);
	}
	
	@Test
	public void test_getAllWeddings() {
		Wedding u1 = new Wedding();
		Wedding u2 = new Wedding();
		Wedding u3 = new Wedding();
		ArrayList<Wedding> weddings;
		weddings = new ArrayList<>();
		weddings.add(u1);
		weddings.add(u2);
		weddings.add(u3);
		
		when(mockWeddingDAO.getAllWeddings()).thenReturn(weddings);
		
		weddings = (ArrayList<Wedding>)sut.getAllWeddings();
		
		assertNotNull (weddings);
		assertFalse( weddings.isEmpty() );
	}
	
	@Test
	public void test_getWeddingById() {
		Wedding wedding = new Wedding();
		when(mockWeddingDAO.getWeddingById(1)).thenReturn(wedding);
		wedding = sut.getWeddingById(1);
		assertNotNull(wedding);
		wedding = sut.getWeddingById(0);
		assertNull(wedding);
	}
	
	@Test
	public void test_updateWedding() {
		Wedding wedding = new Wedding();
		sut.updateWedding(wedding);
		assertNotNull(wedding);
	}
	
	@Test
	public void test_deleteWedding() {
		Wedding wedding = new Wedding();
		sut.deleteWedding(wedding);
		assertNotNull(wedding);
	}
}

