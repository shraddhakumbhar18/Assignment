package com.capgemini.bankappjdbc.exception;

public class LowBalanceException extends Exception 
{
	public LowBalanceException(String message) 
	{
		super(message);
	}
}
