package com.capgemini.employee.app.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.capgemini.employee.app.model.CorporateTraining;

public class CorporateTrainingTest 
{
	@Test
	public void testToCheckObjectIsDefaultConstructor() {
		CorporateTraining corporateTraining = new CorporateTraining();
		assertNotNull(corporateTraining);
	}
	@Test
	public void testToCheckObjectIsParameterizedConstructor() {
		CorporateTraining corporateTraining = new CorporateTraining(1,"Database",20000,4);
		assertEquals(1, corporateTraining.getId());
		assertEquals("Database", corporateTraining.getSubject());
		assertEquals(20000, corporateTraining.getFees(),0.01);
		assertEquals(4,corporateTraining.getDays());
	}
	
	@Test
	public void testToCheckOrderValue() 
	{
		CorporateTraining corporateTraining = new CorporateTraining(1,"Database",20000,4);
		assertEquals(80000, corporateTraining.getOrderValue(),0.02);
	}

}

