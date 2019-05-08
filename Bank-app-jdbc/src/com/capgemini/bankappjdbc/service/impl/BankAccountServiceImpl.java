package com.capgemini.bankappjdbc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.capgemini.bankappjdbc.dao.BankAccountDao;
import com.capgemini.bankappjdbc.dao.impl.BankAccountDaolmpl;
import com.capgemini.bankappjdbc.exception.BankAccountNotFoundException;
import com.capgemini.bankappjdbc.exception.LowBalanceException;
import com.capgemini.bankappjdbc.model.BankAccount;
import com.capgemini.bankappjdbc.service.BankAccountService;
import com.capgemini.bankappjdbc.util.DbUtil;

public class BankAccountServiceImpl implements BankAccountService 
{
	static final Logger logger = Logger.getLogger(BankAccountServiceImpl.class);
	
	private BankAccountDao bankAccountDao;

	public BankAccountServiceImpl() 
	{
		bankAccountDao = new BankAccountDaolmpl(); 
	}

	@Override
	public double checkBalance(long accountId) throws BankAccountNotFoundException
	{
		double balance = bankAccountDao.getBalance(accountId);
		if(balance >= 0)
			return balance;
		throw new BankAccountNotFoundException("Bank Account doesn't exist..");
		
		
	}

	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException, BankAccountNotFoundException 
	{
		double balance = bankAccountDao.getBalance(accountId);
		if(balance < 0)
			throw new BankAccountNotFoundException("Bank Account doesn't exist..");
		if(balance - amount >= 0)
		{
			balance = balance - amount;
			bankAccountDao.updateBalance(accountId, balance);
			DbUtil.commit();
			return balance;
		}
		else
		{
			throw new LowBalanceException("You don't have a sufficient balance..");
		}
	}

	@Override
	public double deposite(long accountId, double amount) throws BankAccountNotFoundException 
	{
		
		double balance = bankAccountDao.getBalance(accountId);
		if(balance < 0)
			throw new BankAccountNotFoundException("Bank account Doesn't exist...");
		balance = balance + amount;
		bankAccountDao.updateBalance(accountId, balance);
		DbUtil.commit();
		return balance;
	}

	@Override
	public boolean deleteBankAccount(long accountId) throws BankAccountNotFoundException 
	{
		boolean result = bankAccountDao.deleteBankAccount(accountId); 
		if(result)
		{
			DbUtil.commit();
			return result;
		}
		throw new BankAccountNotFoundException("Bank Account Doesn't exist..");
	}

	@Override
	public double fundTransfer( long fromAccount ,long toAccount, double amount) throws BankAccountNotFoundException, LowBalanceException
	{
		try
		{
			double newBalance = withdraw(fromAccount, amount);
			deposite(toAccount, amount);
			DbUtil.commit();
			return newBalance;
		}
		catch (LowBalanceException | BankAccountNotFoundException e) 
		{
			logger.error("Exception", e);
			DbUtil.rollback();
			throw e;
		}
			
	}
	
	
	public double withdrawForFundTransfer(long accountId, double amount) throws LowBalanceException, BankAccountNotFoundException 
	{
		double balance = bankAccountDao.getBalance(accountId);
		if(balance < 0)
			throw new BankAccountNotFoundException("Bank Account doesn't exist..");
		if(balance - amount >= 0)
		{
			balance = balance - amount;
			bankAccountDao.updateBalance(accountId, balance);
			
			return balance;
		}
		else
		{
			throw new LowBalanceException("You don't have a sufficient balance..");
		}
	}

	@Override
	public boolean addNewAccount(BankAccount account) 
	{
		boolean result = bankAccountDao.addNewBankAccount(account);
		if(result)
		{
			DbUtil.commit();
		}
		return result;
	}

	@Override
	public List<BankAccount> findAllBankAccounts() 
	{
		return bankAccountDao.findAllBankAccount();
	}

	@Override
	public BankAccount search(long accountId) throws BankAccountNotFoundException 
	{
		BankAccount result = bankAccountDao.searchAccount(accountId); 
		if(result != null)
		{
			return result;
		}
		throw new BankAccountNotFoundException("BankAccount doesn't exist..");
		
		
	}

	@Override
	public boolean update(long accountId, String accountHolderName, String accountType) 
	{
		boolean result = bankAccountDao.updateAccount(accountId, accountHolderName, accountType);
		if(result)
		{
			DbUtil.commit();
		}
		return result;
	}
	
}
