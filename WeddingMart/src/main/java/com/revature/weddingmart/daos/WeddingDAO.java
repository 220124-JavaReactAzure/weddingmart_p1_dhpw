package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.weddingmart.models.Wedding;
import com.revature.weddingmart.util.HibernateUtil;

public class WeddingDAO {
	public Wedding addWedding(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(wedding);
			transaction.commit();
			return wedding;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Wedding> getAllWeddings() {
		try {
			Session session = HibernateUtil.getSession();
			List<Wedding> weddings = session.createQuery("FROM Wedding").list();
			return weddings;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Wedding getWeddingById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Wedding wedding = session.get(Wedding.class, id);
			return wedding;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateWedding(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(wedding);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteWedding(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql = "DELETE FROM Wedding " + "WHERE id = :wedding_id";
			Query query = session.createQuery(hql);
			query.setParameter("wedding_id", wedding.getId());
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
