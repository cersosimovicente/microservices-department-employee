package com.microservice.employee.controller;

import com.microservice.employee.entity.Employee;
import com.microservice.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Employee  employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(employee);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }


}
