package com.revature.weddingmart.web.servlets.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.models.users.Attendee;
import com.revature.weddingmart.services.users.AttendeeService;
import com.revature.weddingmart.services.users.UserService;

public class AttendeeServlet extends HttpServlet {
	private final AttendeeService attendeeService;
	private final ObjectMapper mapper;

	public AttendeeServlet(AttendeeService attendeeService, ObjectMapper mapper) {
		this.attendeeService = attendeeService;
		this.mapper = mapper;
	}

	// GET /attendee/id (get attendee by id)
	// GET /attendee/ (get all attendees)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /attendee, return all attendees
		if (path == null || path.length() < 2) {
			List<Attendee> attendees = attendeeService.getAllAttendees();
			String payload = mapper.writeValueAsString(attendees);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /attendee/N, return attendee by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Attendee attendee = attendeeService.getAttendeeById(id);
			String payload = mapper.writeValueAsString(attendee);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /attendee (create attendee specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Attendee newAttendee = mapper.readValue(req.getInputStream(), Attendee.class);
		
		newAttendee = attendeeService.addAttendee(newAttendee);
		if (newAttendee == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newAttendee);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /attendee (update attendee specified by put body. 404 on attendee does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Attendee newAttendee = mapper.readValue(req.getInputStream(), Attendee.class);

		try {
			attendeeService.updateAttendee(newAttendee);
			String payload = mapper.writeValueAsString(newAttendee);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
		catch (Exception e) {
			resp.setStatus(500);
		}
	}

	// DELETE /attendee/id (delete attendee specified by id. 404 on attendee does not exist. 200
	// on delete. 500 on server error.)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		// if url is /attendee, return all attendees
		if (path == null || path.length() < 2) {
			resp.setStatus(404);
		}
		// if url is /attendee/N, return attendee by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Attendee attendee = attendeeService.getAttendeeById(id);
			attendeeService.deleteAttendee(attendee);
			resp.setStatus(200);
		}
	}
}
