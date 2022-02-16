package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingmart.models.MealOrderPlusOne;
import com.revature.weddingmart.util.HibernateUtil;

public class MealOrderPlusOneDAO {
	public boolean addMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(mealOrderPlusOne);
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<MealOrderPlusOne> getAllMealOrderPlusOnes() {
		try {
			Session session = HibernateUtil.getSession();
			List<MealOrderPlusOne> mealOrderPlusOnes = session.createQuery("FROM MealOrderPlusOne").list();
			return mealOrderPlusOnes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public MealOrderPlusOne getMealOrderPlusOneById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			MealOrderPlusOne mealOrderPlusOne = session.get(MealOrderPlusOne.class, id);
			return mealOrderPlusOne;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(mealOrderPlusOne);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(mealOrderPlusOne);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
