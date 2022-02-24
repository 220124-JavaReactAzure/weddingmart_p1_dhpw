package com.revature.weddingmart.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.WeddingDAO;
import com.revature.weddingmart.models.Wedding;

public class WeddingService {
	private final WeddingDAO weddingDAO;
	private Logger logger;
	
	public WeddingService(WeddingDAO weddingDAO) {
		this.weddingDAO = weddingDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created WeddingService");
	}
	
	public Wedding addWedding(Wedding wedding) {
		logger.info("called WeddingService.addWedding with " + wedding);
		return weddingDAO.addWedding(wedding);
	}

	public List<Wedding> getAllWeddings() {
		logger.info("called WeddingService.getAllWeddings");
		return weddingDAO.getAllWeddings();
	}

	public Wedding getWeddingById(int id) {
		logger.info("called WeddingService.getWeddingById with id " + id);
		return weddingDAO.getWeddingById(id);
	}

	public void updateWedding(Wedding wedding) {
		logger.info("called WeddingService.updateWedding with data " + wedding);
		weddingDAO.updateWedding(wedding);
	}

	public void deleteWedding(Wedding wedding) {
		logger.info("called WeddingService.deleteWedding");
		weddingDAO.deleteWedding(wedding);
	}
}
