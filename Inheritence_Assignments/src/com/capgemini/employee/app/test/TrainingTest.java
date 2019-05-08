package com.capgemini.employee.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.employee.app.model.CorporateTraining;
import com.capgemini.employee.app.model.PublicTraining;
import com.capgemini.employee.app.model.Training;

public class TrainingTest 
{
	@Test
	public void testForPublicTraining() 
	{
		Training training = new PublicTraining(1,"Software",20000,10);
		assertEquals(200000, training.getOrderValue(),0.02);
	}
	@Test
	public void testForCorporateTraining() 
	{
		Training training = new CorporateTraining(2,"Data Structure",10000,20);
		assertEquals(200000, training.getOrderValue(),0.02);
	}
	
}
