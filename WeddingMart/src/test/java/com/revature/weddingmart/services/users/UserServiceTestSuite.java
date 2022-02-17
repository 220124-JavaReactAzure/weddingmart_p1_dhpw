package com.revature.weddingmart.services.users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.models.users.User;

public class UserServiceTestSuite {
	UserService sut;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockUserDAO = mock(UserDAO.class);
		sut = new UserService(mockUserDAO);
	}
	
	@Test
	public void test_addUser() {
		User user = new User();
		user.setEmail("test");
		when(mockUserDAO.addUser(user)).thenReturn(user);
		user = sut.addUser(user);
		assertNotNull(user);
	}
	
	@Test
	public void test_getAllUsers() {
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		ArrayList<User> users;
		users = new ArrayList<>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		when(mockUserDAO.getAllUsers()).thenReturn(users);
		
		users = (ArrayList<User>)sut.getAllUsers();
		
		assertNotNull (users);
		assertFalse( users.isEmpty() );
	}
	
	@Test
	public void test_getUserById() {
		User user = new User();
		user.setEmail("test");
		when(mockUserDAO.getUserById(1)).thenReturn(user);
		user = sut.getUserById(1);
		assertNotNull(user);
		user = sut.getUserById(0);
		assertNull(user);
	}
	
	@Test
	public void test_updateUser() {
		User user = new User();
		user.setEmail("test");
		sut.updateUser(user);
		assertNotNull(user);
	}
	
	@Test
	public void test_deleteUser() {
		User user = new User();
		user.setEmail("test");
		sut.deleteUser(user);
		assertNotNull(user);
	}
}
