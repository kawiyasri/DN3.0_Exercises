package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Find an employee by email
    Employee findByEmail(String email);

    // Find employees by name containing a specific substring
    List<Employee> findByNameContaining(String keyword);

    // Find employees who joined after a certain date
    List<Employee> findByJoinDateAfter(Date date);
}

