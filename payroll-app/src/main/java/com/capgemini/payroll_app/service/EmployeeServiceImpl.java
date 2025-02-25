package com.capgemini.payroll_app.service;

import com.capgemini.payroll_app.dto.EmployeeDto;
import com.capgemini.payroll_app.dto.EmployeeDtoMapper;
import com.capgemini.payroll_app.entity.Employee;
import com.capgemini.payroll_app.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(){}

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto addEmployee(Employee employee){
        log.info("Employee saved to database");
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.mapToEmployeeDto(savedEmployee);
    }

    public EmployeeDto getEmployee(Long id){
        if(id < 1){
            log.error("id : {} is less than 1", id);
            throw new IllegalArgumentException("Invalid ID");
        }
        log.info("Find employee with id : {}", id);
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    public EmployeeDto updateEmployee(Employee employee){
        if(employee == null){
            log.warn("Employee to be updated is null");
            return null;
        }
        log.info("Employee: {} to be updated", employee);
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.mapToEmployeeDto(updatedEmployee);
    }

    public void  deleteEmployee(Long id){
        log.info("Employee with id : {} to be deleted", id);
        employeeRepository.deleteById(id);
    }
}
