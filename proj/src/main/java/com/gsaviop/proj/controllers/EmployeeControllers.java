package com.gsaviop.proj.controllers;

import com.gsaviop.proj.model.Employee;
import com.gsaviop.proj.services.EmployeeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeControllers {
    private EmployeeServices employeeServices;

    public EmployeeControllers(EmployeeServices employeeServices) {
        super();
        this.employeeServices = employeeServices;
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeServices.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeServices.getAllEmployees();
    }
}
