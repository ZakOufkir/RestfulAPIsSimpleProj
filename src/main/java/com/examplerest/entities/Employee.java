package com.examplerest.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@MappedSuperclass

public  abstract class Employee  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empsupId;
	
	private String name;
	private String type;
	private String department;


	public Employee() {

	}
	public Employee(Long empsupId, String name, String type, String department) {
		this.empsupId = empsupId;
		this.name = name;
		this.type = type;
		this.department = department;
	}



	public abstract double getPayment();
	
	public abstract List<Employee> getThreeHighestPaid();

	public Long getEmpsupId() {
		return empsupId;
	}

	public void setEmpsupId(Long empsupId) {
		this.empsupId = empsupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
