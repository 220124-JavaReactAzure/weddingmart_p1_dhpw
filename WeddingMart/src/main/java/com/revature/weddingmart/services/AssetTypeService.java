package com.revature.weddingmart.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.AssetTypeDAO;
import com.revature.weddingmart.models.AssetType;

public class AssetTypeService {
	private final AssetTypeDAO assetTypeDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public AssetTypeService(AssetTypeDAO assetTypeDAO) {
		logger.debug("Created AssetService");
		this.assetTypeDAO = assetTypeDAO;
	}
	
	public List<AssetType> getAllAssetTypes() {
		logger.debug("called AssetService.getAllAssets");
		return assetTypeDAO.getAllAssetTypes();
	}
}
