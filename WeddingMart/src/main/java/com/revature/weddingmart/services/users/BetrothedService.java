package com.revature.weddingmart.services.users;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.users.BetrothedDAO;
import com.revature.weddingmart.models.users.Betrothed;

public class BetrothedService {
	private final BetrothedDAO betrothedDAO;
	private Logger logger;
	
	public BetrothedService(BetrothedDAO betrothedDAO) {
		this.betrothedDAO = betrothedDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created BetrothedService");
	}
	
	public Betrothed addBetrothed(Betrothed betrothed) {
		logger.info("called BetrothedService.addBetrothed with " + betrothed);
		return betrothedDAO.addBetrothed(betrothed);
	}

	public List<Betrothed> getAllBetrotheds() {
		logger.info("called BetrothedService.getAllBetrotheds");
		return betrothedDAO.getAllBetrotheds();
	}

	public Betrothed getBetrothedById(int id) {
		logger.info("called BetrothedService.getBetrothedById with id " + id);
		return betrothedDAO.getBetrothedById(id);
	}

	public void updateBetrothed(Betrothed betrothed) {
		logger.info("called BetrothedService.updateBetrothed with data " + betrothed);
		betrothedDAO.updateBetrothed(betrothed);
	}

	public void deleteBetrothed(Betrothed betrothed) {
		logger.info("called BetrothedService.deleteBetrothed");
		betrothedDAO.deleteBetrothed(betrothed);
	}
}
