package com.capgemini.bankappjdbc.service;

import java.util.List;

import com.capgemini.bankappjdbc.exception.BankAccountNotFoundException;
import com.capgemini.bankappjdbc.exception.LowBalanceException;
import com.capgemini.bankappjdbc.model.BankAccount;

public interface BankAccountService 
{
	public double checkBalance(long accountId) throws BankAccountNotFoundException;
	public double withdraw(long accountId, double amount) throws LowBalanceException, BankAccountNotFoundException;
	public double deposite(long accountId , double amount) throws BankAccountNotFoundException;
	public boolean deleteBankAccount(long accountId) throws BankAccountNotFoundException;
	public double fundTransfer(long toAccount, long fromAccount , double amount) throws LowBalanceException, BankAccountNotFoundException;
	public boolean addNewAccount(BankAccount account);
	public List<BankAccount> findAllBankAccounts();
	public BankAccount search(long accountId) throws BankAccountNotFoundException;
	public boolean update(long accountId, String accountHolderName, String accountType);
}
