package com.revature.weddingmart.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.weddingmart.daos.MealChoiceDAO;
import com.revature.weddingmart.models.*;


public class MealChoiceService {
	private final MealChoiceDAO mealChoiceDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public  MealChoiceService(MealChoiceDAO MealChoiceDAO) {
		logger.debug("Created MealChoiceService");
		this.mealChoiceDAO = MealChoiceDAO;
	}
	
	public MealChoice addMealChoice(MealChoice mealChoice) {
		logger.debug("called MealChoice.addMealChoice with " + mealChoice);
		return mealChoiceDAO.addMealChoice(mealChoice);
	}

	public List<MealChoice> getAllMealChoices() {
		logger.debug("called MealChoice.getAllMealChoices");
		return mealChoiceDAO.getAllMealChoices();
	}

	public MealChoice getMealChoiceById(int id) {
		logger.debug("called MealChoice.getMealChoiceById" + id);
		return mealChoiceDAO.getMealChoiceById(id);
	}

	public void updateMealChoice(MealChoice mealChoice) {
		logger.debug("called MealChoice.updateMealChoice");
		mealChoiceDAO.updateMealChoice(mealChoice);
	}

	public void deleteMealChoice(MealChoice mealChoice) {
		logger.debug("called MealChoice.deleteMealChoice");
		mealChoiceDAO.deleteMealChoice(mealChoice);
	}
}

	
