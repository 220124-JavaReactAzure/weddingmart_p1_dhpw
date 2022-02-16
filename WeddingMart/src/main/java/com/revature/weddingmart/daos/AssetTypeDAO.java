package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.weddingmart.models.AssetType;
import com.revature.weddingmart.util.HibernateUtil;

public class AssetTypeDAO {
	public AssetType addAssetType(AssetType assetType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(assetType);
			transaction.commit();
			return assetType;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public List<AssetType> getAllAssetTypes() {
		try {
			Session session = HibernateUtil.getSession();
			List<AssetType> asset_types = session.createQuery("FROM AssetType").list();
			return asset_types;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public AssetType getById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			AssetType assetType = session.get(AssetType.class, id);
			return assetType;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public AssetType getByDescription(String description) {
		try {
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("FROM AssetType A where A.description = :description");
			query.setParameter("description", description);
			List<AssetType> asset_types = query.list();
			return asset_types.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public void updateAssetType(AssetType assetType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(assetType);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteAssetType(AssetType assetType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(assetType);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
