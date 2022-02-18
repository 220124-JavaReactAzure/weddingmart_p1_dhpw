package com.revature.weddingmart.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.AssetDAO;
import com.revature.weddingmart.models.Asset;

public class AssetServiceTestSuite {
	AssetService sut;
	AssetDAO mockAssetDAO;
	
	@Before
	public void testPrep() {
		mockAssetDAO = mock(AssetDAO.class);
		sut = new AssetService(mockAssetDAO);
	}
	
	@Test
	public void test_addAsset() {
		Asset asset = new Asset();
		when(mockAssetDAO.addAsset(asset)).thenReturn(asset);
		asset = sut.addAsset(asset);
		assertNotNull(asset);
	}
	
	@Test
	public void test_getAllAssets() {
		Asset u1 = new Asset();
		Asset u2 = new Asset();
		Asset u3 = new Asset();
		ArrayList<Asset> assets;
		assets = new ArrayList<>();
		assets.add(u1);
		assets.add(u2);
		assets.add(u3);
		
		when(mockAssetDAO.getAllAssets()).thenReturn(assets);
		
		assets = (ArrayList<Asset>)sut.getAllAssets();
		
		assertNotNull (assets);
		assertFalse( assets.isEmpty() );
	}
	
	@Test
	public void test_getAssetById() {
		Asset asset = new Asset();
		when(mockAssetDAO.getAssetById(1)).thenReturn(asset);
		asset = sut.getAssetById(1);
		assertNotNull(asset);
		asset = sut.getAssetById(0);
		assertNull(asset);
	}
	
	@Test
	public void test_updateAsset() {
		Asset asset = new Asset();
		sut.updateAsset(asset);
		assertNotNull(asset);
	}
	
	@Test
	public void test_deleteAsset() {
		Asset asset = new Asset();
		sut.deleteAsset(asset);
		assertNotNull(asset);
	}
}

