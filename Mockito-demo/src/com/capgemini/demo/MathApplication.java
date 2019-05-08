package com.capgemini.demo;

import com.capgemini.demo.service.CalculatorService;

public class MathApplication 
{
	private CalculatorService service;

	public MathApplication(CalculatorService service) 
	{
		super();
		this.service = service;
	}
	
	public int performAddition(int number1, int number2)
	{
		return service.addition(number1, number2);
	}
	
	public int performSubstraction(int number1, int number2)
	{
		return service.substraction(number1, number2);
	}
	
	public int performMultiplication(int number1, int number2)
	{
		return service.multiplication(number1, number2);
	}
	
	public int performDivision(int number1, int number2)
	{
		return service.division(number1, number2);
	}
	
	public long performFactorial(int number)
	{
		return service.factorial(number);
	}
	
	public long performSquare(int number)
	{
		return service.square(number);
	}
}
