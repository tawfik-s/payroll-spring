package com.example.payroll;

import com.example.payroll.model.Employee;
import com.example.payroll.repository.EmployeeRepository;
import com.example.payroll.repository.handlers.EmployeeEventHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (EmployeeRepository repository){
		return (args)->{
			repository.save(new Employee("tawfeek","admin"));
			repository.save(new Employee("mohammed","manger"));
			repository.save(new Employee("ali","product manger"));
		};
	}


	@Bean
	EmployeeEventHandler employeeEventHandler(){
		return new EmployeeEventHandler();
	}

}
