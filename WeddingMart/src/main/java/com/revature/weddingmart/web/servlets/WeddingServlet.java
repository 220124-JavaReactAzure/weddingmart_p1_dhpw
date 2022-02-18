package com.revature.weddingmart.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.models.Wedding;
import com.revature.weddingmart.services.WeddingService;

public class WeddingServlet extends HttpServlet {
	private final WeddingService weddingService;
	private final ObjectMapper mapper;

	public WeddingServlet(WeddingService weddingService, ObjectMapper mapper) {
		this.weddingService = weddingService;
		this.mapper = mapper;
	}

	// GET /wedding/id (get wedding by id)
	// GET /wedding/ (get all weddings)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /wedding, return all weddings
		if (path == null || path.length() < 2) {
			List<Wedding> weddings = weddingService.getAllWeddings();
			String payload = mapper.writeValueAsString(weddings);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /wedding/N, return wedding by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Wedding wedding = weddingService.getWeddingById(id);
			String payload = mapper.writeValueAsString(wedding);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /wedding (create wedding specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Wedding newWedding = mapper.readValue(req.getInputStream(), Wedding.class);
		
		newWedding = weddingService.addWedding(newWedding);
		if (newWedding == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newWedding);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /wedding (update wedding specified by put body. 404 on wedding does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Wedding newWedding = mapper.readValue(req.getInputStream(), Wedding.class);

		try {
			weddingService.updateWedding(newWedding);
			String payload = mapper.writeValueAsString(newWedding);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
		catch (Exception e) {
			resp.setStatus(500);
		}
	}

	// DELETE /wedding/id (delete wedding specified by id. 404 on wedding does not exist. 200
	// on delete. 500 on server error.)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		// if url is /wedding, return all weddings
		if (path == null || path.length() < 2) {
			resp.setStatus(404);
		}
		// if url is /wedding/N, return wedding by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Wedding wedding = weddingService.getWeddingById(id);
			weddingService.deleteWedding(wedding);
			resp.setStatus(200);
		}
	}
}
