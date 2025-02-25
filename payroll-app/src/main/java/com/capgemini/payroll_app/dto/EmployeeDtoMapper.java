package com.capgemini.payroll_app.dto;

import com.capgemini.payroll_app.entity.Employee;

public class EmployeeDtoMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(employee.getName(), employee.getSalary());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee =  new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }
}
