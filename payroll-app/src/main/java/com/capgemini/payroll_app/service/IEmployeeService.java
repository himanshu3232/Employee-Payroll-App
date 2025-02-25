package com.capgemini.payroll_app.service;

import com.capgemini.payroll_app.dto.EmployeeDto;
import com.capgemini.payroll_app.entity.Employee;

public interface IEmployeeService {
    EmployeeDto addEmployee(Employee employee);
    EmployeeDto getEmployee(Long id);
    EmployeeDto updateEmployee(Employee employee);
    void  deleteEmployee(Long id);
    
}
