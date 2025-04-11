package com.examplerest.salariedemprepo;

import com.examplerest.entities.SalariedEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalariedEmployeeRepo extends JpaRepository<SalariedEmployee, Long> {
	

}
