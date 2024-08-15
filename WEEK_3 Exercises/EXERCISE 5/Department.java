package com.example.employeemanagementsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "Department.findByName",
        query = "SELECT d FROM Department d WHERE d.name = :name"
    ),
    @NamedQuery(
        name = "Department.findAllDepartments",
        query = "SELECT d FROM Department d"
    )
})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    // Getters and Setters
}
