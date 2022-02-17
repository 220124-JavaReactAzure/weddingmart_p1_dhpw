package com.revature.weddingmart.services.users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.users.EmployeeDAO;
import com.revature.weddingmart.models.users.Employee;

public class EmployeeServiceTestSuite {
	EmployeeService sut;
	EmployeeDAO mockEmployeeDAO;
	
	@Before
	public void testPrep() {
		mockEmployeeDAO = mock(EmployeeDAO.class);
		sut = new EmployeeService(mockEmployeeDAO);
	}
	
	@Test
	public void test_addEmployee() {
		Employee employee = new Employee();
		employee.setManager(true);
		when(mockEmployeeDAO.addEmployee(employee)).thenReturn(employee);
		employee = sut.addEmployee(employee);
		assertNotNull(employee);
	}
	
	@Test
	public void test_getAllEmployees() {
		Employee u1 = new Employee();
		Employee u2 = new Employee();
		Employee u3 = new Employee();
		ArrayList<Employee> employees;
		employees = new ArrayList<>();
		employees.add(u1);
		employees.add(u2);
		employees.add(u3);
		
		when(mockEmployeeDAO.getAllEmployees()).thenReturn(employees);
		
		employees = (ArrayList<Employee>)sut.getAllEmployees();
		
		assertNotNull (employees);
		assertFalse( employees.isEmpty() );
	}
	
	@Test
	public void test_getEmployeeById() {
		Employee employee = new Employee();
		employee.setManager(true);
		when(mockEmployeeDAO.getEmployeeById(1)).thenReturn(employee);
		employee = sut.getEmployeeById(1);
		assertNotNull(employee);
		employee = sut.getEmployeeById(0);
		assertNull(employee);
	}
	
	@Test
	public void test_updateEmployee() {
		Employee employee = new Employee();
		employee.setManager(true);
		sut.updateEmployee(employee);
		assertNotNull(employee);
	}
	
	@Test
	public void test_deleteEmployee() {
		Employee employee = new Employee();
		employee.setManager(true);
		sut.deleteEmployee(employee);
		assertNotNull(employee);
	}
}

