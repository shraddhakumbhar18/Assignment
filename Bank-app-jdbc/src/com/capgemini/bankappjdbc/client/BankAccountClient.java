package com.capgemini.bankappjdbc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.log4j.Logger;

import com.capgemini.bankappjdbc.exception.BankAccountNotFoundException;
import com.capgemini.bankappjdbc.exception.LowBalanceException;
import com.capgemini.bankappjdbc.model.BankAccount;
import com.capgemini.bankappjdbc.service.BankAccountService;
import com.capgemini.bankappjdbc.service.impl.BankAccountServiceImpl;

public class BankAccountClient 
{
	static final Logger logger = Logger.getLogger(BankAccountClient.class);
	
	public static void main(String[] args) throws IOException 
	{	
		int choice;
		String accountHolderName;
		String accountType;
		double accountBalance;
		long accountId;
		double amount;
		long fromAccount;
		long toAccount;
		BankAccountService bankService = new BankAccountServiceImpl();
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
		{
			while(true)
			{
				System.out.println("1) Add New Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposite");
				System.out.println("4) Check Balance");
				System.out.println("5) Fund Transfer");
				System.out.println("6) Delete BankAccount");
				System.out.println("7) Display BankAccount Details");
				System.out.println("8) search Account");
				System.out.println("9) Update Account");
				System.out.println("10) Exit");
				
				System.out.println("Enter your choice : ");
				choice = Integer.parseInt(reader.readLine());
				
				switch (choice) 
				{
					case 1:System.out.println("Enter Account Holder Name :");
							accountHolderName = reader.readLine();
							System.out.println("Enter Account Type :");
							accountType = reader.readLine();
							System.out.println("Enter account balance:");
							accountBalance = Double.parseDouble(reader.readLine());
							BankAccount account = new BankAccount(accountHolderName, accountType, accountBalance);
							if(bankService.addNewAccount(account))
							{
								System.out.println("Account created successfully");
							}
							else
							{
								System.out.println("Failed to create account");
							}
							break;
					case 2: System.out.println("Enter the AccountId");
							accountId = Long.parseLong(reader.readLine());
							System.out.println("Enter the Amount");
							amount = Double.parseDouble(reader.readLine());
							try 
							{
								bankService.withdraw(accountId, amount);
								System.out.println("Amount Withdraw successfully");
							} 
							catch(BankAccountNotFoundException e) 
							{
								logger.error("Bank Account Not found : " ,e);
							}
							
							catch(LowBalanceException e)
							{
								logger.error("Withdraw Failed : " ,e);
							}
							
							break;
					
					case 3:System.out.println("Enter the AccountId");
							accountId = Long.parseLong(reader.readLine());
							System.out.println("Enter the Amount");
							amount = Double.parseDouble(reader.readLine());
							try 
							{
								bankService.deposite(accountId, amount);
								
							} 
							catch (BankAccountNotFoundException e) 
							{
								logger.error("Deposite Failed : " ,e);
							}
							System.out.println("Amount Deposite successfully");
							break;
					case 4: System.out.println("Enter the AccountId");
							accountId = Long.parseLong(reader.readLine());
							double balance = 0;
							try 
							{
								balance = bankService.checkBalance(accountId);
							} 
							catch (BankAccountNotFoundException e) 
							{
								logger.error("Bank account doesn't exist and Balance Failed to display : " ,e);
							}
							System.out.println("Balance is:"+ balance);
							break;
					case 5:	System.out.println("Enter the AccountId from which amount is to be transferred");
							fromAccount = Long.parseLong(reader.readLine());
							System.out.println("Enter the AccountId to which amount is to be transferred");
							toAccount = Long.parseLong(reader.readLine());
							System.out.println("Enter the Amount to be transferred");
							amount = Double.parseDouble(reader.readLine());
							try 
							{
								bankService.fundTransfer(fromAccount,toAccount, amount);
									
							} 
							catch (BankAccountNotFoundException e) 
							{
									
								logger.error("Bank account doesnot exist : " ,e);
							}
							catch (LowBalanceException e) 
							{
								
								logger.error("Low balance exception : " ,e);
							}
							System.out.println("Amount transferred Successfully");
							break;
					case 6: System.out.println("Enter the AccountId to be deleted");
							accountId = Long.parseLong(reader.readLine());
							try 
							{
								if(bankService.deleteBankAccount(accountId))
								{
									System.out.println("Account deleted successfully");
								}
								else
								{
									System.out.println("Account deletion Failed");
								}
								
							} 
							catch (BankAccountNotFoundException e) 
							{
						
								logger.error("Bank account doesnot exist : " ,e);
							}
							break;
					case 7:	List<BankAccount> accountList = bankService.findAllBankAccounts();
							for (BankAccount bankAccount : accountList) 
							{
								System.out.println(bankAccount);
							}
							break;
					case 8: System.out.println("Enter the AccountId to be searched");
							accountId = Long.parseLong(reader.readLine());
							BankAccount account2 = null;
							try 
							{
								account2 = bankService.search(accountId);
							} 
							catch (BankAccountNotFoundException e) 
							{
								e.printStackTrace();
							}
							System.out.println(account2);
							break;
							
					case 9:System.out.println("Enter the AccountId for updation");
							accountId = Long.parseLong(reader.readLine());
							System.out.println("Enter the Customer Name to be updated");
							accountHolderName = reader.readLine();
							System.out.println("Enter the Account Type to be updated");
							accountType = reader.readLine();
							if(bankService.update(accountId, accountHolderName, accountType))
							{
								System.out.println("Account updated successfully");
							}
							else
							{
								System.out.println("Account updation failed");
							}
							break;
					case 10:System.out.println("Thanks for banking with us.");
							System.exit(0);
				}
			}
		}
		catch (IOException e) 
		{
			//e.printStackTrace();
			logger.error("Exception : " ,e);
		}
	}
}
