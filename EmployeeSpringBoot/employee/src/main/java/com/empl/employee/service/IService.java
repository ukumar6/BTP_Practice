package com.empl.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.empl.employee.model.Employee;

public interface IService {

    public Employee getEmployee(int eCode);

    List<Employee> getEmployees();

    Employee createEmployee(Employee employee);

    ResponseEntity<Employee> deleteEmployee(int eCode);

    Employee updateEmployee(int ecode, Employee employee);

}
