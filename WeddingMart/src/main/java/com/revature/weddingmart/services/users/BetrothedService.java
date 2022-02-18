package com.revature.weddingmart.services.users;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.users.BetrothedDAO;
import com.revature.weddingmart.models.users.Betrothed;

public class BetrothedService {
	private final BetrothedDAO betrothedDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public BetrothedService(BetrothedDAO betrothedDAO) {
		logger.debug("Created BetrothedService");
		this.betrothedDAO = betrothedDAO;
	}
	
	public Betrothed addBetrothed(Betrothed betrothed) {
		logger.debug("called BetrothedService.addBetrothed with " + betrothed);
		return betrothedDAO.addBetrothed(betrothed);
	}

	public List<Betrothed> getAllBetrotheds() {
		logger.debug("called BetrothedService.getAllBetrotheds");
		return betrothedDAO.getAllBetrotheds();
	}

	public Betrothed getBetrothedById(int id) {
		logger.debug("called BetrothedService.getBetrothedById" + id);
		return betrothedDAO.getBetrothedById(id);
	}

	public void updateBetrothed(Betrothed betrothed) {
		logger.debug("called BetrothedService.updateBetrothed");
		betrothedDAO.updateBetrothed(betrothed);
	}

	public void deleteBetrothed(Betrothed betrothed) {
		logger.debug("called BetrothedService.deleteBetrothed");
		betrothedDAO.deleteBetrothed(betrothed);
	}
}
