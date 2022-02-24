package com.revature.weddingmart.services; 
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.MealOrderPlusOneDAO;
import com.revature.weddingmart.models.MealOrderPlusOne;

public class MealOrderPlusOneService {
	private final MealOrderPlusOneDAO mealOrderPlusOneDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public MealOrderPlusOneService(MealOrderPlusOneDAO MealOrderPlusOneDAO) {
		logger.debug("Created MealOrderPlusOneService");
		this.mealOrderPlusOneDAO = MealOrderPlusOneDAO;
	}
	
	public MealOrderPlusOne addMealOrderPlusOne(MealOrderPlusOne MealOrderPlusOne) {
		logger.debug("called MealOrderPlusOneService.addMealOrderPlusOne with " + MealOrderPlusOne);
		return mealOrderPlusOneDAO.addMealOrderPlusOne(MealOrderPlusOne);
	}

	public List<MealOrderPlusOne> getAllMealOrderPlusOnes() {
		logger.debug("called MealOrderPlusOneService.getAllMealOrderPlusOnes");
		return mealOrderPlusOneDAO.getAllMealOrderPlusOnes();
	}

	public MealOrderPlusOne getMealOrderPlusOneById(int id) {
		logger.debug("called MealOrderPlusOneService.getMealOrderPlusOneById" + id);
		return mealOrderPlusOneDAO.getMealOrderPlusOneById(id);
	}

	public void updateMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		logger.debug("called MealOrderPlusOneService.updateMealOrderPlusOne");
		mealOrderPlusOneDAO.updateMealOrderPlusOne(mealOrderPlusOne);
	}

	public void deleteMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		logger.debug("called MealOrderPlusOne.deleteMealOrderPlusOne");
		mealOrderPlusOneDAO.deleteMealOrderPlusOne(mealOrderPlusOne);
	}
}


