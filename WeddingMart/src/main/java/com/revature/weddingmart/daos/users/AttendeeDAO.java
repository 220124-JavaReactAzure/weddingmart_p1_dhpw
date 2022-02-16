package com.revature.weddingmart.daos.users;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingmart.models.users.Attendee;
import com.revature.weddingmart.util.HibernateUtil;

public class AttendeeDAO {
	public Attendee addAttendee(Attendee attendee) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(attendee);
			return attendee;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Attendee> getAllAttendees() {
		try {
			Session session = HibernateUtil.getSession();
			List<Attendee> attendees = session.createQuery("FROM Attendee").list();
			return attendees;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Attendee getAttendeeById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Attendee attendee = session.get(Attendee.class, id);
			return attendee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateAttendee(Attendee attendee) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(attendee);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteAttendee(Attendee attendee) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(attendee);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
