package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Method to execute named query by department name
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    // Method to execute named query for partial email match
    List<Employee> findByPartialEmail(@Param("email") String email);
}
