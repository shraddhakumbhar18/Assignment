package com.capgemini.employee.app.model;

public abstract class Training 
{
	private int id;
	private String subject;
	private double fees;
	
	public Training() 
	{
		super();


	}
	public Training(int id, String subject, double fees) 
	{
		super();
		this.id = id;
		this.subject = subject;
		this.fees = fees;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getSubject() 
	{
		return subject;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	public double getFees() 
	{
		return fees;
	}
	public void setFees(double fees) 
	{
		this.fees = fees;
	}
	
	public abstract double getOrderValue();
}
