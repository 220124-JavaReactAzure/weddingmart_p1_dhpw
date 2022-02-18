package com.revature.weddingmart.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.models.Asset;
import com.revature.weddingmart.services.AssetService;

public class AssetServlet extends HttpServlet {
	private final AssetService assetService;
	private final ObjectMapper mapper;

	public AssetServlet(AssetService assetService, ObjectMapper mapper) {
		this.assetService = assetService;
		this.mapper = mapper;
	}

	// GET /asset/id (get asset by id)
	// GET /asset/ (get all assets)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /asset, return all assets
		if (path == null || path.length() < 2) {
			List<Asset> assets = assetService.getAllAssets();
			String payload = mapper.writeValueAsString(assets);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /asset/N, return asset by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Asset asset = assetService.getAssetById(id);
			String payload = mapper.writeValueAsString(asset);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /asset (create asset specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Asset newAsset = mapper.readValue(req.getInputStream(), Asset.class);
		
		newAsset = assetService.addAsset(newAsset);
		if (newAsset == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newAsset);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /asset (update asset specified by put body. 404 on asset does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Asset newAsset = mapper.readValue(req.getInputStream(), Asset.class);

		try {
			assetService.updateAsset(newAsset);
			String payload = mapper.writeValueAsString(newAsset);
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
			Asset asset = assetService.getAssetById(id);
			assetService.deleteAsset(asset);
			resp.setStatus(200);
		}
	}
}
