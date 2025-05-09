package com.examplerest.controller;

import com.examplerest.exception.IllegalArgumentsException;
import com.examplerest.service.HourlyEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examplerest.entities.HourlyEmployee;

import java.util.List;


@RestController
@RequestMapping("/api/hourly")
public class HourlyController {

	@Autowired
	private HourlyEmpService employeeSvc;


	
	@PostMapping("/save")
	public ResponseEntity<HourlyEmployee> saveHourlyEmp(@RequestBody HourlyEmployee hourlemp) {
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
	@GetMapping("{id}")
	public HourlyEmployee getHourlyEmpById(@PathVariable Long id){
		//Prelimienary verification
		if (id<0)
			throw new IllegalArgumentsException("Illegal Argument Exception. Id :"+id+" is not Valid.");
		else
			return employeeSvc.getTheHourEmpById(id);
	}
	@DeleteMapping("/delete/{i}")
	public void deleteHourlyEmp (@PathVariable Long id){
		employeeSvc.deleteHourlById(id);
	}

}
