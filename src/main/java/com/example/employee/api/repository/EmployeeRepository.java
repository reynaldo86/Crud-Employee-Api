package com.example.employee.api.repository;

import com.example.employee.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
