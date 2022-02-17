package com.revature.weddingmart.services.users;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.models.users.User;

public class UserService {
	private final UserDAO userDAO;
	private final Logger logger = LogManager.getRootLogger();
	
	public UserService(UserDAO userDAO) {
		logger.atLevel(Level.ALL);
		logger.debug("Created UserService");
		this.userDAO = userDAO;
	}
	
	public User addUser(User user) {
		logger.debug("called UserService.addUser with " + user);
		return userDAO.addUser(user);
	}

	public List<User> getAllUsers() {
		logger.debug("called UserService.getAllUsers");
		return userDAO.getAllUsers();
	}

	public User getUserById(int id) {
		logger.debug("called UserService.getUserById" + id);
		return userDAO.getUserById(id);
	}

	public void updateUser(User user) {
		logger.debug("called UserService.updateUser");
		userDAO.updateUser(user);
	}

	public void deleteUser(User user) {
		logger.debug("called UserService.deleteUser");
		userDAO.deleteUser(user);
	}
}
