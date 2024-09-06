package com.microservice.employee.clients;

import com.microservice.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MICROSERVICE-DEPARTMENT")
public interface DepartmentClient {
    @GetMapping("/api/departments/{id}")
    DepartmentDto getDepartmentById(@PathVariable Long id);
}
