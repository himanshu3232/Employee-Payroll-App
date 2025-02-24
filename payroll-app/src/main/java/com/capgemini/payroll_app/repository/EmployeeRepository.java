package com.capgemini.payroll_app.repository;

import com.capgemini.payroll_app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
