package com.gsaviop.proj.services.impl;

import com.gsaviop.proj.exceptions.NotFoundException;
import com.gsaviop.proj.model.Employee;
import com.gsaviop.proj.repository.EmployeeRepository;
import com.gsaviop.proj.services.EmployeeServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
    private EmployeeRepository employeeRepository;

    public EmployeeServicesImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> filteredEmployee = employeeRepository.findById(id);

        if (filteredEmployee.isPresent()) {
            return filteredEmployee.get();
        } else {
            throw new NotFoundException("Employee", "id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Employee", "id", id));

        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAddress(employee.getAddress());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Employee", "id", id));

        employeeRepository.deleteById(id);
    }
}
