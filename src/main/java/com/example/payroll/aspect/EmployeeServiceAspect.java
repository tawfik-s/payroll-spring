package com.example.payroll.aspect;


import com.example.payroll.repository.EmployeeRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.payroll.entity.Employee;

import javax.validation.ConstraintViolationException;
import java.util.Collections;


@Aspect
@Component
public class EmployeeServiceAspect {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before("execution(public * com.example.payroll.service.EmployeeServiceImpl.addEmployee(..))")
    public void CheckNoRedundancyForName(JoinPoint joinPoint){
        System.out.println("from CheckNoRedundancyForName before method");
        Object args[]=joinPoint.getArgs();

        for(Object x:args){
            System.out.println(x);
            if(x instanceof Employee){
                Employee employee=(Employee)x;
                Employee foundEmployee=employeeRepository.findFirstByName(employee.getName());
                if(foundEmployee!=null){
                    System.out.println("first name needs to be unique");
                    throw new ConstraintViolationException("first name needs to be unique", Collections.emptySet());
                }
            }

        }

    }
}
