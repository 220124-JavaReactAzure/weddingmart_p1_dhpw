package com.revature.weddingmart.web.servlets.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.models.users.Betrothed;
import com.revature.weddingmart.services.users.BetrothedService;
import com.revature.weddingmart.services.users.UserService;

public class BetrothedServlet extends HttpServlet {
	private final BetrothedService betrothedService;
	private final ObjectMapper mapper;

	public BetrothedServlet(BetrothedService betrothedService, ObjectMapper mapper) {
		this.betrothedService = betrothedService;
		this.mapper = mapper;
	}

	// GET /betrothed/id (get betrothed by id)
	// GET /betrothed/ (get all betrotheds)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /betrothed, return all betrotheds
		if (path == null || path.length() < 2) {
			List<Betrothed> betrotheds = betrothedService.getAllBetrotheds();
			String payload = mapper.writeValueAsString(betrotheds);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /betrothed/N, return betrothed by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Betrothed betrothed = betrothedService.getBetrothedById(id);
			String payload = mapper.writeValueAsString(betrothed);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /betrothed (create betrothed specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Betrothed newBetrothed = mapper.readValue(req.getInputStream(), Betrothed.class);
		
		newBetrothed = betrothedService.addBetrothed(newBetrothed);
		if (newBetrothed == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newBetrothed);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /betrothed (update betrothed specified by put body. 404 on betrothed does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Betrothed newBetrothed = mapper.readValue(req.getInputStream(), Betrothed.class);

		try {
			betrothedService.updateBetrothed(newBetrothed);
			String payload = mapper.writeValueAsString(newBetrothed);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
		catch (Exception e) {
			resp.setStatus(500);
		}
	}

	// DELETE /betrothed/id (delete betrothed specified by id. 404 on betrothed does not exist. 200
	// on delete. 500 on server error.)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		// if url is /betrothed, return all betrotheds
		if (path == null || path.length() < 2) {
			resp.setStatus(404);
		}
		// if url is /betrothed/N, return betrothed by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Betrothed betrothed = betrothedService.getBetrothedById(id);
			betrothedService.deleteBetrothed(betrothed);
			resp.setStatus(200);
		}
	}
}
