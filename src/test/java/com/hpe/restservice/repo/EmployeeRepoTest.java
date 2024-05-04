package com.hpe.restservice.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRepoTest {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
}
