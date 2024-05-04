package com.hpe.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() throws Exception {
        Employee e1 = new Employee(1, "John", "Doe", "john-doe@email.com", "Manager");
        Employee e2 = new Employee(2, "Jane", "Doe", "jane-doe@email.com", "Developer");
        List<Employee> employees = new ArrayList<>(Arrays.asList(e1, e2));

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is("John")));
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee newEmployee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john-doe@email.com")
                .title("Manager")
                .build();
        Mockito.when(employeeService.addEmployee(newEmployee)).thenReturn(newEmployee);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(newEmployee));

        mockMvc.perform(mockRequest).andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.firstName", is("John")));

    }
}
