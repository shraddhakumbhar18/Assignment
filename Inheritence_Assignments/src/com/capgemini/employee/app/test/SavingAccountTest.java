package com.capgemini.employee.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.employee.app.model.SavingAccount;

public class SavingAccountTest 
{

	private SavingAccount account;

	@Before
	public void setUp() 
	{
		account = new SavingAccount(101, "John", 45000, true);
	}

	@Test
	public void testWithdrawWithSalaryAccountAndSufficientBalance() 
	{
		assertEquals(40000, account.withdraw(5000), 0.01);
	}
	@Test
	public void testWithdrawWithSalaryAccountAndInSufficientBalance() 
	{
		assertEquals(45000, account.withdraw(50000), 0.01);
	}

	@Test
	public void testWithdrawWithNotSalaryAccountAndSufficientBalace() 
	{
		account = new SavingAccount(101, "John", 45000, false);
		assertEquals(40000, account.withdraw(5000), 0.01);
	}
	
	@Test
	public void testWithdrawWithNotSalaryAndInSufficientBalance() 
	{
		account = new SavingAccount(101, "John", 45000, false);
		assertEquals(45000, account.withdraw(45000), 0.01);
	}
	
	@Test
	public void testdeposit() 
	{
		account = new SavingAccount(101, "John", 45000, false);
		assertEquals(50000, account.deposit(5000), 0.01);
	}
}
