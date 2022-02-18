package com.revature.weddingmart.services.users;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.users.AttendeeDAO;
import com.revature.weddingmart.models.users.Attendee;

public class AttendeeService {
	private final AttendeeDAO attendeeDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public AttendeeService(AttendeeDAO attendeeDAO) {
		logger.debug("Created AttendeeService");
		this.attendeeDAO = attendeeDAO;
	}
	
	public Attendee addAttendee(Attendee attendee) {
		logger.debug("called AttendeeService.addAttendee with " + attendee);
		return attendeeDAO.addAttendee(attendee);
	}

	public List<Attendee> getAllAttendees() {
		logger.debug("called AttendeeService.getAllAttendees");
		return attendeeDAO.getAllAttendees();
	}

	public Attendee getAttendeeById(int id) {
		logger.debug("called AttendeeService.getAttendeeById" + id);
		return attendeeDAO.getAttendeeById(id);
	}

	public void updateAttendee(Attendee attendee) {
		logger.debug("called AttendeeService.updateAttendee");
		attendeeDAO.updateAttendee(attendee);
	}

	public void deleteAttendee(Attendee attendee) {
		logger.debug("called AttendeeService.deleteAttendee");
		attendeeDAO.deleteAttendee(attendee);
	}
}
