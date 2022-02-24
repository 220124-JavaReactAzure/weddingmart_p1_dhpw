package com.revature.weddingmart.services.users;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.users.AttendeeDAO;
import com.revature.weddingmart.models.users.Attendee;

public class AttendeeService {
	private final AttendeeDAO attendeeDAO;
	private Logger logger;
	
	public AttendeeService(AttendeeDAO attendeeDAO) {
		this.attendeeDAO = attendeeDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created AttendeeService");
	}
	
	public Attendee addAttendee(Attendee attendee) {
		logger.info("called AttendeeService.addAttendee with " + attendee);
		return attendeeDAO.addAttendee(attendee);
	}

	public List<Attendee> getAllAttendees() {
		logger.info("called AttendeeService.getAllAttendees");
		return attendeeDAO.getAllAttendees();
	}

	public Attendee getAttendeeById(int id) {
		logger.info("called AttendeeService.getAttendeeById with id " + id);
		return attendeeDAO.getAttendeeById(id);
	}

	public void updateAttendee(Attendee attendee) {
		logger.info("called AttendeeService.updateAttendee with data " + attendee);
		attendeeDAO.updateAttendee(attendee);
	}

	public void deleteAttendee(Attendee attendee) {
		logger.info("called AttendeeService.deleteAttendee");
		attendeeDAO.deleteAttendee(attendee);
	}
}
