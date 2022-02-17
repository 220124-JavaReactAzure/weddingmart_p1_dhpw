package com.revature.weddingmart.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.services.users.UserService;
import com.revature.weddingmart.web.servlets.users.UserServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	private final Logger logger = LogManager.getRootLogger();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("contextInitialized");
		
		ObjectMapper mapper = new ObjectMapper();
		
		//init DAO
		UserDAO userDAO = new UserDAO();
		//init Service
		UserService userService = new UserService(userDAO);
		//init Servlet
		UserServlet userServlet = new UserServlet(userService, mapper);
		
		//add servlets
		ServletContext context = sce.getServletContext();
		context.addServlet("UserServlet", userServlet).addMapping("/user/*");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		logger.info("contextDestroyed");
	}
}
