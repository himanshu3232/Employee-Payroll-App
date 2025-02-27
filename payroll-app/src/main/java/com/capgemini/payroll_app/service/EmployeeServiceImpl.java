package com.capgemini.payroll_app.service;

import com.capgemini.payroll_app.dto.EmployeeDto;
import com.capgemini.payroll_app.dto.EmployeeDtoMapper;
import com.capgemini.payroll_app.entity.Employee;
import com.capgemini.payroll_app.exception.EmployeeAlreadyExistsException;
import com.capgemini.payroll_app.exception.EmployeeNotFoundException;
import com.capgemini.payroll_app.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Profile({"dev", "prod"})
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeDto addEmployee(Employee employee){
        if(employeeRepository.findById(employee.getId()).isPresent()){
            log.error("Employee already exists!");
            throw new EmployeeAlreadyExistsException("Employee already exists");
        }
        log.info("Employee saved to database");
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.mapToEmployeeDto(savedEmployee);
    }

    public EmployeeDto getEmployee(Long id){
        log.info("Find employee with id : {}", id);
        if(id < 1){
            log.error("id : {} is less than 1", id);
            throw new IllegalArgumentException("Invalid ID");
        }
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id : " + id));
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    public EmployeeDto updateEmployee(Employee employee){
        if(employee == null){
            //throw new NullObjectException("Employee to be updated is null");
        }
        log.info("Employee: {} to be updated", employee);
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.mapToEmployeeDto(updatedEmployee);
    }

    public void  deleteEmployee(Long id){
        if(id < 1){
            throw new IllegalArgumentException("Invalid ID");
        }
        log.info("Employee with id : {} to be deleted", id);
        employeeRepository.deleteById(id);
    }
}
