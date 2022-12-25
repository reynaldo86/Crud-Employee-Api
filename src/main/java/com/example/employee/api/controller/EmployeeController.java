package com.example.employee.api.controller;

import com.example.employee.api.dto.EmployeeDto;
import com.example.employee.api.model.Employee;
import com.example.employee.api.repository.EmployeeRepository;
import com.example.employee.api.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/employee")
public class EmployeeController {
    final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService,
                              EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }
    //Create
    @PostMapping
    public ResponseEntity<Object> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        var employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }
    //Get All
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
    }

    //Get One
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEmployee(@PathVariable (value = "id") UUID id){
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if(!employeeOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found..");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeOptional.get());
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable (value = "id") UUID id) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found..");
        }
        employeeService.delete(employeeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successufully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable (value = "id")UUID id, @RequestBody @Valid EmployeeDto employeeDto){
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found..");
        }
        var employee = employeeOptional.get();
        employee.setName(employeeDto.getName());
        employee.setAge(employee.getAge());
        employee.setSexo(employee.getSexo());
        employee.setOffice(employee.getOffice());
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.save(employee));
    }


}
