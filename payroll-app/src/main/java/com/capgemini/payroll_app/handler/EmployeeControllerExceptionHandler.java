package com.capgemini.payroll_app.handler;

import com.capgemini.payroll_app.controller.EmployeeController;
import com.capgemini.payroll_app.exception.EmployeeAlreadyExistsException;
import com.capgemini.payroll_app.exception.EmployeeNotFoundException;
import com.capgemini.payroll_app.exception.InvalidParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {EmployeeController.class})
@Slf4j
public class EmployeeControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgsException(IllegalArgumentException exception){
        log.trace("IllegalArgumentException handled");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException exception){
        log.trace("EmployeeAlreadyException handled");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<Object> handleInvalidParameterException(InvalidParameterException exception){
        log.trace("InvalidParameterException handled");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception){
        log.trace("EmployeeNotException handled");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception exception){
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
