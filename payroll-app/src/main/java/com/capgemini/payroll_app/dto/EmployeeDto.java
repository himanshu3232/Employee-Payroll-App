package com.capgemini.payroll_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDto{
    private String name;
    private double salary;
}
