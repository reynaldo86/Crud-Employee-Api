package com.example.employee.api.service;

import com.example.employee.api.model.Employee;
import com.example.employee.api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
