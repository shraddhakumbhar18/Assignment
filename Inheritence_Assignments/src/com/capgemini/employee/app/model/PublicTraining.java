package com.capgemini.employee.app.model;

public class PublicTraining extends Training
{
	private int participants;

	public PublicTraining() 
	{
		super();
	}

	public PublicTraining(int id, String subject, double fees,int participants) 
	{
		super(id,subject,fees);
		this.participants = participants;
	}

	public int getParticipants() 
	{
		return participants;
	}

	public void setParticipants(int participants) 
	{
		this.participants = participants;
	}
	
	public double getOrderValue()
	{
		return getFees()*participants;
		
	}
}
