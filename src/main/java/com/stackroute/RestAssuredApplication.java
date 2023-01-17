package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.stackroute")
public class RestAssuredApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAssuredApplication.class, args);
	}

}
