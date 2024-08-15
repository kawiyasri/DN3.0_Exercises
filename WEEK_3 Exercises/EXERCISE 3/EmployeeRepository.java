package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find all employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Find employee by email
    Employee findByEmail(String email);
}
