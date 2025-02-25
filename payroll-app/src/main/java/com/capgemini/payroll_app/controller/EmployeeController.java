package com.capgemini.payroll_app.controller;

import com.capgemini.payroll_app.dto.EmployeeDto;
import com.capgemini.payroll_app.entity.Employee;
import com.capgemini.payroll_app.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public EmployeeController(){}

    @PostMapping("/post")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee employee){
        log.debug("Post request hit to post employee : {}", employee);
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        log.debug("Get request hit to get employee with id : {}", id);
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody Employee employee){
        log.debug("Put request hit to update employee");
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
        log.debug("Delete request hit to delete employee with id : {}", id);
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
