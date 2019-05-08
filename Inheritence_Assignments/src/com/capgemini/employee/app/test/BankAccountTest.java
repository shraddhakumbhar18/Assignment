package com.capgemini.employee.app.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.employee.app.model.BankAccount;

public class BankAccountTest 
{
	
	
	@Test
	public void testToWithdrawAmount()
	{
		BankAccount account = new BankAccount(101, "John Doe", "Current" , 20000);
	}
	@Test
	public void testToDepositeAmount()
	{
		BankAccount account = new BankAccount(101, "John Doe", "Current" , 20000);
		assertEquals(25000, account.deposit(5000));
	}
}
