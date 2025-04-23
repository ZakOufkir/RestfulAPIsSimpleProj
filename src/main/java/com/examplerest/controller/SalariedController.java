package com.examplerest.controller;

import java.util.List;
import java.util.Optional;

import com.examplerest.entities.SalariedEmployee;
import com.examplerest.service.HourlyEmpService;
import com.examplerest.service.SalariedEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/salaried")
public class SalariedController {

    @Autowired
    SalariedEmployeeService employeeSvc;

    @PostMapping("/save")
    public ResponseEntity<SalariedEmployee> saveSalariedEmp(@RequestBody SalariedEmployee salarEm) {

        return employeeSvc.saveSlariedEmp(salarEm);
    }

    @GetMapping("/list")
    public List<SalariedEmployee> getListSalariedEmpl() {
        return employeeSvc.getSalariedEmpList();
    }

    @GetMapping("/{id}")
    public SalariedEmployee getSalariedById(@PathVariable Long id) {
        return employeeSvc.findSalarEmpById(id);
    }

    @GetMapping("/richSalaried")
    public SalariedEmployee getHighestPaidSalariedEmp() throws Exception {
        return employeeSvc.getRichestSalariedEmp();
    }
}
