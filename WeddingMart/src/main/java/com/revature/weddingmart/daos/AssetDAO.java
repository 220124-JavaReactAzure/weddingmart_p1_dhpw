package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.weddingmart.models.Asset;
import com.revature.weddingmart.util.HibernateUtil;

public class AssetDAO {
	public Asset addAsset(Asset asset) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh(asset.getType());
			session.save(asset);
			transaction.commit();
			return asset;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Asset> getAllAssets() {
		try {
			Session session = HibernateUtil.getSession();
			List<Asset> assets = session.createQuery("FROM Asset").list();
			return assets;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Asset getAssetById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Asset asset = session.get(Asset.class, id);
			return asset;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateAsset(Asset asset) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh(asset.getType());
			session.merge(asset);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteAsset(Asset asset) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql = "DELETE FROM Asset " + "WHERE id = :asset_id";
			Query query = session.createQuery(hql);
			query.setParameter("asset_id", asset.getId());
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
