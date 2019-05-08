package com.capgemini.employee.app.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.employee.app.model.ManagerExecutive;

public class ManagerExecutiveTest 
{
	@Test
	public void testManagerExecutiveObjectIsCreatedWithParameterizedConstructor()
	{
		ManagerExecutive manager1 = new ManagerExecutive(10, "Doe", 3000, 2000,10);
		assertNotNull(manager1);
		assertEquals(10, manager1.getEmployeeID());
		assertEquals("Doe", manager1.getEmployeeName());
		assertEquals(3000, manager1.getBasicSalary(),0.01);
		assertEquals(2000, manager1.getMedical(),0.01);
		assertEquals(10, manager1.getKilometer(),0.01);
	}
	@Test
	public void testToCalculateGrossSalary() 
	{
		ManagerExecutive manager1 = new ManagerExecutive(10, "Doe", 3000, 2000,10);
		assertEquals(8060.0, manager1.grossSalary(), 0.01);
	}
	@Test
	public void testToCalculateNetSalary() 
	{
		ManagerExecutive manager1 = new ManagerExecutive(10, "Doe", 3000, 2000,10);
		manager1.grossSalary();
		assertEquals(7500.0, manager1.netSalary(), 0.01);
	}
}
