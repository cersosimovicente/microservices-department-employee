package com.microservice.department.controller;

import com.microservice.department.entity.Department;
import com.microservice.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        Department department = departmentService.findDepartmentById(id);
        if (department == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(department);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveDepartment(Department department) {
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }



}
