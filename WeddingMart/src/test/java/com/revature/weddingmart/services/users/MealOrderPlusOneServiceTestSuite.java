package com.revature.weddingmart.services.users;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.weddingmart.daos.MealOrderPlusOneDAO;
import com.revature.weddingmart.models.MealOrderPlusOne;
import com.revature.weddingmart.services.MealOrderPlusOneService;

public class MealOrderPlusOneServiceTestSuite {
	MealOrderPlusOneService sut;
	MealOrderPlusOneDAO mockMealOrderPlusOneDAO;
	
	@Before
	public void testPrep() {
		mockMealOrderPlusOneDAO = mock(MealOrderPlusOneDAO.class);
		sut = new MealOrderPlusOneService(mockMealOrderPlusOneDAO);
	}
	
	@Test
	public void test_addMealOrderPlusOne() {
		MealOrderPlusOne mealOrderPlusOne = new MealOrderPlusOne();
		when(mockMealOrderPlusOneDAO.addMealOrderPlusOne(mealOrderPlusOne)).thenReturn(mealOrderPlusOne);
		mealOrderPlusOne = sut.addMealOrderPlusOne(mealOrderPlusOne);
		assertNotNull(mealOrderPlusOne);
	}
	
	@Test
	public void test_getAllMealOrderPlusOnes() {
		MealOrderPlusOne u1 = new MealOrderPlusOne();
		MealOrderPlusOne u2 = new MealOrderPlusOne();
		MealOrderPlusOne u3 = new MealOrderPlusOne();
		ArrayList<MealOrderPlusOne> mealOrderPlusOnes;
		mealOrderPlusOnes = new ArrayList<>();
		mealOrderPlusOnes.add(u1);
		mealOrderPlusOnes.add(u2);
		mealOrderPlusOnes.add(u3);
		
		when(mockMealOrderPlusOneDAO.getAllMealOrderPlusOnes()).thenReturn(mealOrderPlusOnes);
		
		mealOrderPlusOnes = (ArrayList<MealOrderPlusOne>)sut.getAllMealOrderPlusOnes();
		
		assertNotNull (mealOrderPlusOnes);
		assertFalse( mealOrderPlusOnes.isEmpty() );
	}
	
	@Test
	public void test_getMealOrderPlusOneById() {
		MealOrderPlusOne mealOrderPlusOne = new MealOrderPlusOne();
		when(mockMealOrderPlusOneDAO.getMealOrderPlusOneById(1)).thenReturn(mealOrderPlusOne);
		mealOrderPlusOne = sut.getMealOrderPlusOneById(1);
		assertNotNull(mealOrderPlusOne);
		mealOrderPlusOne = sut.getMealOrderPlusOneById(0);
		assertNull(mealOrderPlusOne);
	}
	
	@Test
	public void test_updateMealOrderPlusOne() {
		MealOrderPlusOne mealOrderPlusOne = new MealOrderPlusOne();
		sut.updateMealOrderPlusOne(mealOrderPlusOne);
		assertNotNull(mealOrderPlusOne);
	}
	
	@Test
	public void test_deleteMealOrderPlusOne() {
		MealOrderPlusOne mealOrderPlusOne = new MealOrderPlusOne();
		sut.deleteMealOrderPlusOne(mealOrderPlusOne);
		assertNotNull(mealOrderPlusOne);
	}
}



