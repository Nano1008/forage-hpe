package com.hpe.restservice.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.hpe.restservice.Employee;
import com.hpe.restservice.EmployeeRepo;
import com.hpe.restservice.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepo employeeRepo;
    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() {
        Employee e1 = new Employee(1, "John", "Doe", "john-doe@email.com", "Software Engineer");
        Employee e2 = new Employee(2, "Jane", "Doe", "jane-doe@email.com", "Software Engineer");

        Mockito.when(employeeRepo.findAll()).thenReturn(List.of(e1, e2));
        var employeeList = employeeService.getAllEmployees();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);

    }

    @Test
    public void testAddEmployee() {
        Employee e = new Employee(1, "John", "Do", "john-do@email.com", "Software Engineer");
        Mockito.when(employeeRepo.save(e)).thenReturn(e);
        var employee = employeeService.addEmployee(e);
        assertThat(employee).isNotNull();
        assertThat(employee.getFirstName()).isEqualTo("John");
    }
}
