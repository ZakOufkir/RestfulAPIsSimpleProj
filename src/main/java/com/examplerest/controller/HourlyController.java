package com.examplerest.controller;

import com.examplerest.service.MyEmpService;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.examplerest.entities.HourlyEmployee;

import java.util.List;


@RestController
@RequestMapping("/api/hourly")
public class HourlyController {

	@Autowired
	private MyEmpService employeeSvc;


	
	@PostMapping("/save")
	public String saveHourlyEmp(@RequestBody HourlyEmployee hourlemp) {
		HourlyEmployee hem = new HourlyEmployee();
		hem.setHourlyWorked(hourlemp.getHourlyWorked());
		hem.setHoursWorked(hourlemp.getHoursWorked());
		hem.setName(hourlemp.getName());
		hem.setType(hourlemp.getType());
		hem.setType(hourlemp.getDepartment());
		
		return employeeSvc.saveHourlyEmp(hourlemp);
	}

	@GetMapping("/highpay")
	public HourlyEmployee getTheHighestPaid(){
		return (HourlyEmployee) employeeSvc.getHighesPaidHourlyEmp();
	}

	@GetMapping("/threeHigh")
	public List<HourlyEmployee> getTheThreeHighestEmployee(){
		return employeeSvc.getThreeHighestHourlyEmp();
	}
}
