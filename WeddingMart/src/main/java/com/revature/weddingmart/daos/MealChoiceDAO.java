package com.revature.weddingmart.daos;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingmart.models.MealChoice;
import com.revature.weddingmart.util.HibernateUtil;

public class MealChoiceDAO {
	public MealChoice addMealChoice(MealChoice mealChoice) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(mealChoice);
			transaction.commit();
			return mealChoice;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<MealChoice> getAllMealChoices() {
		try {
			Session session = HibernateUtil.getSession();
			List<MealChoice> mealChoices = session.createQuery("FROM MealChoice").list();
			return mealChoices;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public MealChoice getMealChoiceById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			MealChoice mealChoice = session.get(MealChoice.class, id);
			return mealChoice;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateMealChoice(MealChoice mealChoice) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(mealChoice);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteMealChoice(MealChoice mealChoice) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(mealChoice);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
