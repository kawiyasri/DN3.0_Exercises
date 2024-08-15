package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Use named query to find a department by name
    @Query(name = "Department.findByName")
    Department getDepartmentByName(String name);

    // Use named query to get all departments
    @Query(name = "Department.findAllDepartments")
    List<Department> getAllDepartments();
}
