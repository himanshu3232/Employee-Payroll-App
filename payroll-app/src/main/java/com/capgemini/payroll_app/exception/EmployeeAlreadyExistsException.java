package com.capgemini.payroll_app.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
        log.error(message);
    }
}
