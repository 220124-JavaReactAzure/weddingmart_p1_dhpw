package com.revature.weddingmart.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.AssetBookingDAO;
import com.revature.weddingmart.models.AssetBooking;

public class AssetBookingService {
	private final AssetBookingDAO assetBookingDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public AssetBookingService(AssetBookingDAO assetBookingDAO) {
		logger.debug("Created AssetBookingService");
		this.assetBookingDAO = assetBookingDAO;
	}
	
	public AssetBooking addAssetBooking(AssetBooking assetBooking) {
		logger.debug("called AssetBookingService.addAssetBooking with " + assetBooking);
		return assetBookingDAO.addAssetBooking(assetBooking);
	}

	public List<AssetBooking> getAllAssetBookings() {
		logger.debug("called AssetBookingService.getAllAssetBookings");
		return assetBookingDAO.getAllAssetBookings();
	}

	public AssetBooking getAssetBookingById(int id) {
		logger.debug("called AssetBookingService.getAssetBookingById" + id);
		return assetBookingDAO.getAssetBookingById(id);
	}

	public void updateAssetBooking(AssetBooking assetBooking) {
		logger.debug("called AssetBookingService.updateAssetBooking");
		assetBookingDAO.updateAssetBooking(assetBooking);
	}

	public void deleteAssetBooking(AssetBooking assetBooking) {
		logger.debug("called AssetBookingService.deleteAssetBooking");
		assetBookingDAO.deleteAssetBooking(assetBooking);
	}
}
