package com.revature.weddingmart.web.util;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingmart.daos.AssetBookingDAO;
import com.revature.weddingmart.daos.AssetDAO;
import com.revature.weddingmart.daos.AssetTypeDAO;
import com.revature.weddingmart.daos.MealChoiceDAO;
import com.revature.weddingmart.daos.MealOrderDAO;
import com.revature.weddingmart.daos.MealOrderPlusOneDAO;
import com.revature.weddingmart.daos.WeddingDAO;
import com.revature.weddingmart.daos.users.AttendeeDAO;
import com.revature.weddingmart.daos.users.BetrothedDAO;
import com.revature.weddingmart.daos.users.EmployeeDAO;
import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.services.AssetBookingService;
import com.revature.weddingmart.services.AssetService;
import com.revature.weddingmart.services.AssetTypeService;
import com.revature.weddingmart.services.MealChoiceService;
import com.revature.weddingmart.services.MealOrderPlusOneService;
import com.revature.weddingmart.services.MealOrderService;
import com.revature.weddingmart.services.WeddingService;
import com.revature.weddingmart.services.users.AttendeeService;
import com.revature.weddingmart.services.users.BetrothedService;
import com.revature.weddingmart.services.users.EmployeeService;
import com.revature.weddingmart.services.users.UserService;
import com.revature.weddingmart.web.servlets.AssetBookingServlet;
import com.revature.weddingmart.web.servlets.AssetServlet;
import com.revature.weddingmart.web.servlets.AssetTypeServlet;
import com.revature.weddingmart.web.servlets.MealChoiceServlet;
import com.revature.weddingmart.web.servlets.MealOrderPlusOneServlet;
import com.revature.weddingmart.web.servlets.MealOrderServlet;
import com.revature.weddingmart.web.servlets.WeddingServlet;
import com.revature.weddingmart.web.servlets.users.AttendeeServlet;
import com.revature.weddingmart.web.servlets.users.BetrothedServlet;
import com.revature.weddingmart.web.servlets.users.EmployeeServlet;
import com.revature.weddingmart.web.servlets.users.UserServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	private Logger logger;
	private Handler fh;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			fh = new FileHandler("log.txt", true);
			Logger.getLogger("").addHandler(fh);
		    Logger.getLogger("").setLevel(Level.CONFIG);
		    this.logger = Logger.getLogger("");
		    logger.info("Initialized logging in ContextLoaderListener");			
		}
		catch (Exception e) {
			
		}
		
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
		
		MealChoiceDAO mealChoiceDAO = new MealChoiceDAO();
		MealChoiceService mealChoiceService = new MealChoiceService(mealChoiceDAO);
		MealChoiceServlet mealChoiceServlet = new MealChoiceServlet(mealChoiceService, mapper);
		
		MealOrderDAO mealOrderDAO = new MealOrderDAO();
		MealOrderService mealOrderService = new MealOrderService(mealOrderDAO);
		MealOrderServlet mealOrderServlet = new MealOrderServlet(mealOrderService, mapper);
		
		MealOrderPlusOneDAO mealOrderPlusOneDAO = new MealOrderPlusOneDAO();
		MealOrderPlusOneService mealOrderPlusOneService = new MealOrderPlusOneService(mealOrderPlusOneDAO);
		MealOrderPlusOneServlet mealOrderPlusOneServlet = new MealOrderPlusOneServlet(mealOrderPlusOneService, mapper);
		
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
		context.addServlet("MealChoiceServlet", mealChoiceServlet).addMapping("/mealChoice/*");
		context.addServlet("MealOrderServlet", mealOrderServlet).addMapping("/mealOrder/*");
		context.addServlet("MealOrderPlusOneServlet", mealOrderPlusOneServlet).addMapping("/mealOrderPlusOne/*");
		
		logger.info("contextInitialized");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		logger.info("contextDestroyed");
	}
}
