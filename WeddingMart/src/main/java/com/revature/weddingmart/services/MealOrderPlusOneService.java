package com.revature.weddingmart.services; 
import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.MealOrderPlusOneDAO;
import com.revature.weddingmart.models.MealOrderPlusOne;

public class MealOrderPlusOneService {
	private final MealOrderPlusOneDAO mealOrderPlusOneDAO;
	private Logger logger;
	
	public MealOrderPlusOneService(MealOrderPlusOneDAO MealOrderPlusOneDAO) {
		this.mealOrderPlusOneDAO = MealOrderPlusOneDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created MealOrderPlusOneService");
	}
	
	public MealOrderPlusOne addMealOrderPlusOne(MealOrderPlusOne MealOrderPlusOne) {
		logger.info("called MealOrderPlusOneService.addMealOrderPlusOne with " + MealOrderPlusOne);
		return mealOrderPlusOneDAO.addMealOrderPlusOne(MealOrderPlusOne);
	}

	public List<MealOrderPlusOne> getAllMealOrderPlusOnes() {
		logger.info("called MealOrderPlusOneService.getAllMealOrderPlusOnes");
		return mealOrderPlusOneDAO.getAllMealOrderPlusOnes();
	}

	public MealOrderPlusOne getMealOrderPlusOneById(int id) {
		logger.info("called MealOrderPlusOneService.getMealOrderPlusOneById with id " + id);
		return mealOrderPlusOneDAO.getMealOrderPlusOneById(id);
	}

	public void updateMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		logger.info("called MealOrderPlusOneService.updateMealOrderPlusOne with data " + mealOrderPlusOne);
		mealOrderPlusOneDAO.updateMealOrderPlusOne(mealOrderPlusOne);
	}

	public void deleteMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		logger.info("called MealOrderPlusOne.deleteMealOrderPlusOne");
		mealOrderPlusOneDAO.deleteMealOrderPlusOne(mealOrderPlusOne);
	}
}


