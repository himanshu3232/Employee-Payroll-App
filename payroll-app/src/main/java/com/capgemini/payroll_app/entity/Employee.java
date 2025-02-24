package com.capgemini.payroll_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    public Employee(double salary, String name, Long id) {
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    private Employee(){}

    
}
