package com.revature.weddingmart.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.AssetDAO;
import com.revature.weddingmart.models.Asset;

public class AssetService {
	private final AssetDAO assetDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public AssetService(AssetDAO assetDAO) {
		logger.debug("Created AssetService");
		this.assetDAO = assetDAO;
	}
	
	public Asset addAsset(Asset asset) {
		logger.debug("called AssetService.addAsset with " + asset);
		return assetDAO.addAsset(asset);
	}

	public List<Asset> getAllAssets() {
		logger.debug("called AssetService.getAllAssets");
		return assetDAO.getAllAssets();
	}

	public Asset getAssetById(int id) {
		logger.debug("called AssetService.getAssetById" + id);
		return assetDAO.getAssetById(id);
	}

	public void updateAsset(Asset asset) {
		logger.debug("called AssetService.updateAsset");
		assetDAO.updateAsset(asset);
	}

	public void deleteAsset(Asset asset) {
		logger.debug("called AssetService.deleteAsset");
		assetDAO.deleteAsset(asset);
	}
}
