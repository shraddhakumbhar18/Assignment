package com.capgemini.employee.app.model;

public class ManagerExecutive extends Employee
{
	private double kilometer;
	private double tourAllowance;
	private double telephoneAllowance;
	
	public ManagerExecutive(int employeeID, String employeeName, double basicSalary, double medical,double kilometer)
	{
		super(employeeID,employeeName,basicSalary,medical);
		this.kilometer=kilometer;
		
	}
	
	public double getKilometer() {
		return kilometer;
	}

	public void setKilometer(double kilometer) {
		this.kilometer = kilometer;
	}

	public double grossSalary()
	{
		tourAllowance = 5 * kilometer;
		telephoneAllowance = 1500;
		double grossSalary;
		grossSalary = super.grossSalary()+ telephoneAllowance+ tourAllowance + kilometer;
		setGrossSalary(grossSalary);
		return grossSalary;
	}
	
}
