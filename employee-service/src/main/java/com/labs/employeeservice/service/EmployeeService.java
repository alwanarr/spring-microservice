package com.labs.employeeservice.service;

import com.labs.employeeservice.dto.ApiResponseDTO;
import com.labs.employeeservice.dto.DepartmentDTO;
import com.labs.employeeservice.dto.EmployeeDTO;
import com.labs.employeeservice.entity.Employee;
import com.labs.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final RestTemplate restTemplate;

    private APIClients apiClients;

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO savedEmployeeDTO = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDTO;
    }

    public ApiResponseDTO getEmployeeById(Long id){
        Employee getEmployeeById = employeeRepository
                                            .findById(id)
                                            .orElseThrow(() -> new RuntimeException("Employee not found with id : " + id));
//        String url = "http://localhost:8080/api/departments/";
//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity(url + getEmployeeById.getDepartmentCode()
//                , DepartmentDTO.class);

        DepartmentDTO departmentDto = apiClients.getDepartment(getEmployeeById.getDepartmentCode());

        EmployeeDTO employeeDTO = new EmployeeDTO(
                getEmployeeById.getId(),
                getEmployeeById.getFirstName(),
                getEmployeeById.getLastName(),
                getEmployeeById.getEmail(),
                getEmployeeById.getDepartmentCode()
        );

//        DepartmentDTO departmentDto = responseEntity.getBody();

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDto);

        return apiResponseDTO;
    }
}
