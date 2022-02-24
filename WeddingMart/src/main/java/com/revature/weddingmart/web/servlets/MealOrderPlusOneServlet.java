package com.revature.weddingmart.web.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.models.AssetBooking;
import com.revature.weddingmart.models.MealOrder;
import com.revature.weddingmart.services.AssetBookingService;
import com.revature.weddingmart.daos.MealOrderDAO;
import com.revature.weddingmart.models.MealOrderPlusOne;
import com.revature.weddingmart.services.MealOrderPlusOneService;
import com.revature.weddingmart.services.MealOrderPlusOneService;
import com.revature.weddingmart.services.MealOrderService;

public class MealOrderPlusOneServlet  extends HttpServlet {
	private final MealOrderPlusOneService mealOrderPlusOneService;
	private final ObjectMapper mapper;

	public MealOrderPlusOneServlet(MealOrderPlusOneService mealOrderPlusOneService, ObjectMapper mapper) {
		this.mealOrderPlusOneService = mealOrderPlusOneService;
		this.mapper = mapper;
	}

	// GET /mealOrderPlusOne/id (get mealOrderPlusOne by id)
	// GET /mealOrderPlusOne/ (get all mealOrderPlusOne)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /mealOrderPlusone, return all MealOrderPlusOne
		if (path == null || path.length() < 2) {
			List<MealOrderPlusOne> mealOrderPlusOne = mealOrderPlusOne.getAllMealOrderPlusOne();
			String payload = mapper.writeValueAsString(mealOrderPlusOne);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /mealOrderPlusOne/N, return mealOrderPlusOne by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			MealOrderPlusOne mealOrderPlusOne = mealOrderPlusOneService.getMealOrderPlusOneById(id);
			String payload = mapper.writeValueAsString(mealOrderPlusOne);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /mealOrderPlusOne (create mealOrderPlusOne specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		MealOrderPlusOne newMealOrderPlusOne = mapper.readValue(req.getInputStream(), MealOrderPlusOne.class);
		
		newMealOrderPlusOne = mealOrderPlusOneService.addMealOrderPlusOne(newMealOrderPlusOne);
		if (newMealOrderPlusOne == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newMealOrderPlusOne);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /asset (update asset specified by put body. 404 on asset does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		MealOrderPlusOne newMealOrderPlusOne = mapper.readValue(req.getInputStream(), MealOrderPlusOne.class);

		try {
			mealOrderPlusOneService.updateMealOrderPlusOne(newMealOrderPlusOne);
			String payload = mapper.writeValueAsString(newMealOrderPlusOne);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
		catch (Exception e) {
			resp.setStatus(500);
		}
	}

	// DELETE /asset/id (delete asset specified by id. 404 on asset does not exist. 200
	// on delete. 500 on server error.)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		// if url is /asset, return all mealOrderPlusOne
		if (path == null || path.length() < 2) {
			resp.setStatus(404);
		}
		// if url is /mealOrderPlusOne/N, return mealOrderPlusOne by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			MealOrderPlusOne mealOrderPlusOne = mealOrderPlusOneService.getMealOrderPlusOneById(id);
			mealOrderPlusOneService.deleteMealOrderPlusOne(mealOrderPlusOne);
			resp.setStatus(200);
		}
	}
}
	