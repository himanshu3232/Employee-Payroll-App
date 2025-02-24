package com.capgemini.payroll_app.service;

import com.capgemini.payroll_app.dto.EmployeeDto;
import com.capgemini.payroll_app.dto.EmployeeDtoMapper;
import com.capgemini.payroll_app.entity.Employee;
import com.capgemini.payroll_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(){}

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto addEmployee(Employee employee){
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.mapToEmployeeDto(savedEmployee);
    }

    public EmployeeDto getEmployee(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    public EmployeeDto updateEmployee(Employee employee){
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.mapToEmployeeDto(updatedEmployee);
    }

    public void  deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
