package com.revature.weddingmart.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.AssetDAO;
import com.revature.weddingmart.models.Asset;

public class AssetService {
	private final AssetDAO assetDAO;
	private Logger logger;
    
	
	public AssetService(AssetDAO assetDAO) {
		this.assetDAO = assetDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created AssetService");
	}
	
	public Asset addAsset(Asset asset) {
		logger.info("called AssetService.addAsset with " + asset);
		return assetDAO.addAsset(asset);
	}

	public List<Asset> getAllAssets() {
		logger.info("called AssetService.getAllAssets");
		return assetDAO.getAllAssets();
	}

	public Asset getAssetById(int id) {
		logger.info("called AssetService.getAssetById with id " + id);
		return assetDAO.getAssetById(id);
	}

	public void updateAsset(Asset asset) {
		logger.info("called AssetService.updateAsset with data " + asset);
		assetDAO.updateAsset(asset);
	}

	public void deleteAsset(Asset asset) {
		logger.info("called AssetService.deleteAsset");
		assetDAO.deleteAsset(asset);
	}
}
