package com.gsaviop.proj.services;

import com.gsaviop.proj.model.Employee;

import java.util.List;

public interface EmployeeServices {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
}
