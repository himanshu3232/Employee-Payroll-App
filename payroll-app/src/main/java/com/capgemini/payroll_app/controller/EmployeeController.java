package com.capgemini.payroll_app.controller;

import com.capgemini.payroll_app.dto.EmployeeDto;
import com.capgemini.payroll_app.entity.Employee;
import com.capgemini.payroll_app.exception.InvalidParameterException;
import com.capgemini.payroll_app.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        log.trace("EmployeeServiceImpl bean initialized");
        this.employeeService = employeeService;
    }

    @PostMapping("/post")
    public ResponseEntity<EmployeeDto> addEmployee
            (@RequestBody @Valid Employee employee
                    , BindingResult bindingResult){
        log.debug("Post request hit to post employee : {}", employee);
        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                log.error(error.getDefaultMessage());
            }
            throw new InvalidParameterException("Employee validation failed!");
        }
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        log.debug("Get request hit to get employee with id : {}", id);
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee
            (@RequestBody @Valid Employee employee
                    , BindingResult bindingResult){
        log.debug("Put request hit to update employee");
        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                log.error(error.getDefaultMessage());
            }
            throw new InvalidParameterException("Employee validation failed!");
        }
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
        log.debug("Delete request hit to delete employee with id : {}", id);
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
