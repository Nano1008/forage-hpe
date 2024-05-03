package com.hpe.restservice;

import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {
    private static Employees employees = new Employees();

    static {
        employees.getEmployees().add(new Employee(1, "John", "Doe", "john-doe@email.com", "Software Engineer"));
        employees.getEmployees().add(new Employee(2, "Jane", "Doe", "jane-doe@email.com", "Software Engineer"));
        employees.getEmployees().add(new Employee(3, "John", "Smith", "john-smith@emai.com", "Software Engineer"));
    }

    public Employees getAllEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.getEmployees().add(employee);
    }
}
