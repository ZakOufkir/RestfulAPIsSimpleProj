package com.examplerest.entities;

import java.util.List;

import com.examplerest.service.MyEmpService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


import jakarta.persistence.*;



@Entity
@Table(name="Hourlyemp")
public final class HourlyEmployee extends Employee {
	

	private double hourlyWorked;
	private double hoursWorked;

	public HourlyEmployee() {
	}

	public HourlyEmployee(Long empsupId, String name, String type, String department, double hourlyWorked, double hoursWorked) {
		super(empsupId, name, type, department);
		this.hourlyWorked = hourlyWorked;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double getPayment() {
		// TODO Auto-generated method stub
		return hourlyWorked*hoursWorked;
	}

	@Override
	public List<Employee> getThreeHighestPaid() {
		return List.of();
	}

	public double getHourlyWorked() {
		return hourlyWorked;
	}

	public void setHourlyWorked(double hourlyWorked) {
		this.hourlyWorked = hourlyWorked;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
}
