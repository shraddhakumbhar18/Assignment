package com.capgemini.employee.app.model;

public class Employee 
{
	private int employeeID;
	private String employeeName;
	private double basicSalary;
	private double hra;
	private double medical;
	private double pt;
	private double pf;
	private double netSalary;
	private double grossSalary;
	
	public Employee() 
	{
		super();
	}

	public Employee(int employeeID, String employeeName, double basicSalary, double medical) 
	{
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.basicSalary = basicSalary;
		this.medical = medical;
	}

	public int getEmployeeID() 
	{
		return employeeID;
	}

	public void setEmployeeID(int employeeID) 
	{
		this.employeeID = employeeID;
	}

	public String getEmployeeName() 
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
	}

	public double getBasicSalary() 
	{
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) 
	{
		this.basicSalary = basicSalary;
	}

	public double getMedical() 
	{
		return medical;
	}

	public void setMedical(double medical) 
	{
		this.medical = medical;
	}
	public double getNetSalary() 
	{
		return netSalary;
	}

	public void setNetSalary(double netSalary) 
	{
		this.netSalary = netSalary;
	}

	public double getGrossSalary() 
	{
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) 
	{
		this.grossSalary = grossSalary;
	}

	public double grossSalary()
	{
		double hra = (0.50) * basicSalary;
		grossSalary = basicSalary+ hra + medical;
		return grossSalary;
	}
	public double netSalary()
	{
		double pf = (0.12) * basicSalary;
		double pt = 200;
		netSalary = getGrossSalary()- (pt + pf);
		return netSalary;
	}
}
