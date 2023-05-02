package com.labs.employeeservice.service;

import com.labs.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClients {

    @GetMapping("/api/departments/{department-code}")
    DepartmentDTO getDepartment(@PathVariable("department-code") String departmentCode);
}