package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingmart.models.MealOrder;
import com.revature.weddingmart.util.HibernateUtil;

public class MealOrderDAO {
	public MealOrder addMealOrder(MealOrder mealOrder) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(mealOrder);
			transaction.commit();
			return mealOrder;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
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
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateMealOrder(MealOrder mealOrder) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(mealOrder);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteMealOrder(MealOrder mealOrder) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(mealOrder);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

		
	}

