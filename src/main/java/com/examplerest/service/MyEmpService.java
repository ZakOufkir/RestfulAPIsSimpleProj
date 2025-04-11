package com.examplerest.service;

import com.examplerest.entities.Employee;
import com.examplerest.entities.HourlyEmployee;
import com.examplerest.entities.SalariedEmployee;
import com.examplerest.hourlyemprepo.HourlyRepo;
import com.examplerest.salariedemprepo.SalariedEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyEmpService {
	
	@Autowired
	private HourlyRepo hourlyEmpRepo;
	@Autowired
	private SalariedEmployeeRepo salariedmployeeRepo;


	public HourlyEmployee getHighesPaidHourlyEmp() {
		List<HourlyEmployee> listOfSalEmp = hourlyEmpRepo.findAll();
		Optional<HourlyEmployee> emp = listOfSalEmp.stream().max(Comparator.comparingDouble(HourlyEmployee::getPayment));
		System.out.println(emp.get().getPayment());
		if (emp.isPresent())
			return emp.get();
		else
			return null;
	}

	public String saveHourlyEmp(HourlyEmployee hourlemp) {
		
		 hourlyEmpRepo.save(hourlemp);
		 return "Success ";
		
	}
	public List<Employee> getThreeHighestSalariedEmp() {
		// TODO Auto-generated method stub
		List<SalariedEmployee> emp =  salariedmployeeRepo.findAll();
		if (emp.size()>=3) {
			return emp.stream().sorted(Comparator.comparingDouble(SalariedEmployee::getPayment).reversed()).
					limit(3).collect(Collectors.toList());
		}else {
			return null;
		}
	}


	public String saveSlariedEmp(SalariedEmployee salarEm) {
		// TODO Auto-generated method stub
		return salariedmployeeRepo.save(salarEm).toString()+" . Successfully saved";

	}

	public List<SalariedEmployee> getSalariedEmpList() {
		// TODO Auto-generated method stub
		return salariedmployeeRepo.findAll();
	}

	public SalariedEmployee findSalarEmpById(Long id) {
		// TODO Auto-generated method stub
		Optional<SalariedEmployee> salarieEmp =  salariedmployeeRepo.findById(id);
		if (Optional.ofNullable(salarieEmp).isPresent())
			return salarieEmp.get();
		return null;

	}

	//Find the three highest Hourly Employees
	public List<HourlyEmployee> getThreeHighestHourlyEmp() {
		List<HourlyEmployee> listOfSalEmp = hourlyEmpRepo.findAll();
		List<HourlyEmployee> empl = (List<HourlyEmployee>) listOfSalEmp.stream().sorted(Comparator.comparingDouble(HourlyEmployee::getPayment)).collect(Collectors.toList());

		return empl;
	}
}
