package com.employees.checkpoint_project.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employees.checkpoint_project.model.Employee;
import com.employees.checkpoint_project.service.EmployeeService;

import jakarta.validation.Valid;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> listEmployees(){
        try{
            List<Employee>listEmployees = new ArrayList<Employee>();
            employeeService.getAllEmployee().forEach(listEmployees::add);
            return new ResponseEntity<>(listEmployees, HttpStatus.OK);

        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @PostMapping("/employees")
    public ResponseEntity<?> ceateEmployee(@Valid @RequestBody Employee employee, BindingResult result){
        List<ObjectError> errors =  result.getAllErrors();
        if (!errors.isEmpty()) {
            return employeeService.getAllErrors(errors);
        }
            
        try{
            Employee res = employeeService.createEmployee(employee);
            if(employeeService.getEmployeeById(employee.getId()) != null){
                return new ResponseEntity<>("Employee with ID already exists", HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
            
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable (value = "id") long id , @RequestBody Employee employee){
        try {
            Employee res = employeeService.updateEmplyee(employee,id);
            if( res == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Eployee not found");
            return new ResponseEntity<>(res, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @GetMapping("employees/{email}")
    public ResponseEntity<List<Employee>> getByEmail(@PathVariable String email){
        try{
            List<Employee> res = employeeService.getEmployeeByEmail(email);
            System.out.print(res);
            return new ResponseEntity<List<Employee>>(res, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
    }

}
