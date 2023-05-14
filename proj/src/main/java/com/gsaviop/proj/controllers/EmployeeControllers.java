package com.gsaviop.proj.controllers;

import com.gsaviop.proj.model.Employee;
import com.gsaviop.proj.services.EmployeeServices;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Employee>(employeeServices.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeServices.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")Integer id) {
        employeeServices.deleteEmployee(id);

        return new ResponseEntity<String>("Employee with ID " + id + " deleted!", HttpStatus.OK);
    }
}
