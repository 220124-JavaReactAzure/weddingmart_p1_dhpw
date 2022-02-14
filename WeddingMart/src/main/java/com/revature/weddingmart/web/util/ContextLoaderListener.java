package com.revature.weddingmart.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//init DAOs
		//init Services
		//init Servlets
		//add servlets
		ServletContext context = sce.getServletContext();
		//context.addServlet("ServetletName", initedServletFromAbove).addMapping("/url/*");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
	}
}
