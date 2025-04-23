package com.examplerest.service;

import com.examplerest.entities.HourlyEmployee;
import com.examplerest.hourlyemprepo.HourlyRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HourlyEmpServiceTest {

    @Mock
    private HourlyRepo hourlyRepo;

    @InjectMocks
    private HourlyEmpService hourlyEmpService;

    @Test
    void testGetTheHourEmpById(){
        Mockito.when(hourlyRepo.findById(1L)).thenReturn(Optional.of(new HourlyEmployee(1L, "Moha", "Hourly",
                                                    "Department IT", 50, 40)));

        HourlyEmployee hoursWorked = hourlyEmpService.getTheHourEmpById(1L);

                assertEquals(40.0,hoursWorked.getHoursWorked());
                assertEquals("Hourly",hoursWorked.getType());
    }


}
