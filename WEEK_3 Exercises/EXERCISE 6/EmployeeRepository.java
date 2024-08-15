package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by department ID with pagination
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    // Find employees by name containing a specific substring with pagination and sorting
    Page<Employee> findByNameContaining(String keyword, Pageable pageable);
}
