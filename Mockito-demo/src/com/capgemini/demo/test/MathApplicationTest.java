package com.capgemini.demo.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.service.CalculatorService;

public class MathApplicationTest 
{
	@Mock
	private CalculatorService service;
	
	@InjectMocks
	MathApplication application = new MathApplication(service);
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testToPerformAdditionWithTwoPositive()
	{
		when(service.addition(6,4)).thenReturn(10);
		assertEquals(10, application.performAddition(6, 4));
	}
	
	@Test
	public void testToPerformAdditionWithOnePositiveAndOneNegative()
	{
		when(service.addition(6, -2)).thenReturn(4);
		assertEquals(4, application.performAddition(6, -2));
	}
	
	@Test
	public void testToPerformAdditionWithBothNegative()
	{
		when(service.addition(-6, -2)).thenReturn(-8);
		assertEquals(-8, application.performAddition(-6, -2));
	}
	
	@Test
	public void testToPerformSubstractionWithTwoPositive()
	{
		when(service.substraction(6,4)).thenReturn(2);
		assertEquals(2, application.performSubstraction(6, 4));
	}
	
	@Test
	public void testToPerformSubstractionWithTwoNegative()
	{
		when(service.substraction(-5,-3)).thenReturn(-8);
		assertEquals(-8, application.performSubstraction(-5, -3));
	}
	
	@Test
	public void testToPerformSubstractionWithOnePositiveOneNegative()
	{
		when(service.substraction(5,-3)).thenReturn(2);
		assertEquals(2, application.performSubstraction(5, -3));
	}
	
	
	
	@Test
	public void testToPerformMultiplicationWithTwoPositive()
	{
		when(service.multiplication(6,4)).thenReturn(24);
		assertEquals(24, application.performMultiplication(6, 4));
	}
	
	@Test
	public void testToPerformMultiplicationWithTwoNegative()
	{
		when(service.multiplication(-5,-3)).thenReturn(15);
		assertEquals(15, application.performMultiplication(-5, -3));
	}
	
	@Test
	public void testToPerformMultiplicationWithOnePositiveOneNegative()
	{
		when(service.multiplication(5,-3)).thenReturn(-15);
		assertEquals(-15, application.performMultiplication(5, -3));
	}
	
	
	@Test
	public void testToPerformDivisionWithTwoPositive()
	{
		when(service.division(6,3)).thenReturn(2);
		assertEquals(2, application.performDivision(6, 3));
	}
	
	@Test
	public void testToPerformDivisionWithTwoNegative()
	{
		when(service.division(-10,-5)).thenReturn(2);
		assertEquals(2, application.performDivision(-10, -5));
	}
	
	@Test
	public void testToPerformDivisionWithOnePositiveOneNegative()
	{
		when(service.division(10,-5)).thenReturn(-2);
		assertEquals(-2, application.performDivision(10, -5));
	}
	
	
	@Test
	public void testFindFactorialWithPositiveInteger() 
	{
		when(service.factorial(5)).thenReturn(120L);
		assertEquals(120, application.performFactorial(5));
	}
	

	@Test
	public void testFindFactorialWithNegativeInteger() 
	{
		when(service.factorial(-5)).thenReturn(-120L);
		assertEquals(-120, application.performFactorial(-5));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testPerformDivisionWithDivisorZero() 
	{
		doThrow(new ArithmeticException("/ by zero")).when(service).division(10, 0);
		application.performDivision(10, 0); 
	}
	
	@Test
	public void testFindTheSquareWithPosoitiveNumber()
	{
		when(service.square(2)).thenReturn((long) 4);
		assertEquals(4, application.performSquare(2));
	}

	@Test
	public void testFindTheSquareWithNegativeNumber()
	{
		when(service.square(-2)).thenReturn((long) 4);
		assertEquals(4, application.performSquare(-2));
	}
}
