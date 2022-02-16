package com.revature.weddingmart.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ContextLoaderListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ObjectMapper mapper = new ObjectMapper();
		
		//init DAO
		//init Service
		//init Servle
		
		//add servlets
		ServletContext context = sce.getServletContext();
		//context.addServlet("ServetletName", initedServletFromAbove).addMapping("/url/*");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
	}
}
