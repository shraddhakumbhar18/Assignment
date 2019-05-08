package com.capgemini.employee.app.model;

public class CorporateTraining extends Training
{
	private int days;

	public CorporateTraining() 
	{
		super();
		
	}

	public CorporateTraining(int id, String subject, double fees, int days) 
	{
		super(id,subject,fees);
		this.days = days;
	}

	public int getDays() 
	{
		return days;
	}

	public void setDays(int days) 
	{
		this.days = days;
	}
	 
	public double getOrderValue()
	{
		return getFees()*days;
		
	}
	
}
