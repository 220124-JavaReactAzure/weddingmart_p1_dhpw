package com.revature.weddingmart.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.MealOrderDAO;
import com.revature.weddingmart.models.MealOrder;



public class MealOrderService {
	private final MealOrderDAO mealOrderDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public MealOrderService(MealOrderDAO mealOrderDAO) {
		logger.debug("Created MealOrder");
		this.mealOrderDAO = mealOrderDAO;
	}
	
	public MealOrder addMealOrder(MealOrder mealOrder) {
		logger.debug("called MealOrderService.addMealOrder with " + mealOrder);
		return mealOrderDAO.addMealOrder(mealOrder);
	}

	public List<MealOrder> getAllMealOrder() {
		logger.debug("called MealOrder.getAllMealOrder");
		return mealOrderDAO.getAllMealOrders();
	}

	public MealOrder getMealOrderById(int id) {
		logger.debug("called MealOrderService.getMealOrderById" + id);
		return mealOrderDAO.getMealOrderById(id);
	}

	public void updateMealOrder(MealOrder mealOrder) {
		logger.debug("called MealOrderService.updateMealOrder");
		mealOrderDAO.updateMealOrder(mealOrder);
	}

	public void deleteMealOrder(MealOrder mealOrder) {
		logger.debug("called MealOrder.deleteMealOrder");
		mealOrderDAO.deleteMealOrder(mealOrder);
	}
}
