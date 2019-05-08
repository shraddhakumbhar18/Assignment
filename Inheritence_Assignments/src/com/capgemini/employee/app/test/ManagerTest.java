package com.capgemini.employee.app.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.employee.app.model.Manager;

public class ManagerTest 
{
	private Manager manager;

	@Before
	public void setUp() {
		manager = new Manager(10, "Doe", 3000, 2000);
	}
	
	@Test
	public void testManagerObjectIsCreatedWithParameterizedConstructor()
	{
		Manager manager = new Manager(10, "Doe", 3000, 2000);
		assertNotNull(manager);
		assertEquals(10, manager.getEmployeeID());
		assertEquals("Doe", manager.getEmployeeName());
		assertEquals(3000, manager.getBasicSalary(),0.01);
		assertEquals(2000, manager.getMedical(),0.01);
	}
	@Test
	public void testToCalculateGrossSalary() 
	{
		assertEquals(63050, manager.grossSalary(), 0.01);
	}
	@Test
	public void testToCalculateNetSalary() 
	{
		manager.grossSalary();
		assertEquals(58650, manager.netSalary(), 0.01);
	}
}
