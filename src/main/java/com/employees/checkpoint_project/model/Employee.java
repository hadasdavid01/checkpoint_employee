package com.employees.checkpoint_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name= "id", unique = true)
    private long id;

    @Column(name = "firstName")
    @NotBlank(message = "First name cant be blank")
    private String firstName;

    
    @Column(name = "lastName")
    @NotBlank(message = "Last name cant be blank")
    private String lastName;
    
    @Column(name = "email")
    @NotBlank(message = "Email is required")
    @Email(message = "Email without correct format")
    private String email;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
