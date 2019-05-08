package com.capgemini.bankappjdbc.dao;

import java.util.List;

import com.capgemini.bankappjdbc.model.BankAccount;

public interface BankAccountDao 
{
	public double getBalance(long accountId);
	public void updateBalance(long accountId, double newBalance);
	public boolean deleteBankAccount(long accountId);
	public boolean addNewBankAccount(BankAccount account);
	public List<BankAccount> findAllBankAccount();
	public BankAccount searchAccount(long accountId);
	public boolean updateAccount(long accountId , String accountHolderName , String accountType);
}
