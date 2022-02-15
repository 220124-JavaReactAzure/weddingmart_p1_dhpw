package com.revature.weddingmart.daos;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.weddingmart.models.Asset;
import com.revature.weddingmart.util.HibernateUtil;

public class AssetDAO {
	public boolean addAsset(Asset asset) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(asset);
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
