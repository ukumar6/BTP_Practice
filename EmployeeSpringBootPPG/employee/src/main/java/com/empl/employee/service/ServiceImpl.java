package com.empl.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.empl.employee.repo.EmployeeRepo;
import com.empl.employee.exception.ResourceNotFoundException;
import com.empl.employee.model.Employee;

@Service
public class ServiceImpl implements IService {
    @Autowired
    private EmployeeRepo repo;

    // Get One
    @Override
    public Employee getEmployee(int ecode) {
        return this.repo.findById(ecode)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + ecode));
    }

    // Get All
    @Override
    public List<Employee> getEmployees() {
        List<Employee> findAll = repo.findAll();
        return findAll;
    }

    // Create
    @Override
    public Employee createEmployee(Employee employee) {
        repo.save(employee);
        return employee;
    }

    // Delete
    @Override
    public ResponseEntity<Employee> deleteEmployee(int ecode) {
        Employee existingUser = this.repo.findById(ecode)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + ecode));

        this.repo.delete(existingUser);

        return ResponseEntity.ok().build();
    }

    // Update with provided parameters
    @Override
    public Employee updateEmployee(int ecode, Employee employee) {
        return this.repo.findById(ecode)
                .map(empl -> {

                    System.out.println(employee.getEfirstname());
                    if (null == employee.getEfirstname()) {
                        System.out.println(employee.getEfirstname());
                    } else {
                        empl.setEfirstname(employee.getEfirstname());
                    }
                    if (null == employee.getEmiddlename()) {
                        System.out.println(employee.getEmiddlename());
                    } else {
                        empl.setEmiddlename(employee.getEmiddlename());
                    }
                    if (null == employee.getEdob()) {
                        System.out.println(employee.getEdob());
                    } else {
                        empl.setEdob(employee.getEdob());
                    }
                    if (null == employee.getEdoj()) {
                        System.out.println(employee.getEdoj());
                    } else {
                        empl.setEdoj(employee.getEdoj());
                    }
                    if (null == employee.getElastname()) {
                        System.out.println(employee.getElastname());
                    } else {
                        empl.setElastname(employee.getElastname());
                    }
                    if (null == employee.getEgender()) {
                        System.out.println(employee.getEgender());
                    } else {
                        empl.setEgender(employee.getEgender());
                    }
                    return repo.save(empl);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + ecode));
    }

}
