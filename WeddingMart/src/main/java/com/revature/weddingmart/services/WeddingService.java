package com.revature.weddingmart.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.WeddingDAO;
import com.revature.weddingmart.models.Wedding;

public class WeddingService {
	private final WeddingDAO weddingDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public WeddingService(WeddingDAO weddingDAO) {
		logger.debug("Created WeddingService");
		this.weddingDAO = weddingDAO;
	}
	
	public Wedding addWedding(Wedding wedding) {
		logger.debug("called WeddingService.addWedding with " + wedding);
		return weddingDAO.addWedding(wedding);
	}

	public List<Wedding> getAllWeddings() {
		logger.debug("called WeddingService.getAllWeddings");
		return weddingDAO.getAllWeddings();
	}

	public Wedding getWeddingById(int id) {
		logger.debug("called WeddingService.getWeddingById" + id);
		return weddingDAO.getWeddingById(id);
	}

	public void updateWedding(Wedding wedding) {
		logger.debug("called WeddingService.updateWedding");
		weddingDAO.updateWedding(wedding);
	}

	public void deleteWedding(Wedding wedding) {
		logger.debug("called WeddingService.deleteWedding");
		weddingDAO.deleteWedding(wedding);
	}
}
