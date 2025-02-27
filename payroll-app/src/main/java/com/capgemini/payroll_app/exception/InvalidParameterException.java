package com.capgemini.payroll_app.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String message) {
        super(message);
        log.error(message);
    }
}
