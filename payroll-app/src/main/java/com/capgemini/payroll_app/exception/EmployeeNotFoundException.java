package com.capgemini.payroll_app.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}
