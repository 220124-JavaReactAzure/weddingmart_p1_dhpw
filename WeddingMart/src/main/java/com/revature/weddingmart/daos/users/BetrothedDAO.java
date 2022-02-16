package com.revature.weddingmart.daos.users;

import java.io.IOException;
import java.util.List;

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
			session.save(betrothed);
			transaction.commit();
			return betrothed;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
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
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateBetrothed(Betrothed betrothed) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(betrothed);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteBetrothed(Betrothed betrothed) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(betrothed);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}

