package com.examplerest.service;

import com.examplerest.entities.HourlyEmployee;
import com.examplerest.exception.ResourceNotFoundException;
import com.examplerest.hourlyemprepo.HourlyRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateOperations;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HourlyEmpService {
	
	@Autowired
	private HourlyRepo hourlyEmpRepo;



	public HourlyEmployee getHighesPaidHourlyEmp() {
		List<HourlyEmployee> listOfSalEmp = hourlyEmpRepo.findAll();
		Optional<HourlyEmployee> emp = listOfSalEmp.stream().max(Comparator.comparingDouble(HourlyEmployee::getPayment));
		System.out.println(emp.get().getPayment());
		if (emp.isPresent())
			return emp.get();
		else
			return null;
	}

	public ResponseEntity<HourlyEmployee> saveHourlyEmp(HourlyEmployee hourlemp) {
		
		HourlyEmployee savedHourly= hourlyEmpRepo.save(hourlemp);
		 return ResponseEntity.status(HttpStatus.CREATED).body(savedHourly);
		
	}


	//Find the three highest Hourly Employees
	public List<HourlyEmployee> getThreeHighestHourlyEmp() {
		List<HourlyEmployee> listOfSalEmp = hourlyEmpRepo.findAll();
		List<HourlyEmployee> empl = listOfSalEmp.stream().sorted(Comparator.comparingDouble(HourlyEmployee::getPayment)).
				limit(3).collect(Collectors.toList());
		if (empl!=null)
			return empl;
		else
			throw new ResourceNotFoundException("List is less than 3 elements");

	}

	public HourlyEmployee getTheHourEmpById(Long id) {

		return  hourlyEmpRepo.findById(id).orElseThrow(()->
			 new ResourceNotFoundException("Resource with Id: " + id + " is Not Found"));

	}



	public ResponseEntity<Void> deleteHourlById(Long id) {
		hourlyEmpRepo.deleteById(id);
		return ResponseEntity.noContent().build();//204 no content

	}

	public HourlyEmployee updateHourlyEmp(Long id, HourlyEmployee hourlyEmployee) {
		Optional<HourlyEmployee> hremp = hourlyEmpRepo.findById(id);
		if (hremp.isPresent()){
			hremp.get().setDepartment(hourlyEmployee.getDepartment());
			hremp.get().setHourlyWorked(hourlyEmployee.getHourlyWorked());
			hremp.get().setName(hourlyEmployee.getName());
			return  hourlyEmpRepo.save(hremp.get());
		}else
			throw new ResourceNotFoundException("Entity with id :"+id+" is not found .");
	}
}
