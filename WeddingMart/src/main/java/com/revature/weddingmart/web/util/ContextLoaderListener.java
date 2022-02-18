package com.revature.weddingmart.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.daos.users.AttendeeDAO;
import com.revature.weddingmart.daos.users.EmployeeDAO;
import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.services.users.AttendeeService;
import com.revature.weddingmart.services.users.EmployeeService;
import com.revature.weddingmart.services.users.UserService;
import com.revature.weddingmart.web.servlets.users.AttendeeServlet;
import com.revature.weddingmart.web.servlets.users.EmployeeServlet;
import com.revature.weddingmart.web.servlets.users.UserServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	private final Logger logger = LogManager.getRootLogger();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("contextInitialized");
		
		ObjectMapper mapper = new ObjectMapper();
		
		UserDAO userDAO = new UserDAO();
		UserService userService = new UserService(userDAO);
		UserServlet userServlet = new UserServlet(userService, mapper);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeService employeeService = new EmployeeService(employeeDAO);
		EmployeeServlet employeeServlet = new EmployeeServlet(employeeService, userService, mapper);
		
		AttendeeDAO attendeeDAO = new AttendeeDAO();
		AttendeeService attendeeService = new AttendeeService(attendeeDAO);
		AttendeeServlet attendeeServlet = new AttendeeServlet(attendeeService, userService, mapper);
		
		//add servlets
		ServletContext context = sce.getServletContext();
		context.addServlet("UserServlet", userServlet).addMapping("/user/*");
		context.addServlet("EmployeeServlet", employeeServlet).addMapping("/employee/*");
		context.addServlet("AttendeeServlet", attendeeServlet).addMapping("/attendee/*");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		logger.info("contextDestroyed");
	}
}
