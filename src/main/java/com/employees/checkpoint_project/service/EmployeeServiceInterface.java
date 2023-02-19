package com.employees.checkpoint_project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import com.employees.checkpoint_project.model.Employee;

public interface EmployeeServiceInterface {

    List<Employee> getAllEmployee();

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(long id);

    Employee updateEmplyee(Employee employee, long id);

    List<Employee> getEmployeeByEmail(String email);

    ResponseEntity<?>getAllErrors(List<ObjectError> errors);


}
