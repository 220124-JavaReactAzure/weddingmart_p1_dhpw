package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.weddingmart.models.MealOrderPlusOne;
import com.revature.weddingmart.util.HibernateUtil;

public class MealOrderPlusOneDAO {
	public MealOrderPlusOne addMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh(mealOrderPlusOne.getAttendee());
			session.refresh(mealOrderPlusOne.getMealChoice());
			session.save(mealOrderPlusOne);
			transaction.commit();
			return mealOrderPlusOne;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
			return null;
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
			Logger.getLogger("").severe("Retrieval failed");
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
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh(mealOrderPlusOne.getAttendee());
			session.refresh(mealOrderPlusOne.getMealChoice());
			session.merge(mealOrderPlusOne);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteMealOrderPlusOne(MealOrderPlusOne mealOrderPlusOne) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql = "DELETE FROM MealOrderPlusOne " + "WHERE id = :meal_id";
			Query query = session.createQuery(hql);
			query.setParameter("meal_id", mealOrderPlusOne.getId());
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
