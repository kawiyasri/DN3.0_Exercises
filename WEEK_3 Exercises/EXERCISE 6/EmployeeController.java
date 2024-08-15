package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get employees by department with pagination
    @GetMapping("/department/{departmentId}")
    public Page<Employee> getEmployeesByDepartment(
        @PathVariable Long departmentId,
        @RequestParam int page,
        @RequestParam int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        return employeeService.getEmployeesByDepartment(departmentId, pageable);
    }

    // Search employees by name with pagination and sorting
    @GetMapping("/search")
    public Page<Employee> searchEmployeesByName(
        @RequestParam String keyword,
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam(defaultValue = "name") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDirection) {
        
        Pageable pageable = PageRequest.of(page, size, 
            sortDirection.equalsIgnoreCase("desc") ? 
            org.springframework.data.domain.Sort.by(sortBy).descending() : 
            org.springframework.data.domain.Sort.by(sortBy).ascending());
        
        return employeeService.searchEmployeesByName(keyword, pageable);
    }
}
