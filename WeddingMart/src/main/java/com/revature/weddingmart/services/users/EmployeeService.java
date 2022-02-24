package com.revature.weddingmart.services.users;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.users.EmployeeDAO;
import com.revature.weddingmart.models.users.Employee;

public class EmployeeService {
	private final EmployeeDAO employeeDAO;
	private Logger logger;
	
	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created EmployeeService");
	}
	
	public Employee addEmployee(Employee employee) {
		logger.info("called EmployeeService.addEmployee with " + employee);
		return employeeDAO.addEmployee(employee);
	}

	public List<Employee> getAllEmployees() {
		logger.info("called EmployeeService.getAllEmployees");
		return employeeDAO.getAllEmployees();
	}

	public Employee getEmployeeById(int id) {
		logger.info("called EmployeeService.getEmployeeById with id " + id);
		return employeeDAO.getEmployeeById(id);
	}

	public void updateEmployee(Employee employee) {
		logger.info("called EmployeeService.updateEmployee with data " + employee);
		employeeDAO.updateEmployee(employee);
	}

	public void deleteEmployee(Employee employee) {
		logger.info("called EmployeeService.deleteEmployee");
		employeeDAO.deleteEmployee(employee);
	}
}
