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
import com.revature.weddingmart.services.AssetTypeService;

public class AssetTypeServlet extends HttpServlet {
	private final AssetTypeService assetTypeService;
	private final ObjectMapper mapper;

	public AssetTypeServlet(AssetTypeService assetTypeService, ObjectMapper mapper) {
		this.assetTypeService = assetTypeService;
		this.mapper = mapper;
	}

	// GET /assetType/id (get assetType by id)
	// GET /assetType/ (get all assetTypes)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		List<AssetType> assetTypes = assetTypeService.getAllAssetTypes();
		String payload = mapper.writeValueAsString(assetTypes);
		writer.write(payload);
		resp.setStatus(200);
	}
}