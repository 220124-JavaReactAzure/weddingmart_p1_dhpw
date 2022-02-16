package com.revature.weddingmart.services.users;

import java.util.List;

import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.models.users.User;

public class UserService {
	private final UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User addUser(User user) {
		return userDAO.addUser(user);
	}

	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}
}
