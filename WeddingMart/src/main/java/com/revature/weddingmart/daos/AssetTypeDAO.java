package com.revature.weddingmart.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.weddingmart.models.AssetType;
import com.revature.weddingmart.util.HibernateUtil;

public class AssetTypeDAO {
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
}
