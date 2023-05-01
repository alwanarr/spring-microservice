package com.labs.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String departmentCode;
    private String departmentDescription;
    private String departmentName;
}
