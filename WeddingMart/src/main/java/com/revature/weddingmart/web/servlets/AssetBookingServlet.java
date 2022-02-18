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
import com.revature.weddingmart.services.AssetBookingService;

public class AssetBookingServlet extends HttpServlet {
	private final AssetBookingService assetBookingService;
	private final ObjectMapper mapper;

	public AssetBookingServlet(AssetBookingService assetBookingService, ObjectMapper mapper) {
		this.assetBookingService = assetBookingService;
		this.mapper = mapper;
	}

	// GET /assetBooking/id (get assetBooking by id)
	// GET /assetBooking/ (get all assetBookings)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /assetBooking, return all assetBookings
		if (path == null || path.length() < 2) {
			List<AssetBooking> assetBookings = assetBookingService.getAllAssetBookings();
			String payload = mapper.writeValueAsString(assetBookings);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /assetBooking/N, return assetBooking by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			AssetBooking assetBooking = assetBookingService.getAssetBookingById(id);
			String payload = mapper.writeValueAsString(assetBooking);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /assetBooking (create assetBooking specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		AssetBooking newAssetBooking = mapper.readValue(req.getInputStream(), AssetBooking.class);
		
		newAssetBooking = assetBookingService.addAssetBooking(newAssetBooking);
		if (newAssetBooking == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newAssetBooking);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /assetBooking (update assetBooking specified by put body. 404 on assetBooking does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		AssetBooking newAssetBooking = mapper.readValue(req.getInputStream(), AssetBooking.class);

		try {
			assetBookingService.updateAssetBooking(newAssetBooking);
			String payload = mapper.writeValueAsString(newAssetBooking);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
		catch (Exception e) {
			resp.setStatus(500);
		}
	}

	// DELETE /assetBooking/id (delete assetBooking specified by id. 404 on assetBooking does not exist. 200
	// on delete. 500 on server error.)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		// if url is /assetBooking, return all assetBookings
		if (path == null || path.length() < 2) {
			resp.setStatus(404);
		}
		// if url is /assetBooking/N, return assetBooking by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			AssetBooking assetBooking = assetBookingService.getAssetBookingById(id);
			assetBookingService.deleteAssetBooking(assetBooking);
			resp.setStatus(200);
		}
	}
}
