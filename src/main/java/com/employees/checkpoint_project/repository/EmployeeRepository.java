package com.employees.checkpoint_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employees.checkpoint_project.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    
    List<Employee> findByEmail(String email);
}
