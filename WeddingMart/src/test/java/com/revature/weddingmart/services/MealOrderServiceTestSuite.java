package com.revature.weddingmart.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.MealOrderDAO;
import com.revature.weddingmart.models.MealOrder;

public class MealOrderServiceTestSuite {
	MealOrderService sut;
	MealOrderDAO mockMealOrderDAO;
	
	@Before
	public void testPrep() {
		mockMealOrderDAO = mock(MealOrderDAO.class);
		sut = new MealOrderService(mockMealOrderDAO);
	}
	
	@Test
	public void test_addMealOrder() {
		MealOrder mealOrder = new MealOrder();
		when(mockMealOrderDAO.addMealOrder(mealOrder)).thenReturn(mealOrder);
		mealOrder = sut.addMealOrder(mealOrder);
		assertNotNull(mealOrder);
	}
	
	@Test
	public void test_getAllMealOrders() {
		MealOrder u1 = new MealOrder();
		MealOrder u2 = new MealOrder();
		MealOrder u3 = new MealOrder();
		ArrayList<MealOrder> mealOrders;
		mealOrders = new ArrayList<>();
		mealOrders.add(u1);
		mealOrders.add(u2);
		mealOrders.add(u3);
		
		when(mockMealOrderDAO.getAllMealOrders()).thenReturn(mealOrders);
		
		mealOrders = (ArrayList<MealOrder>)sut.getAllMealOrder();
		
		assertNotNull (mealOrders);
		assertFalse( mealOrders.isEmpty() );
	}
	
	@Test
	public void test_getMealOrderById() {
		MealOrder mealOrder = new MealOrder();
		when(mockMealOrderDAO.getMealOrderById(1)).thenReturn(mealOrder);
		mealOrder = sut.getMealOrderById(1);
		assertNotNull(mealOrder);
		mealOrder = sut.getMealOrderById(0);
		assertNull(mealOrder);
	}
	
	@Test
	public void test_updateMealOrder() {
		MealOrder mealOrder = new MealOrder();
		sut.updateMealOrder(mealOrder);
		assertNotNull(mealOrder);
	}
	
	@Test
	public void test_deleteMealOrder() {
		MealOrder mealOrder = new MealOrder();
		sut.deleteMealOrder(mealOrder);
		assertNotNull(mealOrder);
	}
}

