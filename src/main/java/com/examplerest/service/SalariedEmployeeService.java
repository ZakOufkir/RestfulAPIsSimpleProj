package com.examplerest.service;

import com.examplerest.entities.Employee;
import com.examplerest.entities.SalariedEmployee;
import com.examplerest.exception.IllegalArgumentsException;
import com.examplerest.exception.ResourceNotFoundException;
import com.examplerest.salariedemprepo.SalariedEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SalariedEmployeeService {


    @Autowired
    private SalariedEmployeeRepo salariedmployeeRepo;




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


    public ResponseEntity<SalariedEmployee> saveSlariedEmp(SalariedEmployee salarEm) {
        // TODO Auto-generated method stub
        SalariedEmployee salEmp = salariedmployeeRepo.save(salarEm);
            return ResponseEntity.status(HttpStatus.CREATED).body(salEmp);
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
        else
            throw new ResourceNotFoundException("Resource with id : "+id+ " is Not found");

    }

    public SalariedEmployee  getRichestSalariedEmp() throws Exception {
        List<SalariedEmployee> allSalaried = salariedmployeeRepo.findAll();
            if (allSalaried.size()>2) {
                Optional<SalariedEmployee> salaEm = allSalaried.stream().max(Comparator.comparingDouble(SalariedEmployee::getSalary));
                return salaEm.get();
            }else
                throw new IllegalArgumentsException("Can't do highest salary on salaried Employees :");

    }
}
