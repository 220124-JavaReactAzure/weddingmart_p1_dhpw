package com.revature.weddingmart.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.AssetBookingDAO;
import com.revature.weddingmart.models.AssetBooking;

public class AssetBookingServiceTestSuite {
	AssetBookingService sut;
	AssetBookingDAO mockAssetBookingDAO;
	
	@Before
	public void testPrep() {
		mockAssetBookingDAO = mock(AssetBookingDAO.class);
		sut = new AssetBookingService(mockAssetBookingDAO);
	}
	
	@Test
	public void test_addAssetBooking() {
		AssetBooking assetBooking = new AssetBooking();
		when(mockAssetBookingDAO.addAssetBooking(assetBooking)).thenReturn(assetBooking);
		assetBooking = sut.addAssetBooking(assetBooking);
		assertNotNull(assetBooking);
	}
	
	@Test
	public void test_getAllAssetBookings() {
		AssetBooking u1 = new AssetBooking();
		AssetBooking u2 = new AssetBooking();
		AssetBooking u3 = new AssetBooking();
		ArrayList<AssetBooking> assetBookings;
		assetBookings = new ArrayList<>();
		assetBookings.add(u1);
		assetBookings.add(u2);
		assetBookings.add(u3);
		
		when(mockAssetBookingDAO.getAllAssetBookings()).thenReturn(assetBookings);
		
		assetBookings = (ArrayList<AssetBooking>)sut.getAllAssetBookings();
		
		assertNotNull (assetBookings);
		assertFalse( assetBookings.isEmpty() );
	}
	
	@Test
	public void test_getAssetBookingById() {
		AssetBooking assetBooking = new AssetBooking();
		when(mockAssetBookingDAO.getAssetBookingById(1)).thenReturn(assetBooking);
		assetBooking = sut.getAssetBookingById(1);
		assertNotNull(assetBooking);
		assetBooking = sut.getAssetBookingById(0);
		assertNull(assetBooking);
	}
	
	@Test
	public void test_updateAssetBooking() {
		AssetBooking assetBooking = new AssetBooking();
		sut.updateAssetBooking(assetBooking);
		assertNotNull(assetBooking);
	}
	
	@Test
	public void test_deleteAssetBooking() {
		AssetBooking assetBooking = new AssetBooking();
		sut.deleteAssetBooking(assetBooking);
		assertNotNull(assetBooking);
	}
}

