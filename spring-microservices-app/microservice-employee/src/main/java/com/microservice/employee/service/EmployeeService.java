package com.microservice.employee.service;

import com.microservice.employee.clients.DepartmentClient;
import com.microservice.employee.dto.EmployeeDetailsDTO;
import com.microservice.employee.entity.Employee;
import com.microservice.employee.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private DepartmentClient departmentClient;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

  public EmployeeDetailsDTO getEmployeeWithDepartment(Long employeeId) {
    var employee = employeeRepository.findById(employeeId).orElseThrow(()->new EntityNotFoundException("Employee not found"));
    var department = departmentClient.getDepartmentById(employee.getDepartmentCode());
    return new EmployeeDetailsDTO(employee, department);
  }

}
