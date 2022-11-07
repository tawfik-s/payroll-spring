package com.example.payroll.repository.handlers;


import com.example.payroll.model.Employee;
import com.example.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
@RepositoryEventHandler
public class EmployeeEventHandler {
    @Autowired
    private EmployeeRepository employeeRepository;

//    @HandleBeforeCreate
    @HandleBeforeSave(Employee.class)
    public void handleEmployeeCreate(Employee employee){

        Employee foundEmployee=employeeRepository.findFirstByName(employee.getName());
        if(foundEmployee!=null){
            System.out.println("first name needs to be unique");
            throw new ConstraintViolationException("first name needs to be unique", Collections.emptySet());
        }

    }

    @PostConstruct
    public void init() {
        System.out.println("Hello EmployeeEventHandler");
    }
}
