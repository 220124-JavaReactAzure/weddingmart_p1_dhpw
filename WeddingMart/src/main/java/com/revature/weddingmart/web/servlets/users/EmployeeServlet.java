package com.revature.weddingmart.web.servlets.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.models.users.Employee;
import com.revature.weddingmart.services.users.EmployeeService;
import com.revature.weddingmart.services.users.UserService;

public class EmployeeServlet extends HttpServlet {
	private final EmployeeService employeeService;
	private final ObjectMapper mapper;

	public EmployeeServlet(EmployeeService employeeService, ObjectMapper mapper) {
		this.employeeService = employeeService;
		this.mapper = mapper;
	}

	// GET /employee/id (get employee by id)
	// GET /employee/ (get all employees)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();

		// if url is /employee, return all employees
		if (path == null || path.length() < 2) {
			List<Employee> employees = employeeService.getAllEmployees();
			String payload = mapper.writeValueAsString(employees);
			writer.write(payload);
			resp.setStatus(200);
		}
		// if url is /employee/N, return employee by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Employee employee = employeeService.getEmployeeById(id);
			String payload = mapper.writeValueAsString(employee);
			writer.write(payload);
			resp.setStatus(200);
		}
	}

	// POST /employee (create employee specified by post body. 400 on invalid data. 500 on
	// server error.)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Employee newEmployee = mapper.readValue(req.getInputStream(), Employee.class);
		
		newEmployee = employeeService.addEmployee(newEmployee);
		if (newEmployee == null) {
			resp.setStatus(500);
		}
		else {
			String payload = mapper.writeValueAsString(newEmployee);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
	}

	// PUT /employee (update employee specified by put body. 404 on employee does not exist. 400
	// on invalid data. 500 on server error.)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Employee newEmployee = mapper.readValue(req.getInputStream(), Employee.class);

		try {
			employeeService.updateEmployee(newEmployee);
			String payload = mapper.writeValueAsString(newEmployee);
			resp.getWriter().write(payload);
			resp.setStatus(200);
		}
		catch (Exception e) {
			resp.setStatus(500);
		}
	}

	// DELETE /employee/id (delete employee specified by id. 404 on employee does not exist. 200
	// on delete. 500 on server error.)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		// if url is /employee, return all employees
		if (path == null || path.length() < 2) {
			resp.setStatus(404);
		}
		// if url is /employee/N, return employee by id N
		else {
			int id = Integer.parseInt(path.split("/")[1]);
			Employee employee = employeeService.getEmployeeById(id);
			employeeService.deleteEmployee(employee);
			resp.setStatus(200);
		}
	}
}
