package com.labs.departmentservice.controller;

import com.labs.departmentservice.dto.DepartmentDTO;
import com.labs.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody  DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String departmentCode) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity(departmentDTO, HttpStatus.OK);
    }
}
