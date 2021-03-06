package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.weddingmart.models.MealOrder;
import com.revature.weddingmart.util.HibernateUtil;

public class MealOrderDAO {
	public MealOrder addMealOrder(MealOrder mealOrder) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh(mealOrder.getAttendee());
			session.refresh(mealOrder.getMealChoice());
			session.save(mealOrder);
			transaction.commit();
			return mealOrder;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<MealOrder> getAllMealOrders() {
		try {
			Session session = HibernateUtil.getSession();
			List<MealOrder> mealOrders = session.createQuery("FROM MealOrder").list();
			return mealOrders;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public MealOrder getMealOrderById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			MealOrder mealOrder = session.get(MealOrder.class, id);
			return mealOrder;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateMealOrder(MealOrder mealOrder) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh(mealOrder.getAttendee());
			session.refresh(mealOrder.getMealChoice());
			session.merge(mealOrder);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteMealOrder(MealOrder mealOrder) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql = "DELETE FROM MealOrder " + "WHERE id = :meal_id";
			Query query = session.createQuery(hql);
			query.setParameter("meal_id", mealOrder.getId());
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

