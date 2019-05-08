package com.capgemini.employee.app.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.employee.app.model.Employee;

public class EmployeeTest {
	private Employee employee;

	@Before
	public void setUp() {
		employee = new Employee(101, "John Doe", 35000, 2500);
	}

	@Test
	public void testEmployeeObjectIsCreatedWithDefaultConstructor() {
		Employee employee = new Employee();
		assertNotNull(employee);
	}

	@Test
	public void testEmployeeObjectIsCreatedWithParameterizedConstructor() {
		Employee employee = new Employee(101, "John Doe", 35000, 2500);
		assertNotNull(employee);
		assertEquals(101, employee.getEmployeeID());
		assertEquals("John Doe", employee.getEmployeeName());
		assertEquals(35000, employee.getBasicSalary(), 0.01);
		assertEquals(2500, employee.getMedical(), 0.01);
	}

	@Test
	public void testToCalculateGrossSalary() {
		employee.grossSalary();
		assertEquals(55000.0, employee.getGrossSalary(), 0.01);
	}

	@Test
	public void testToCalculateNetSalary() {
		employee.grossSalary();
		employee.netSalary();
		assertEquals(50600.0, employee.getNetSalary(), 0.01);
	}
}
