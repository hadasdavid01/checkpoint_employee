package com.employees.checkpoint_project.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.checkpoint_project.model.Employee;
import com.employees.checkpoint_project.repository.EmployeeRepository;


@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
       Optional<Employee> employee = employeeRepository.findById(id);
       if(employee.isPresent()){
        return employee.get();
       } else{
        return null;
       }
    }

    @Override
    public Employee updateEmplyee(Employee employee, long id) {
        Employee res = getEmployeeById(id);
        if(res != null){
            if(employee.getFirstName() != null)
                res.setFirstName(employee.getFirstName());
            if(employee.getLastName() != null)
                res.setLastName(employee.getLastName());
            if(employee.getEmail() != null)
                res.setEmail((employee.getEmail()));
            return employeeRepository.save(res);
        }else{
            return null;
        }
        
    }

    @Override
    public List<Employee> getEmployeeByEmail(String email) {
        System.out.print(email);
        List<Employee> employee = employeeRepository.findByEmail(email);
        System.out.print(employee);
        return employee;
    }

    

}
