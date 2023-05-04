package com.labs.departmentservice.service;

import com.labs.departmentservice.dto.DepartmentDTO;
import com.labs.departmentservice.entity.Department;
import com.labs.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDTO savedDepartmentDto = new DepartmentDTO(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );

        return savedDepartmentDto;
    }

    public DepartmentDTO getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan!"));

        DepartmentDTO departmentDTO = new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDTO;
    }
}
