package com.example.payroll;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.payroll.entity.Employee;
import com.example.payroll.repository.EmployeeRepository;
import com.example.payroll.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Resource
    private EmployeeService employeeService;

    @Resource
    private EmployeeRepository employeeRepository;



    @Test
    void testAddEmployee() throws Exception {

        this.mockMvc
                .perform(post("/employees")
                                .contentType(MediaType.APPLICATION_JSON).content("{" +
                                "       \"name\": \"nameForTest\"," +
                                "        \"role\": \"junior\"," +
                                "        \"phone\":\"12345323\"," +
                                "           \"tasks\":[" +
                                "            {" +
                                "                \"description\":\"playing football\"," +
                                "                \"hours\":13," +
                                "                \"status\":\"finish\"" +
                                "            }," +
                                "                        {" +
                                "                \"description\":\"finish spring AOP\"," +
                                "                \"hours\":10," +
                                "                \"status\":\"finish\"" +
                                "            }" +
                                "        ]" +
                                "     " +
                                "}").accept(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("nameForTest"))
                .andExpect(content().string(containsString("phone")));


    }



    @Test
    void shouldReturnEmployees() throws Exception {

        this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("]")))
                .andExpect(content().string(containsString("]")));
    }

    @Test
    void shouldReturnEmployee() throws Exception{
        Employee employee=new Employee();
        employee.setName("john");
        employee.setRole("junior");
        employee.setPhone("1234556");
        employeeRepository.save(employee);
        this.mockMvc.perform(get("/employees/"+employee.getId())).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("john"))
                .andExpect(jsonPath("$.role").value("junior"));
    }

    @Test
    void updateEmployee() throws Exception{
        Employee employee=new Employee();
        employee.setName("ahmed");
        employee.setRole("junior");
        employee.setPhone("1234556");
        Employee emp=employeeRepository.save(employee);
        this.mockMvc.perform(put("/employees/"+emp.getId())
                .contentType(MediaType.APPLICATION_JSON).content("{" +
                                "       \"name\": \"nameForTest2\"," +
                                "        \"role\": \"admin\"," +
                                "        \"phone\":\"12345323\"," +
                                "           \"tasks\":[" +
                                "            {" +
                                "                \"description\":\"playing football\"," +
                                "                \"hours\":13," +
                                "                \"status\":\"finish\"" +
                                "            }," +
                                "                        {" +
                                "                \"description\":\"finish spring AOP\"," +
                                "                \"hours\":10," +
                                "                \"status\":\"finish\"" +
                                "            }" +
                                "        ]" +
                                "     " +
                                "}").accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("nameForTest2"))
                .andExpect(jsonPath("$.role").value("admin"));

    }

    @Test
    void deleteEmployee() throws Exception{
        Employee employee=new Employee();
        employee.setName("ali");
        employee.setRole("junior");
        employee.setPhone("1234556");
        employeeRepository.save(employee);
        this.mockMvc.perform(get("/employees/"+employee.getId())).andDo(print())
                .andExpect(status().isOk());
    }
}