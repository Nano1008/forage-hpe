package com.hpe.restservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping(path = "/employees")
    public Employees getEmployees() {
        return employeeManager.getAllEmployees();
    }

    @PostMapping(path = "/employees")
    public ResponseEntity<Object> addEmployee (@RequestBody Employee employee) {
        Integer id = employeeManager.getAllEmployees().getEmployees().size() + 1;
        employee.setId(id);
        employeeManager.addEmployee(employee);
        return ResponseEntity.ok().build();
    }
}
