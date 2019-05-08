package com.capgemini.employee.app.model;

public class Manager extends Employee
{
	private double petrolAllowances;
	private double foodAllowances;
	private double otherAllowances;
	
	public Manager(int employeeID, String employeeName, double basicSalary, double medical)
	{
		super(employeeID,employeeName,basicSalary,medical);
		petrolAllowances = (0.08) * basicSalary;
		foodAllowances = (0.13) * basicSalary;
		otherAllowances = (0.02) * basicSalary;
		
	}
	public double grossSalary()
	{
		double grossSalary;
		grossSalary = super.grossSalary()+ petrolAllowances+ foodAllowances + otherAllowances;
		setGrossSalary(grossSalary);
		return grossSalary;
	}

}

