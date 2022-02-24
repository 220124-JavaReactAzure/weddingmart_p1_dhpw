package com.revature.weddingmart.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.AssetTypeDAO;
import com.revature.weddingmart.models.AssetType;

public class AssetTypeService {
	private final AssetTypeDAO assetTypeDAO;
	private Logger logger;
	
	public AssetTypeService(AssetTypeDAO assetTypeDAO) {
		this.assetTypeDAO = assetTypeDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created AssetTypeService");
	}
	
	public List<AssetType> getAllAssetTypes() {
		logger.info("called AssetTypeService.getAllAssetTypes");
		return assetTypeDAO.getAllAssetTypes();
	}
}
