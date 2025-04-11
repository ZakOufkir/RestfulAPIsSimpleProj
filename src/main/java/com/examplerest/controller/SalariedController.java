package com.examplerest.controller;

import java.util.List;

import com.examplerest.entities.SalariedEmployee;
import com.examplerest.service.MyEmpService;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/slaried")
public class SalariedController {

    @Autowired
    MyEmpService employeeSvc;

    @PostMapping("/save")
    public String saveSalariedEmp(@RequestBody SalariedEmployee salarEm) {

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
}
