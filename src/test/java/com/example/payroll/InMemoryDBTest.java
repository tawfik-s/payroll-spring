package com.example.payroll;

import com.example.payroll.entity.Employee;
import com.example.payroll.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class InMemoryDBTest {

    @Resource
    private EmployeeRepository employeeRepository;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        Employee employee = new Employee();
        employee.setName("tawfeek");
        employee.setRole("admin");
        employee.setPhone("1234556");
        employeeRepository.save(employee);

        Employee employee2 = employeeRepository.findById(employee.getId()).get();
        assertEquals("tawfeek", employee2.getName());
    }
}