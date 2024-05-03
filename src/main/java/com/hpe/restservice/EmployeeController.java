package com.hpe.restservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping(path = "/employees")
    public Employees getEmployees() {
        return employeeManager.getAllEmployees();
    }
}
