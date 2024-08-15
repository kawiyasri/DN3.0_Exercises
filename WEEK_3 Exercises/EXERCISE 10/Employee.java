package com.example.employeemanagementsystem.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "created_at")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime updatedAt;

    // Getters and Setters
}
