package com.capgemini.employee.app.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.capgemini.employee.app.model.PublicTraining;

public class PublicTrainingTest 
{

	@Test
	public void testToCheckObjectIsDefaultConstructor() 
	{
		PublicTraining publicTraining = new PublicTraining();
		assertNotNull(publicTraining);
	}
	
	@Test
	public void testToCheckObjectIsParameterizedConstructor() 
	{
		PublicTraining publicTraining = new PublicTraining(1,"Java",25000,40);
		assertEquals(1, publicTraining.getId());
		assertEquals("Java", publicTraining.getSubject());
		assertEquals(25000, publicTraining.getFees(),0.01);
		assertEquals(40,publicTraining.getParticipants());
	}
	
	@Test
	public void testToCheckOrderValue() 
	{
		PublicTraining publicTraining = new PublicTraining(1,"Java",25000,40);
		assertEquals(1000000, publicTraining.getOrderValue(),0.01);
	}
}
