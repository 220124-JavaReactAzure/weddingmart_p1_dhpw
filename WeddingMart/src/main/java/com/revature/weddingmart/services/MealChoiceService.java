package com.revature.weddingmart.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.MealChoiceDAO;
import com.revature.weddingmart.models.*;


public class MealChoiceService {
	private final MealChoiceDAO mealChoiceDAO;
	private Logger logger;
	
	public  MealChoiceService(MealChoiceDAO MealChoiceDAO) {
		this.mealChoiceDAO = MealChoiceDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created MealChoiceService");
	}
	
	public MealChoice addMealChoice(MealChoice mealChoice) {
		logger.info("called MealChoice.addMealChoice with " + mealChoice);
		return mealChoiceDAO.addMealChoice(mealChoice);
	}

	public List<MealChoice> getAllMealChoices() {
		logger.info("called MealChoice.getAllMealChoices");
		return mealChoiceDAO.getAllMealChoices();
	}

	public MealChoice getMealChoiceById(int id) {
		logger.info("called MealChoice.getMealChoiceById with id " + id);
		return mealChoiceDAO.getMealChoiceById(id);
	}

	public void updateMealChoice(MealChoice mealChoice) {
		logger.info("called MealChoice.updateMealChoice with data " + mealChoice);
		mealChoiceDAO.updateMealChoice(mealChoice);
	}

	public void deleteMealChoice(MealChoice mealChoice) {
		logger.info("called MealChoice.deleteMealChoice");
		mealChoiceDAO.deleteMealChoice(mealChoice);
	}
}

	
