package com.revature.weddingmart.services.users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.users.AttendeeDAO;
import com.revature.weddingmart.models.users.Attendee;

public class AttendeeServiceTestSuite {
	AttendeeService sut;
	AttendeeDAO mockAttendeeDAO;
	
	@Before
	public void testPrep() {
		mockAttendeeDAO = mock(AttendeeDAO.class);
		sut = new AttendeeService(mockAttendeeDAO);
	}
	
	@Test
	public void test_addAttendee() {
		Attendee attendee = new Attendee();
		attendee.setRsvp(true);
		when(mockAttendeeDAO.addAttendee(attendee)).thenReturn(attendee);
		attendee = sut.addAttendee(attendee);
		assertNotNull(attendee);
	}
	
	@Test
	public void test_getAllAttendees() {
		Attendee u1 = new Attendee();
		Attendee u2 = new Attendee();
		Attendee u3 = new Attendee();
		ArrayList<Attendee> attendees;
		attendees = new ArrayList<>();
		attendees.add(u1);
		attendees.add(u2);
		attendees.add(u3);
		
		when(mockAttendeeDAO.getAllAttendees()).thenReturn(attendees);
		
		attendees = (ArrayList<Attendee>)sut.getAllAttendees();
		
		assertNotNull (attendees);
		assertFalse( attendees.isEmpty() );
	}
	
	@Test
	public void test_getAttendeeById() {
		Attendee attendee = new Attendee();
		attendee.setRsvp(true);
		when(mockAttendeeDAO.getAttendeeById(1)).thenReturn(attendee);
		attendee = sut.getAttendeeById(1);
		assertNotNull(attendee);
		attendee = sut.getAttendeeById(0);
		assertNull(attendee);
	}
	
	@Test
	public void test_updateAttendee() {
		Attendee attendee = new Attendee();
		attendee.setRsvp(true);
		sut.updateAttendee(attendee);
		assertNotNull(attendee);
	}
	
	@Test
	public void test_deleteAttendee() {
		Attendee attendee = new Attendee();
		attendee.setRsvp(true);
		sut.deleteAttendee(attendee);
		assertNotNull(attendee);
	}
}

