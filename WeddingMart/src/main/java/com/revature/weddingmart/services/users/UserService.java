package com.revature.weddingmart.services.users;

import java.util.List;
import java.util.logging.Logger;

import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.models.users.User;

public class UserService {
	private final UserDAO userDAO;
	private Logger logger;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
		this.logger = Logger.getLogger("");
		logger.config("Created UserService");
	}
	
	public User addUser(User user) {
		logger.info("called UserService.addUser with " + user);
		return userDAO.addUser(user);
	}

	public List<User> getAllUsers() {
		logger.info("called UserService.getAllUsers");
		return userDAO.getAllUsers();
	}

	public User getUserById(int id) {
		logger.info("called UserService.getUserById with id " + id);
		return userDAO.getUserById(id);
	}

	public void updateUser(User user) {
		logger.info("called UserService.updateUser with data " + user);
		userDAO.updateUser(user);
	}

	public void deleteUser(User user) {
		logger.info("called UserService.deleteUser");
		userDAO.deleteUser(user);
	}
}
