package com.example.payroll.controller;

import java.util.List;

import com.example.payroll.entity.Employee;
import com.example.payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

@RestController
class EmployeeController {

    private EmployeeService employeeService;


    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employees")
    List<Employee> index() {

        return employeeService.getEmployees();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee, HttpServletResponse httpResponse,
                         WebRequest request) {
        Employee emp=employeeService.addEmployee(newEmployee);
        System.out.println(emp);
        if(emp==null){
            httpResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        httpResponse.setStatus(HttpStatus.CREATED.value());
        httpResponse.setHeader("Location", String.format("%s/employees/%s",
                request.getContextPath(), emp.getId()));
        return emp;
    }



    // Single item

    @GetMapping("/employees/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }


    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
      return  employeeService.updateEmployee(newEmployee,id);
    }


    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}