package com.revature.weddingmart.services.users;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.users.EmployeeDAO;
import com.revature.weddingmart.models.users.Employee;

public class EmployeeService {
	private final EmployeeDAO employeeDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public EmployeeService(EmployeeDAO employeeDAO) {
		logger.debug("Created EmployeeService");
		this.employeeDAO = employeeDAO;
	}
	
	public Employee addEmployee(Employee employee) {
		logger.debug("called EmployeeService.addEmployee with " + employee);
		return employeeDAO.addEmployee(employee);
	}

	public List<Employee> getAllEmployees() {
		logger.debug("called EmployeeService.getAllEmployees");
		return employeeDAO.getAllEmployees();
	}

	public Employee getEmployeeById(int id) {
		logger.debug("called EmployeeService.getEmployeeById" + id);
		return employeeDAO.getEmployeeById(id);
	}

	public void updateEmployee(Employee employee) {
		logger.debug("called EmployeeService.updateEmployee");
		employeeDAO.updateEmployee(employee);
	}

	public void deleteEmployee(Employee employee) {
		logger.debug("called EmployeeService.deleteEmployee");
		employeeDAO.deleteEmployee(employee);
	}
}
