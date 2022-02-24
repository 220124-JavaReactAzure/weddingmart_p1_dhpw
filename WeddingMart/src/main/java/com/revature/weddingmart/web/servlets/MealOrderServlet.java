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
import com.revature.weddingmart.models.Asset;
import com.revature.weddingmart.services.AssetService;
import com.revature.weddingmart.services.MealOrderPlusOneService;
import com.revature.weddingmart.services.MealOrderService;

public class MealOrderServlet  extends HttpServlet {
	private final MealOrderService mealOrderService;
	private final ObjectMapper mapper;

	public MealOrderServlet(MealOrderService mealOrderService, ObjectMapper mapper) {
		this.mealOrderService = mealOrderService;
		this.mapper = mapper;
	}

	// GET /mealOrder/id (get mealOrder by id)
	// GET /mealOrder/ (get all assets)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /asset, return all assets
		if (path == null || path.length() < 2) {
			List<MealOrder> mealOrder = mealOrderService.getAllMealOrder();
			String payload = mapper.writeValueAsString(mealOrder);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /mealOrder/N, return mealOrder by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			MealOrder mealOrder = mealOrderService.getMealOrderById(id);
			String payload = mapper.writeValueAsString(mealOrder);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /mealOrder (create mealOrder specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		MealOrder newMealOrder = mapper.readValue(req.getInputStream(), MealOrder.class);
		
		newMealOrder = mealOrderService.addMealOrder(newMealOrder);
		if (newMealOrder == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newMealOrder);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /asset (update asset specified by put body. 404 on asset does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		MealOrder newMealOrder = mapper.readValue(req.getInputStream(), MealOrder.class);

		try {
			mealOrderService.updateMealOrder(newMealOrder);
			String payload = mapper.writeValueAsString(newMealOrder);
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

		// if url is /asset, return all assets
		if (path == null || path.length() < 2) {
			resp.setStatus(404);
		}
		// if url is /asset/N, return asset by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			MealOrder mealOrder = mealOrderService.getMealOrderById(id);
			mealOrderService.deleteMealOrder(mealOrder);
			resp.setStatus(200);
		}
	}
}
	