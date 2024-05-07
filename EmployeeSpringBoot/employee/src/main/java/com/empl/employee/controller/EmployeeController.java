package com.empl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empl.employee.service.ServiceImpl;
import com.empl.employee.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private ServiceImpl service;

    // Find All
    @GetMapping("/findall")
    public List<Employee> findAll() {
        return service.getEmployees();
    }

    // Find One
    @GetMapping("/findemp/{ecode}")
    public Employee findAll(@PathVariable int ecode) {
        return service.getEmployee(ecode);
    }

    // Create
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    // Delete
    @DeleteMapping("/deleteemp/{ecode}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int ecode) {
        return service.deleteEmployee(ecode);
    }

    // Update
    @PutMapping("/updateemp/{ecode}")
    public Employee updateEmployee(@PathVariable int ecode, @RequestBody Employee employee) {
        return service.updateEmployee(ecode, employee);
    }

}
