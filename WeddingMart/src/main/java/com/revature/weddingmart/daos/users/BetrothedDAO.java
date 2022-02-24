package com.revature.weddingmart.daos.users;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.query.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingmart.models.users.Betrothed;
import com.revature.weddingmart.util.HibernateUtil;

public class BetrothedDAO {
	public Betrothed addBetrothed(Betrothed betrothed) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh( betrothed.getUser() );
			session.refresh( betrothed.getWedding() );
			session.save(betrothed);
			transaction.commit();
			return betrothed;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Betrothed> getAllBetrotheds() {
		try {
			Session session = HibernateUtil.getSession();
			List<Betrothed> betrotheds = session.createQuery("FROM Betrothed").list();
			return betrotheds;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Betrothed getBetrothedById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Betrothed betrothed = session.get(Betrothed.class, id);
			return betrothed;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateBetrothed(Betrothed betrothed) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh( betrothed.getUser() );
			session.refresh( betrothed.getWedding() );
			session.merge(betrothed);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteBetrothed(Betrothed betrothed) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql = "DELETE FROM Betrothed " + "WHERE id = :betrothed_id";
			Query query = session.createQuery(hql);
			query.setParameter("betrothed_id", betrothed.getId());
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
