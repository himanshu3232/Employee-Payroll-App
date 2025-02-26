package com.capgemini.payroll_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PayrollAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollAppApplication.class, args);
	}
}
