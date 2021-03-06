package com.revature.weddingmart.daos.users;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.query.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingmart.models.users.Employee;
import com.revature.weddingmart.util.HibernateUtil;

public class EmployeeDAO {
	public Employee addEmployee(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh( employee.getUser() );
			session.save(employee);
			transaction.commit();
			return employee;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Employee> getAllEmployees() {
		try {
			Session session = HibernateUtil.getSession();
			List<Employee> employees = session.createQuery("FROM Employee").list();
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Employee getEmployeeById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Employee employee = session.get(Employee.class, id);
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("").severe("Retrieval failed");
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateEmployee(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.refresh( employee.getUser() );
			session.merge(employee);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("Persistence failed");
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void deleteEmployee(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql = "DELETE FROM Employee " + "WHERE id = :employee_id";
			Query query = session.createQuery(hql);
			query.setParameter("employee_id", employee.getId());
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
