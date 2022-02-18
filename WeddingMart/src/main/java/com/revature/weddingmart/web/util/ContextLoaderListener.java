package com.revature.weddingmart.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.daos.AssetBookingDAO;
import com.revature.weddingmart.daos.AssetDAO;
import com.revature.weddingmart.daos.AssetTypeDAO;
import com.revature.weddingmart.daos.WeddingDAO;
import com.revature.weddingmart.daos.users.AttendeeDAO;
import com.revature.weddingmart.daos.users.BetrothedDAO;
import com.revature.weddingmart.daos.users.EmployeeDAO;
import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.services.AssetBookingService;
import com.revature.weddingmart.services.AssetService;
import com.revature.weddingmart.services.AssetTypeService;
import com.revature.weddingmart.services.WeddingService;
import com.revature.weddingmart.services.users.AttendeeService;
import com.revature.weddingmart.services.users.BetrothedService;
import com.revature.weddingmart.services.users.EmployeeService;
import com.revature.weddingmart.services.users.UserService;
import com.revature.weddingmart.web.servlets.AssetBookingServlet;
import com.revature.weddingmart.web.servlets.AssetServlet;
import com.revature.weddingmart.web.servlets.AssetTypeServlet;
import com.revature.weddingmart.web.servlets.WeddingServlet;
import com.revature.weddingmart.web.servlets.users.AttendeeServlet;
import com.revature.weddingmart.web.servlets.users.BetrothedServlet;
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
		EmployeeServlet employeeServlet = new EmployeeServlet(employeeService, mapper);
		
		AttendeeDAO attendeeDAO = new AttendeeDAO();
		AttendeeService attendeeService = new AttendeeService(attendeeDAO);
		AttendeeServlet attendeeServlet = new AttendeeServlet(attendeeService, mapper);
		
		BetrothedDAO betrothedDAO = new BetrothedDAO();
		BetrothedService betrothedService = new BetrothedService(betrothedDAO);
		BetrothedServlet betrothedServlet = new BetrothedServlet(betrothedService, mapper);
		
		WeddingDAO weddingDAO = new WeddingDAO();
		WeddingService weddingService = new WeddingService(weddingDAO);
		WeddingServlet weddingServlet = new WeddingServlet(weddingService, mapper);
		
		AssetDAO assetDAO = new AssetDAO();
		AssetService assetService = new AssetService(assetDAO);
		AssetServlet assetServlet = new AssetServlet(assetService, mapper);
		
		AssetTypeDAO assetTypeDAO = new AssetTypeDAO();
		AssetTypeService assetTypeService = new AssetTypeService(assetTypeDAO);
		AssetTypeServlet assetTypeServlet = new AssetTypeServlet(assetTypeService, mapper);
		
		AssetBookingDAO assetBookingDAO = new AssetBookingDAO();
		AssetBookingService assetBookingService = new AssetBookingService(assetBookingDAO);
		AssetBookingServlet assetBookingServlet = new AssetBookingServlet(assetBookingService, mapper);
		
		//add servlets
		ServletContext context = sce.getServletContext();
		context.addServlet("UserServlet", userServlet).addMapping("/user/*");
		context.addServlet("EmployeeServlet", employeeServlet).addMapping("/employee/*");
		context.addServlet("AttendeeServlet", attendeeServlet).addMapping("/attendee/*");
		context.addServlet("BetrothedServlet", betrothedServlet).addMapping("/betrothed/*");
		context.addServlet("WeddingServlet", weddingServlet).addMapping("/wedding/*");
		context.addServlet("AssetServlet", assetServlet).addMapping("/asset/*");
		context.addServlet("AssetTypeServlet", assetTypeServlet).addMapping("/assetType/*");
		context.addServlet("AssetBookingServlet", assetBookingServlet).addMapping("/assetBooking/*");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		logger.info("contextDestroyed");
	}
}
