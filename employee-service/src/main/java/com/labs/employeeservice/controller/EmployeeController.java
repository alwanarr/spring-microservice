package com.labs.employeeservice.controller;

import com.labs.employeeservice.dto.ApiResponseDTO;
import com.labs.employeeservice.dto.DepartmentDTO;
import com.labs.employeeservice.dto.EmployeeDTO;
import com.labs.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO saveEmployee = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{employeId}")
    public ResponseEntity<ApiResponseDTO> getEmployeeById(@PathVariable("employeId") Long employeeId) {
        ApiResponseDTO employeeById = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity(employeeById, HttpStatus.OK);
    }
}
