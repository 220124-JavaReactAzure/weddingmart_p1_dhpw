package com.revature.weddingmart.web.servlets.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.models.users.User;
import com.revature.weddingmart.services.users.UserService;

public class UserServlet extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;

	public UserServlet(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}

	// GET /user/id (get user by id)
	// GET /user/ (get all users)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /user, return all users
		if (path == null || path.length() < 2) {
			List<User> users = userService.getAllUsers();
			String payload = mapper.writeValueAsString(users);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /user/N, return user by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			User user = userService.getUserById(id);
			String payload = mapper.writeValueAsString(user);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /user (create user specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		User newUser = mapper.readValue(req.getInputStream(), User.class);
		newUser = userService.addUser(newUser);
		if (newUser == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newUser);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /user (update user specified by put body. 404 on user does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		User newUser = mapper.readValue(req.getInputStream(), User.class);
		try {
			userService.updateUser(newUser);
			String payload = mapper.writeValueAsString(newUser);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
		catch (Exception e) {
			resp.setStatus(500);
		}
	}

	// DELETE /user/id (delete user specified by id. 404 on user does not exist. 200
	// on delete. 500 on server error.)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		// if url is /user, return all users
		if (path == null || path.length() < 2) {
			resp.setStatus(404);
		}
		// if url is /user/N, return user by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			User user = userService.getUserById(id);
			userService.deleteUser(user);
			resp.setStatus(200);
		}
	}
}
