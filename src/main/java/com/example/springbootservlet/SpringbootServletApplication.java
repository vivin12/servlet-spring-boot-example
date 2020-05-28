package com.example.springbootservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringbootServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServletApplication.class, args);
	}

}
