package com.revature.weddingmart.services.users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.users.BetrothedDAO;
import com.revature.weddingmart.models.users.Betrothed;

public class BetrothedServiceTestSuite {
	BetrothedService sut;
	BetrothedDAO mockBetrothedDAO;
	
	@Before
	public void testPrep() {
		mockBetrothedDAO = mock(BetrothedDAO.class);
		sut = new BetrothedService(mockBetrothedDAO);
	}
	
	@Test
	public void test_addBetrothed() {
		Betrothed betrothed = new Betrothed();
		when(mockBetrothedDAO.addBetrothed(betrothed)).thenReturn(betrothed);
		betrothed = sut.addBetrothed(betrothed);
		assertNotNull(betrothed);
	}
	
	@Test
	public void test_getAllBetrotheds() {
		Betrothed u1 = new Betrothed();
		Betrothed u2 = new Betrothed();
		Betrothed u3 = new Betrothed();
		ArrayList<Betrothed> betrotheds;
		betrotheds = new ArrayList<>();
		betrotheds.add(u1);
		betrotheds.add(u2);
		betrotheds.add(u3);
		
		when(mockBetrothedDAO.getAllBetrotheds()).thenReturn(betrotheds);
		
		betrotheds = (ArrayList<Betrothed>)sut.getAllBetrotheds();
		
		assertNotNull (betrotheds);
		assertFalse( betrotheds.isEmpty() );
	}
	
	@Test
	public void test_getBetrothedById() {
		Betrothed betrothed = new Betrothed();
		when(mockBetrothedDAO.getBetrothedById(1)).thenReturn(betrothed);
		betrothed = sut.getBetrothedById(1);
		assertNotNull(betrothed);
		betrothed = sut.getBetrothedById(0);
		assertNull(betrothed);
	}
	
	@Test
	public void test_updateBetrothed() {
		Betrothed betrothed = new Betrothed();
		sut.updateBetrothed(betrothed);
		assertNotNull(betrothed);
	}
	
	@Test
	public void test_deleteBetrothed() {
		Betrothed betrothed = new Betrothed();
		sut.deleteBetrothed(betrothed);
		assertNotNull(betrothed);
	}
}

