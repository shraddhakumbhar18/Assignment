package com.capgemini.bankapp.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bankapp.model.BankAccount;

public class BankAccountTest 
{
	private BankAccount account;
	
	@Before
	public void setUp() 
	{
		account = new BankAccount(101,"John Doe","Saving",35000);
	}
	
	@Test
	public void testBankAccountObjectIsCreatedWithDefaultConstructor()
	{
		BankAccount account = new BankAccount();
		assertNotNull(account);
	}
	
	@Test
	public void testBankAccountObjectIsCreatedWithParameterizedConstructor()
	{
		BankAccount account = new BankAccount(101,"John Doe","Saving",45000);
		assertNotNull(account);
		assertEquals(101,account.getAccountId());
		assertEquals("John Doe",account.getAccountHolderName());
		assertEquals("Saving", account.getAccountType());
		assertEquals(45000.0, account.getAccountBalance(),0.01);
	}
	@Test
	public void testBankAccountCurrentBalance()
	{
		assertEquals(35000, account.getAccountBalance(),0.01);
	}
	
	@Test
	public void testWithdrawWithSufficientFund()
	{
		account.withdraw(5000);
		assertEquals(30000, account.getAccountBalance(),0.01);
	}
	@Test
	public void testWithdrawWithInSufficientFund()
	{
		account.withdraw(45000);
		assertEquals(35000, account.getAccountBalance(),0.01);
	}
	@Test
	public void testDeposite()
	{
		account.deposite(5000);
		assertEquals(40000, account.getAccountBalance());
	}
}
