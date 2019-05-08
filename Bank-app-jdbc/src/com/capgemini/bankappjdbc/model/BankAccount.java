package com.capgemini.bankappjdbc.model;

public class BankAccount 
{
	private long accountId;
	private String accoundHolderName;
	private String accountType;
	private double accountBalance;
	
	public BankAccount() 
	{
		super();
		
	}

	public BankAccount(String accoundHolderName, String accountType, double accountBalance) 
	{
		super();
		this.accoundHolderName = accoundHolderName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	

	public BankAccount(long accountId, String accountHolderName, String accountType, double accountBalance) 
	{
		super();
		this.accountId = accountId;
		this.accoundHolderName = accountHolderName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public long getAccountId() 
	{
		return accountId;
	}

	public void setAccountId(int accountId) 
	{
		this.accountId = accountId;
	}

	public String getAccoundHolderName() 
	{
		return accoundHolderName;
	}

	public void setAccoundHolderName(String accoundHolderName) 
	{
		this.accoundHolderName = accoundHolderName;
	}

	public String getAccountType() 
	{
		return accountType;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	public double getAccountBalance() 
	{
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) 
	{
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() 
	{
		return "BankAccount [accountId=" + accountId + ", accoundHolderName=" + accoundHolderName + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + "]";
	}
	
	
}
