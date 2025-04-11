package com.examplerest.hourlyemprepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examplerest.entities.HourlyEmployee;

@Repository
public interface HourlyRepo extends JpaRepository<HourlyEmployee, Long>{

}
