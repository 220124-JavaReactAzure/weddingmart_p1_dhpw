package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingmart.models.AssetBooking;
import com.revature.weddingmart.util.HibernateUtil;

public class AssetBookingDAO {
	public AssetBooking addAssetBooking(AssetBooking assetBooking) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(assetBooking);
			return assetBooking;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<AssetBooking> getAllAssetBookings() {
		try {
			Session session = HibernateUtil.getSession();
			List<AssetBooking> assetBookings = session.createQuery("FROM AssetBooking").list();
			return assetBookings;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public AssetBooking getAssetBookingById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			AssetBooking assetBooking = session.get(AssetBooking.class, id);
			return assetBooking;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateAssetBooking(AssetBooking assetBooking) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(assetBooking);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteAssetBooking(AssetBooking assetBooking) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(assetBooking);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
