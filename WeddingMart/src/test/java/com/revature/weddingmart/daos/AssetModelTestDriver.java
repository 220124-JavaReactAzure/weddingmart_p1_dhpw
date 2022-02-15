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
		
		AssetType venue = assetTypeDAO.getByDescription("caterer");
		asset.setAddress("456 Somewhere Drive");
		asset.setEmail("admin@venue.net");
		asset.setName("Bouncy House");
		asset.setPhone("1 (919) 999 5555");
		asset.setPrice(500.00);
		asset.setType(venue);
		
		assetDAO.addAsset(asset);
	}
}
