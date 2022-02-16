package com.revature.weddingmart.daos.users;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingmart.models.users.User;
import com.revature.weddingmart.util.HibernateUtil;

public class UserDAO {
	public User addUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(user);
			return user;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<User> getAllUsers() {
		try {
			Session session = HibernateUtil.getSession();
			List<User> users = session.createQuery("FROM User").list();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public User getUserById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			User user = session.get(User.class, id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(user);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
