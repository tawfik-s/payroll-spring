package com.example.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class PayrollApplication {
//	@Autowired
//	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}


//	@Bean
//	public void insertIntoDataBase(){
//		employeeService.
//
//	}

}
