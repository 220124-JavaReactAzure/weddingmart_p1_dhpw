package com.revature.weddingmart.daos;

import java.util.List;

import com.revature.weddingmart.models.Asset;
import com.revature.weddingmart.models.AssetType;

public class AssetModelTestDriver {
	public static void main(String args[]) {
		Asset asset = new Asset();
		AssetTypeDAO assetTypeDAO = new AssetTypeDAO();
		AssetDAO assetDAO = new AssetDAO();
		
		List<AssetType> asset_types = assetTypeDAO.getAllAssetTypes();
		
		for (AssetType a: asset_types) {
			System.out.println(a.getDescription());
		}
		
		AssetType venue = assetTypeDAO.getByDescription("venue");
		asset.setAddress("123 Anywhere Street");
		asset.setEmail("admin@venue.com");
		asset.setName("Venue");
		asset.setPhone("1 (919) 123 4567");
		asset.setPrice(300.00);
		asset.setType(venue);
		
		assetDAO.addAsset(asset);
	}
}
