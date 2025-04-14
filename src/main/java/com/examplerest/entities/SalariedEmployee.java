package com.examplerest.entities;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name="SalariedEmp")

public final class SalariedEmployee extends Employee {
	

	private double salary;


	private double annualBonus;

	public SalariedEmployee() {

	}
	public SalariedEmployee(Long empsupId, String name, String type, String department, double salary, double annualBonus) {
		super(empsupId, name, type, department);
		this.salary = salary;
		this.annualBonus = annualBonus;
	}

	@Override
	public double getPayment() {
		// TODO Auto-generated method stub
		return salary+annualBonus;
	}

	@Override
	public List<Employee> getThreeHighestPaid() {
		return List.of();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAnnualBonus() {
		return annualBonus;
	}

	public void setAnnualBonus(double annualBonus) {
		this.annualBonus = annualBonus;
	}
}
