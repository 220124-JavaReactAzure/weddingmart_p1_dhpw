package com.revature.weddingmart.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.MealOrderDAO;
import com.revature.weddingmart.models.MealOrder;

public class MealOrderService {
	private final MealOrderDAO mealOrderDAO;
	private Logger logger;
	
	public MealOrderService(MealOrderDAO mealOrderDAO) {
		this.mealOrderDAO = mealOrderDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created MealOrderService");
	}
	
	public MealOrder addMealOrder(MealOrder mealOrder) {
		logger.info("called MealOrderService.addMealOrder with " + mealOrder);
		return mealOrderDAO.addMealOrder(mealOrder);
	}

	public List<MealOrder> getAllMealOrder() {
		logger.info("called MealOrder.getAllMealOrder");
		return mealOrderDAO.getAllMealOrders();
	}

	public MealOrder getMealOrderById(int id) {
		logger.info("called MealOrderService.getMealOrderById with id " + id);
		return mealOrderDAO.getMealOrderById(id);
	}

	public void updateMealOrder(MealOrder mealOrder) {
		logger.info("called MealOrderService.updateMealOrder with data " + mealOrder);
		mealOrderDAO.updateMealOrder(mealOrder);
	}

	public void deleteMealOrder(MealOrder mealOrder) {
		logger.info("called MealOrder.deleteMealOrder");
		mealOrderDAO.deleteMealOrder(mealOrder);
	}
}
