package com.microservice.employee.dto;

import com.microservice.employee.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDetailsDTO {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentName;

    public EmployeeDetailsDTO(Employee employee, DepartmentDto department) {
        this.employeeId = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.departmentName = department.getName();
    }
}
