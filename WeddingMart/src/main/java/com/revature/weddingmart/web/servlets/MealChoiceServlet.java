package com.revature.weddingmart.web.servlets;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.models.AssetType;
import com.revature.weddingmart.models.MealChoice;
import com.revature.weddingmart.services.AssetTypeService;
import com.revature.weddingmart.services.MealChoiceService;



public class MealChoiceServlet  extends HttpServlet {

	private final MealChoiceService mealChoiceService;
	private final ObjectMapper mapper;

	public MealChoiceServlet(MealChoiceService mealChoiceService, ObjectMapper mapper) {
		this.mealChoiceService = mealChoiceService;
		this.mapper = mapper;
	}

	// GET /assetType/id (get assetType by id)
	// GET /assetType/ (get all assetTypes)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		List<MealChoice> mealChoice = mealChoiceService.getAllMealChoices();
		String payload = mapper.writeValueAsString(mealChoice);
		writer.write(payload);
		resp.setStatus(200);
	}
}