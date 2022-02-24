package com.revature.weddingmart.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.AssetBookingDAO;
import com.revature.weddingmart.models.AssetBooking;

public class AssetBookingService {
	private final AssetBookingDAO assetBookingDAO;
	private Logger logger;
	
	public AssetBookingService(AssetBookingDAO assetBookingDAO) {
		this.assetBookingDAO = assetBookingDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created AssetBookingService");
	}
	
	public AssetBooking addAssetBooking(AssetBooking assetBooking) {
		logger.info("called AssetBookingService.addAssetBooking with " + assetBooking);
		return assetBookingDAO.addAssetBooking(assetBooking);
	}

	public List<AssetBooking> getAllAssetBookings() {
		logger.info("called AssetBookingService.getAllAssetBookings");
		return assetBookingDAO.getAllAssetBookings();
	}

	public AssetBooking getAssetBookingById(int id) {
		logger.info("called AssetBookingService.getAssetBookingById" + id);
		return assetBookingDAO.getAssetBookingById(id);
	}

	public void updateAssetBooking(AssetBooking assetBooking) {
		logger.info("called AssetBookingService.updateAssetBooking");
		assetBookingDAO.updateAssetBooking(assetBooking);
	}

	public void deleteAssetBooking(AssetBooking assetBooking) {
		logger.info("called AssetBookingService.deleteAssetBooking");
		assetBookingDAO.deleteAssetBooking(assetBooking);
	}
}
