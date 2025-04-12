package com.examplerest.service;

import com.examplerest.entities.Employee;
import com.examplerest.entities.SalariedEmployee;
import com.examplerest.exception.ResourceNotFoundException;
import com.examplerest.salariedemprepo.SalariedEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        else
            throw new ResourceNotFoundException("Resource with id : "+id+ " is Not found");

    }
}
